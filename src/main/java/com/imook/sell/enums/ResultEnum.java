package com.imook.sell.enums;

import lombok.Getter;

/**
 * @author KnoWsea
 * @create 2018-12-10 21:55
 */
@Getter
public enum ResultEnum {
    PARAM_ERROR(1, "参数不正确"),
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "商品库存不正确"),
    ORDER_NOT_EXIST(12, "订单不存在"),
    ORDERDETAIL_NOT_EXIST(13, "订单详情不存在"),
    ORDER_STATUS_ERROR(14, "订单状态不正确"),
    ORDER_UPDATE_FAIL(15, "订单更新失败"),
    ORDER_DEFAULT_EMPTY(16, "订单商品详情为空"),
    ORDER_PAYSTATUS_ERROR(17, "订单支付状态不正确"),
    CART_EMPTY(18, "购物车为空"),
    ORDER_OWNER_ERROR(19, "当前用户不是订单的拥有者"),

    ORDER_CANCEL_SUCCESS(20, "卖家取消订单成功"),
    ORDER_FINISH_SUCCESS(21, "卖家完结订单成功"),
    PRODUCT_STATUS_ERROR(22, "商品状态不正确"),
    PRODUCT_ON_SALE_SUCCESS(23, "商品上架成功"),
    PRODUCT_OFF_SALE_SUCCESS(24, "商品下架成功"),
    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(25, "微信支付异步通知"),
    WECHAT_MP_ERROR(26, "微信公众账号方面错误"),
    LOGIN_FAIL(27, "登录失败"),
    LOGOUT_SUCCESS(28, "登出成功"),
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
