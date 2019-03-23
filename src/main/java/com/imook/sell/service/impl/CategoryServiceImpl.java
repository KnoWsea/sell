package com.imook.sell.service.impl;

import com.imook.sell.dataobject.ProductCategory;
import com.imook.sell.repository.ProductCategoryRepository;
import com.imook.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author KnoWsea
 * @create 2018-12-06 19:42
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findById(categoryId).orElse(null);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryNameIn(List<String> categoryNameList) {
        return repository.findByCategoryNameIn(categoryNameList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
