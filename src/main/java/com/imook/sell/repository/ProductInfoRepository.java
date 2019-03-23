package com.imook.sell.repository;

import com.imook.sell.dataobject.ProductInfo;
import org.hibernate.validator.constraints.EAN;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author KnoWsea
 * @create 2018-12-06 20:31
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    //通过订单状态来查询信息，用来上架商品
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
