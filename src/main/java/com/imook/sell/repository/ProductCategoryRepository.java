package com.imook.sell.repository;

import com.imook.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author KnoWsea
 * @create 2018-12-03 20:39
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory> findByCategoryNameIn(List<String> categoryList );
}

