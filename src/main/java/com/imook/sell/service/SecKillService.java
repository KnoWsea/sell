package com.imook.sell.service;

/**
 * @author KnoWsea
 * @create 2019-02-26 23:12
 */
public interface SecKillService {
    String queryMap(String productId);
    String querySecKillProductInfo(String productId);
    void orderProductMockDiffUser(String productId);
}
