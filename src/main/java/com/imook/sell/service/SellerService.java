package com.imook.sell.service;

import com.imook.sell.dataobject.SellerInfo;

/**
 * @author KnoWsea
 * @create 2019-01-01 19:30
 */
public interface SellerService {

    SellerInfo findSellerInfoByUsernameAndPassword(String username, String password);

}

