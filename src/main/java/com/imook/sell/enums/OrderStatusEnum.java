package com.imook.sell.enums;

import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.Getter;

/**
 * @author KnoWsea
 * @create 2018-12-10 18:31
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{
    NEW(0,"新订单"),
        FINISHED(1,"完结"),
            CANCEL(2,"已取消"),
                    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static OrderStatusEnum getOrderStatusEnum(Integer code){
        for (OrderStatusEnum value : OrderStatusEnum.values()) {
            if(code.equals(value.getCode()))
                return value;
        }
        return null;
    }
}
