package com.mmall.controller.backend;

import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by syk on 2018/4/6.
 */
@Controller
@RequestMapping("/manage/product")
public class ProductManagerController {
    @Autowired
    private IUserService iUserService;
    public ServerResponse productSave(HttpSession session, Product product) {
        //确认是否登录
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("您还未登录,请先登录");
        }
        //确认是否管理员
        if (!iUserService.checkAdminRole(user).isSuccess()) {
            return ServerResponse.createByErrorMessage("您没有管理员权限");
        }


        return  null;
    }
}
