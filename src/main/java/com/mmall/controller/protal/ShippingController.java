package com.mmall.controller.protal;

import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Shipping;
import com.mmall.pojo.User;
import com.mmall.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/shipping/")
public class ShippingController {

    @Autowired
    private IShippingService iShippingService;

    /*
     * 新增地址
     * */
    @RequestMapping(value = "add.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse add(HttpSession session, Shipping shipping) {
        //判断登录权限
        //确认是否登录
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("您还未登录,请先登录");
        }

        return iShippingService.add(user.getId(), shipping);
    }
    /*
     * 删除地址
     * */
    @RequestMapping(value = "delete.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse delete(HttpSession session, Integer shippinId) {
        //判断登录权限
        //确认是否登录
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("您还未登录,请先登录");
        }
        return iShippingService.delete(user.getId(), shippinId);
    }
    /*
     * 更新地址
     * */
    @RequestMapping(value = "update.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse update(HttpSession session, Shipping shipping) {
        //判断登录权限
        //确认是否登录
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("您还未登录,请先登录");
        }
        return iShippingService.update(user.getId(),shipping);
    }
    /*
     * 查询地址
     * */
    @RequestMapping(value = "select.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse select(HttpSession session, Integer shippingId) {
        //判断登录权限
        //确认是否登录
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("您还未登录,请先登录");
        }
        return iShippingService.select(user.getId(),shippingId);
    }
    /*
     * 查询地址
     * */
    @RequestMapping(value = "list.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse list(HttpSession session, @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum) {
        //判断登录权限
        //确认是否登录
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("您还未登录,请先登录");
        }
        return iShippingService.list(user.getId(),pageSize,pageNum);
    }
}
