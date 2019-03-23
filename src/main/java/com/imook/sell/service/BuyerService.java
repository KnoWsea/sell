package com.imook.sell.service;

import com.imook.sell.dto.OrderDTO;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

/**用于订单验证并且返回订单
 * @author KnoWsea
 * @create 2018-12-24 19:36
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);

}
