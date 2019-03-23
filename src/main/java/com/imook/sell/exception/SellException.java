package com.imook.sell.exception;

import com.imook.sell.enums.ResultEnum;
import lombok.Getter;

/**
 * @author KnoWsea
 * @create 2018-12-10 21:54
 */
@Getter
public class SellException extends RuntimeException{
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());//为什么super这样写法
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message){
        super(message);
        this.code = code;

    }
}
