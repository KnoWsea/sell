package com.imook.sell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**订单表单  用于表单验证
 * @author KnoWsea
 * @create 2018-12-22 19:24
 */
@Data
public class OrderForm {

    /* 卖家姓名 */
    @NotEmpty(message = "姓名必填")
    private String name;

    /* 买家电话 */
    @NotEmpty(message = "电话必填")
    private String phone;

    /* 买家地址 */
    @NotEmpty(message = "地址必填")
    private String address;

    /* 买家openid */
    @NotEmpty(message = "openid必填")
    private String openid;

    /* 买家商品 */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
