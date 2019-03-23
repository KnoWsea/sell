package com.imook.sell.service;


import com.imook.sell.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * @author KnoWsea
 * @create 2018-12-10 21:21
 */
public interface PayService {

      //创建付款
      PayResponse create(OrderDTO orderDTO);

      //提醒
      PayResponse notify(String notifyData);

      //退款
      RefundResponse refund(OrderDTO orderdto);
}
