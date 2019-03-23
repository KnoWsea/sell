package com.imook.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author KnoWsea
 * @create 2018-12-09 20:28
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = -5340383862205934273L;
    @JsonProperty("name")
    private String productName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
