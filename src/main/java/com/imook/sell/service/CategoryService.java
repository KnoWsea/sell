package com.imook.sell.service;

import com.imook.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @author KnoWsea
 * @create 2018-12-06 19:40
 */
public interface CategoryService {
    ProductCategory findOne(Integer category);
    List<ProductCategory> findAll();
    //用来去重
    List<ProductCategory> findByCategoryNameIn(List<String> categoryNameList);
    ProductCategory save(ProductCategory productCategory);
}
