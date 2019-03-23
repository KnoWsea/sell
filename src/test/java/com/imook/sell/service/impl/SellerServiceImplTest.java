package com.imook.sell.service.impl;

import com.imook.sell.dataobject.SellerInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author KnoWsea
 * @create 2019-01-01 19:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest {

    private final static String openid = "abc";

    @Autowired
    private SellerServiceImpl sellerService;

    @Test
    public void findSelllerInfoByOpenid() {
    }
}