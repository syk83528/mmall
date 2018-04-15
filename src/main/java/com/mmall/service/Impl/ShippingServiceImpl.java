package com.mmall.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.mmall.common.ServerResponse;
import com.mmall.dao.ShippingMapper;
import com.mmall.pojo.Shipping;
import com.mmall.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("iShippingService")
public class ShippingServiceImpl implements IShippingService{

    @Autowired
    private ShippingMapper shippingMapper;

    public ServerResponse add(Integer userId, Shipping shipping) {
        //1.塞入用户
        shipping.setUserId(userId);

        //2.插入
        int rowCount = shippingMapper.insert(shipping);
        if (rowCount >0) {
            Map result =Maps.newHashMap();
            result.put("shippingId",shipping.getId());
            return ServerResponse.createBySuccess("添加地址成功",result);
        }else {
            return ServerResponse.createByErrorMessage("添加失败");
        }

    }


    public ServerResponse delete(Integer userId,Integer shippingId) {
        //2.插入
        int rowCount = shippingMapper.deleteByUserIdShippingId(userId,shippingId);
        if (rowCount >0) {
            return ServerResponse.createBySuccess("删除地址成功");
        }else {
            return ServerResponse.createByErrorMessage("删除地址失败");
        }
    }

    public ServerResponse update(Integer userId,Shipping shipping) {
        //1.塞入用户
        shipping.setUserId(userId);
        //2.更新
        int rowCount = shippingMapper.updateByPrimaryKeySelective(shipping);
        if (rowCount >0) {
            return ServerResponse.createBySuccess("更新地址成功");
        }else {
            return ServerResponse.createByErrorMessage("更新地址失败");
        }
    }


    public ServerResponse select(Integer userId,Integer shippingId) {

        //2.更新
        Shipping shipping = shippingMapper.selectByUserIdShippingId(userId, shippingId);
        if (shipping != null) {
            return ServerResponse.createBySuccess("查询成功",shipping);
        }else {
            return ServerResponse.createByErrorMessage("查询失败");
        }
    }


    public ServerResponse list(Integer userId,Integer pageSize,Integer pageNum) {

        //1.开启
        PageHelper.startPage(pageNum,pageSize);

        //2.查询
        List<Shipping> shippings = shippingMapper.selectByUserId(userId);
        //3.塞入page
        PageInfo<Shipping> pageInfo = new PageInfo<>(shippings);


        return ServerResponse.createBySuccess("成功",pageInfo);
    }


}
