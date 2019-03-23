package com.imook.sell.service.impl;

import com.imook.sell.dto.OrderDTO;
import com.imook.sell.enums.ResultEnum;
import com.imook.sell.exception.SellException;
import com.imook.sell.service.BuyerService;
import com.imook.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

/**
 * @author KnoWsea
 * @create 2018-12-24 19:38
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    public OrderDTO findOrderOne(String openid, String orderId) {
             return checkOrderOwner(openid,orderId);
         }

    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if(orderDTO == null){
            log.error("[取消订单] 订单不存在,orderDTO={}",orderDTO);
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId){
        OrderDTO orderDTO = orderService.findOne(orderId);
        System.out.println("========"+!openid.equals(orderDTO.getBuyerOpenid()));
        if(orderDTO == null) {
            return null;
        }
        if(!openid.equals(orderDTO.getBuyerOpenid())){
            log.error("[查询订单] 订单的openid不一致，openid={}，orderDTO={}",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
