package com.imook.sell.controller;

import com.imook.sell.dataobject.ProductCategory;
import com.imook.sell.dataobject.ProductInfo;
import com.imook.sell.service.CategoryService;
import com.imook.sell.service.ProductService;
import com.imook.sell.utils.ResultVOUtil;
import com.imook.sell.vo.ProductInfoVO;
import com.imook.sell.vo.ProductVO;
import com.imook.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author KnoWsea
 * @create 2018-12-07 20:00
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    
    @Autowired
    private  ProductService productService;
    
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/list")
    @Cacheable(cacheNames = "product", key = "123")
//    @Cacheable(cacheNames = "product", key = "#sellerId", condition = "#sellerId.length()>3",unless = "#result.getCode() != 0")
    public ResultVO list(){
        //1.查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        
        //2.查询类目(一次性 查询)
        //传统方法
//        List<Integer> categoryTypeList = new ArrayList();
//        for (ProductInfo productInfo : productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }

        //找到所有商品对应的类目名字(重复)
        List<String> categoryNameList = productInfoList.stream()
                .map(e -> e.getCategoryName())
                .collect(Collectors.toList());
        //去重
        List<ProductCategory> productCategoryList = categoryService.findByCategoryNameIn(categoryNameList);

        //3.数据拼装
        ArrayList<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setProductName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if(productInfo.getCategoryName().equals(productCategory.getCategoryName())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
