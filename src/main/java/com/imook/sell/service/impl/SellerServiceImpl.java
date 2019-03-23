package com.imook.sell.service.impl;

import com.imook.sell.dataobject.SellerInfo;
import com.imook.sell.repository.SellerInfoRepository;
import com.imook.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author KnoWsea
 * @create 2019-01-01 19:33
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByUsernameAndPassword(String username, String password) {
        return repository.findByUsernameAndPassword(username, password);
    }
}
