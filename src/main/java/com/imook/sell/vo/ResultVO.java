package com.imook.sell.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

//import sun.plugin2.message.Serializer;

import java.io.Serializable;

/**结果集
 * @author KnoWsea
 * @create 2018-12-07 20:03
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 1873265642282595313L;
    private Integer code;
    private String msg;
    private T data;

}
