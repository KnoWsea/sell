package com.imook.sell.enums;

import lombok.Getter;

/**
 * @author KnoWsea
 * @create 2018-12-10 18:39
 */
@Getter
public enum PayStatusEnum implements CodeEnum{
    WAIT(0,"未支付"),
    SUCCESS(1,"支付成功"),
    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static PayStatusEnum getPayStatusEnum(Integer code){
        for (PayStatusEnum payStatusEnum : PayStatusEnum.values()) {
            if(code.equals(payStatusEnum.getCode()))
                return payStatusEnum;
        }
        return null;
    }
}
