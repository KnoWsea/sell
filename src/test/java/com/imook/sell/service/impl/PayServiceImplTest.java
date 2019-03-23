package com.imook.sell.service.impl;

import com.imook.sell.dto.OrderDTO;
import com.imook.sell.service.OrderService;
import com.imook.sell.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author KnoWsea
 * @create 2019-01-06 20:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @Test
    public void create() {
        OrderDTO orderDTO = orderService.findOne("1546693469077588289");
        payService.create(orderDTO);
    }

    @Test
    public void refund(){
        OrderDTO orderDTO = orderService.findOne("1546917967533765029");
        payService.refund(orderDTO);
    }


}