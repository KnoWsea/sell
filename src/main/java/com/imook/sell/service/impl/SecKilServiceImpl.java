package com.imook.sell.service.impl;

import com.alibaba.fastjson.JSON;
import com.imook.sell.exception.SellException;
import com.imook.sell.service.RedisLock;
import com.imook.sell.service.SecKillService;
import com.imook.sell.utils.KeyUtil;
import okio.Timeout;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @author KnoWsea
 * @create 2019-01-26 23:14
 */
@Service
public class SecKilServiceImpl implements SecKillService , InitializingBean {

    private static final int TIMEOUT = 10*1000; //超时时间10秒

    private static final String threadId = "threadyId";

    @Autowired
    private RedisLock redisLock;

    @Autowired
    private StringRedisTemplate redisTemplate;

    static Map<String,Integer> products;
    static Map<String, String> orders;
    {
        orders = new HashMap<>();
        products = new HashMap<>();
        products.put("123456", 100000);
    }

    @Override
    public String queryMap(String productId) {
        return "活动,皮蛋瘦肉粥,限量份"
                + products.get(productId)
                +"还剩: " + redisTemplate.opsForValue().get(productId) + "份"
                + "该商品成功下单用户数目:"
                + orders.size() + " 人";
    }

    public String querySecKillProductInfo(String productId){
        return this.queryMap(productId);
    }

    @Override
    public void orderProductMockDiffUser(String productId) {
        //加锁
        long time = System.currentTimeMillis() + TIMEOUT;
        if(!redisLock.lock(System.currentTimeMillis() + 2000, threadId, String.valueOf(time))){
            throw new SellException(101, "哎呦喂,人也太多了,换个姿势再试试?");

        }

        //查询库存,为0则活动结束
        String value = redisTemplate.opsForValue().get(productId);
        Integer stockNum = Integer.valueOf(value);
        if(stockNum <= 0){
            throw new SellException(100,"库存已经不够，请下次光临。");
        }else{
            //下单,不同用户
            orders.put(KeyUtil.genUniqueKey(), productId);
            //减库存
            stockNum = stockNum - 1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            redisTemplate.opsForValue().set(productId, stockNum.toString());
        }

        //解锁
        redisLock.unlock(threadId, String.valueOf(time));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        redisTemplate.opsForValue().set("123456", "100000");
    }
}
