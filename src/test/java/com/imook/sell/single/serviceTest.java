package com.imook.sell.single;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author KnoWsea
 * @create 2019-03-17 9:47
 */
public class serviceTest {

    @Autowired
    private service service;

    @Test
    public void getapple() {
        service.getApple();
    }
}