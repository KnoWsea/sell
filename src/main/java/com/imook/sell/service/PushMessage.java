package com.imook.sell.service;

import com.imook.sell.dto.OrderDTO;

/**
 * @author KnoWsea
 * @create 2019-01-13 18:58
 */
public interface PushMessage {

    void orderStatus(OrderDTO orderDTO);
}
