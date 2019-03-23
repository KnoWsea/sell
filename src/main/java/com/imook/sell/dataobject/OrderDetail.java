package com.imook.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**订单详情
 * @author KnoWsea
 * @create 2018-12-10 18:43
 */
@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    /* 订单id */
    private String orderId;

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private String productIcon;
}
