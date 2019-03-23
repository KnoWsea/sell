package com.imook.sell.service;

import com.imook.sell.dataobject.ProductInfo;
import com.imook.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author KnoWsea
 * @create 2018-12-06 21:49
 */

public interface ProductService {
    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

//    //加库存
    void increaseStock(List<CartDTO> cartDTOList);
//    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //上架
    ProductInfo onSale(String productId);

    //下架
    ProductInfo offsale(String productId);
}
