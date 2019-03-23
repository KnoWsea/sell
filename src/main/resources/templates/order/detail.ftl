<html>
<#include "../common/header.ftl">
<body>
    <div id="wrapper" class="toggled">
        <#--边栏-->
        <#include "../common/nav.ftl">
        <#--主要内容-->
        <div id="page-content-wrapper">
            <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-hover table-bordered">
                        <thead>
                        <tr>
                            <th>
                                订单id
                            </th>
                            <th>
                                订单总金额
                            </th>

                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                            ${orderDTO.orderId}
                            </td>
                            <td>
                            ${orderDTO.orderAmount}
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            <#--订单详情表-->
                <div class="col-md-12 column">
                    <table class="table table-hover table-bordered">
                        <thead>
                        <tr>
                            <th>
                                商品id
                            </th>
                            <th>
                                商品名称
                            </th>
                            <th>
                                价格
                            </th>
                            <th>
                                数量
                            </th>
                            <th>
                                总额
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                <#list orderDTO.orderDetailList as list>
                <tr>
                    <td>
                        ${list.productId}
                    </td>
                    <td>
                        ${list.productName}
                    </td>
                    <td>
                        ${list.productId}
                    </td>
                    <td>
                        ${list.productPrice}
                    </td>
                    <td>
                        ${list.productQuantity}
                    </td>
                    <td>
                        ${list.productPrice * list.productQuantity}
                    </td>
                </tr>
                </#list>
                        </tbody>
                    </table>
                </div>

        <#if orderDTO.getOrderStatusEnum().message =="新订单">
                <div class="col-md-12 column">
                    <a href="/sell/seller/order/finish?orderId=${orderDTO.orderId}&page=${currentPage}&size=${size}" button type="button" class="btn btn-default btn-primary">完结订单</a></button>
                    <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}&page=${currentPage}&size=${size}" button type="button" class="btn btn-default btn-danger">取消订单</a></abutton>
                </div>
        </#if>
            </div>
        </div>
        </div>
    </div>

</body>
</html>