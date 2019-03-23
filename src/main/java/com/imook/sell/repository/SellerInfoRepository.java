package com.imook.sell.repository;

import com.imook.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author KnoWsea
 * @create 2019-01-01 19:13
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByUsernameAndPassword(String username, String password);
}
