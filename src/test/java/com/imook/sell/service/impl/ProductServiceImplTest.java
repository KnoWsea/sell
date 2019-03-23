package com.imook.sell.service.impl;

import com.imook.sell.dataobject.ProductInfo;
import com.imook.sell.repository.ProductInfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author KnoWsea
 * @create 2018-12-06 22:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo one = productService.findOne("123455");
        Assert.assertEquals("123455",one.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = productService.findUpAll();
        Assert.assertNotEquals(0,upAll.size());
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<ProductInfo> all = productService.findAll(pageRequest);
        System.out.println(all.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(4.5));
        productInfo.setProductStock(120);
        productInfo.setProductDescription("很好吃的虾");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryName("2");
        ProductInfo save = productService.save(productInfo);
        Assert.assertNotNull(save);
    }

    @Test
    public void onsale(){
        ProductInfo productInfo = productService.onSale("123455");
        Assert.assertNotEquals(new Integer(0), productInfo.getProductStatus());
    }
    @Test
    public void offsale(){
        ProductInfo productInfo = productService.offsale("123455");
        Assert.assertNotEquals(new Integer(0), productInfo.getProductStatus());
    }



}
