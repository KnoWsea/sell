package com.imook.sell.converter;

import com.imook.sell.dataobject.OrderMaster;
import com.imook.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**将orderMasterList转化成orderDtoList,用户查询订单的时候使用
 * @author KnoWsea
 * @create 2018-12-13 22:43
 */
public class OrderMasterToOrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(t-> convert(t)).collect(Collectors.toList());
    }
}
