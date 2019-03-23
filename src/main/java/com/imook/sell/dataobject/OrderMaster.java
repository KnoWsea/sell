package com.imook.sell.dataobject;

import com.imook.sell.enums.OrderStatusEnum;
import com.imook.sell.enums.PayStatusEnum;
import com.thoughtworks.xstream.converters.basic.BigDecimalConverter;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**订单
 * @author KnoWsea
 * @create 2018-12-10 18:28
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    @Id
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

}
