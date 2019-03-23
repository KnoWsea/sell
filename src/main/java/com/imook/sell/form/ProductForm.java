package com.imook.sell.form;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imook.sell.enums.ProductStatusEnum;
import com.imook.sell.utils.EnumUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author KnoWsea
 * @create 2019-01-01 14:40
 */
@Data
public class ProductForm {
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private String categoryName;

}
