package com.imook.sell.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imook.sell.dataobject.OrderDetail;
import com.imook.sell.enums.OrderStatusEnum;
import com.imook.sell.enums.PayStatusEnum;
import com.imook.sell.utils.EnumUtil;
import com.imook.sell.utils.serializer.DateToLongSerializer;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author KnoWsea
 * @create 2018-12-10 21:40
 */
@Data
//@JsonSerialize(include = )
//如果返回的json数据为null就不返回这个字段
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    /**订单编号**/
    private String orderId;

    /**买家名字**/
    private String buyerName;

    /* 买家电话*/
    private String buyerPhone;

    /* 买家地址 */
    private String buyerAddress;

    /*买家微信Openid*/
    private String buyerOpenid;

    /*订单总金额*/
    private BigDecimal orderAmount;

    /*订单状态,默认为0新下单*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /*支付状态,默认为0未支付*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = DateToLongSerializer.class)
    private Date updateTime;

    //详情列表
    List<OrderDetail> orderDetailList;

    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
