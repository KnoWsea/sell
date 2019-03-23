package com.imook.sell.repository;

import com.imook.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;



/**
 * @author KnoWsea
 * @create 2018-12-03 20:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;


    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findById(1).get();
        System.out.println(productCategory.toString());
    }
    @Test
    public void saveTest(){
        ProductCategory productCategory = repository.findById(2).get();
        productCategory.setCategoryType(4);
        repository.save(productCategory);
    }
    @Test
    @Transactional
    public void addOneTest(){
        ProductCategory productCategory = new ProductCategory("renyao最爱",6);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
    }
//    @Test
//    public void findByCategoryTypeInTest(){
//        List<Integer> list = Arrays.asList(2,3,4);
//        List<ProductCategory> result = repository.findByCategoryNameIn(list);
//        Assert.assertNotEquals(0,result.size());
//    }
}