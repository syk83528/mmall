package com.mmall.service;

import com.mmall.common.ServerResponse;

/**
 * Created by syk on 2018/4/4.
 */
public interface ICategoryService {
    ServerResponse addCategory(String categoryName, Integer parentId);
}
