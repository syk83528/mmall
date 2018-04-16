package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.vo.ProductDetailVo;

/**
 * Created by syk on 2018/4/9.
 */
public interface IProductService {
    ServerResponse saveOrUpdateProduct(Product product);

    ServerResponse<String> setSaleStatus(Integer productId,Integer status);
    ServerResponse<ProductDetailVo> managerProductDetail(Integer productId);
    ServerResponse getProductList(Integer pageNum,Integer pageSize);

    ServerResponse getSykProduct();
}
