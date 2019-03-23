<html>
    <#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
<#--边栏sidebar-->
<#include "../common/nav.ftl">

<#--主要内容-->
    <div id="="page-content-wrapper">
    <div class="container-fluid">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <form role="form" method="post" action="/sell/seller/product/save">
                    <div class="form-group">
                        <label>名称</label>
                        <input name="productName" type="text" class="form-control" value="${(productInfo.productName)!""}" />
                    </div>
                    <div class="form-group">
                        <label>单价</label>
                        <input name="productPrice" type="number" class="form-control" value="${(productInfo.productPrice)!""}" />
                    </div>
                    <div class="form-group">
                        <label>库存</label>
                        <input name="productStock" type="number" class="form-control" value="${(productInfo.productStock)!""}" />
                    </div>
                    <div class="form-group">
                        <label>商品描述</label>
                        <input name="productDescription" type="text" class="form-control" value="${(productInfo.productDescription)!""}" />
                    </div>
                    <div class="form-group">
                        <label>图片</label>
                        <img height="100" width="100" src="${(productInfo.productIcon)!}" alt="">
                        <input name="productIcon" type="text" class="form-control" value="${(productInfo.productIcon)!""}" />
                    </div>
                    <div class="form-group">
                        <label>类目</label>
                        <select name="categoryName" class="form-control">
                                <#list categoryList as category>
                                    <option value="${category.categoryName}"
                                            <#if (productInfo.categoryName)?? && productInfo.categoryName == category.categoryName>
                                                selected
                                            </#if>
                                    >${category.categoryName}
                                    </option>
                                </#list>
                        </select>
                    </div>
                    <input hidden type="text" name="productId" value="${(productInfo.productId)!""}">
                    <button type="submit" class="btn btn-default">提交</button>
                </form>
            </div>
        </div>
    </div>

</div>
</body>
</html>