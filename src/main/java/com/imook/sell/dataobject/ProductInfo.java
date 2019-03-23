package com.imook.sell.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imook.sell.enums.ProductStatusEnum;
import com.imook.sell.utils.EnumUtil;
import lombok.Data;
import org.apache.commons.lang3.EnumUtils;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**商品信息
 * @author KnoWsea
 * @create 2018-12-06 20:28
 */
@Entity
@Data
public class ProductInfo implements Serializable {


    private static final long serialVersionUID = 1465783600994575503L;
    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus = ProductStatusEnum.UP.getCode();

    private String categoryName;



    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
    }
}
