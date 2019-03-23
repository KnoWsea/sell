package com.imook.sell.enums;

import lombok.Getter;

/**
 * @author KnoWsea
 * @create 2018-12-06 21:57
 */
@Getter
public enum  ProductStatusEnum implements CodeEnum{
    UP(0,"在架"),
    DOWN(1,"下架");
    private Integer code;
    private String message;
    ProductStatusEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }
}
