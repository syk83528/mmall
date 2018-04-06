package com.mmall.controller.backend;

import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.dao.CategoryMapper;
import com.mmall.pojo.Category;
import com.mmall.pojo.User;
import com.mmall.service.ICategoryService;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by syk on 2018/4/4.
 */
@Controller
@RequestMapping("/manage/category")
public class CategoryManagerController {

    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IUserService iUserService;


    @RequestMapping(value="add_category.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addCategory(HttpSession session,String categoryName,@RequestParam(value = "parentId",defaultValue = "0") int parentId) {
        //确认是否登录
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("您还未登录,请先登录");
        }
        //确认是否管理员
        if (!iUserService.checkAdminRole(user).isSuccess()) {
            return ServerResponse.createByErrorMessage("您没有管理员权限");
        }
        //add 逻辑
        return iCategoryService.addCategory(categoryName, parentId);
    }

    @RequestMapping(value="update_category_name.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateCategoryName(HttpSession session,String categoryNameNew,Integer categoryId) {
        //确认是否登录
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("您还未登录,请先登录");
        }
        //确认是否管理员
        if (!iUserService.checkAdminRole(user).isSuccess()) {
            return ServerResponse.createByErrorMessage("您没有管理员权限");
        }
        //add 逻辑
        return iCategoryService.updateCategoryName(categoryNameNew, categoryId);
    }

    @RequestMapping(value="get_children_category.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getChildrenCategory(HttpSession session,Integer parentId) {
        //确认是否登录
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("您还未登录,请先登录");
        }
        //确认是否管理员
        if (!iUserService.checkAdminRole(user).isSuccess()) {
            return ServerResponse.createByErrorMessage("您没有管理员权限");
        }
        //add 逻辑
        return iCategoryService.getChildrenCategory(parentId);
    }


    @RequestMapping(value="get_deep_category.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getChildrenAndDeepChildrenCategory(HttpSession session,Integer categoryId) {
        //确认是否登录
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("您还未登录,请先登录");
        }
        //确认是否管理员
        if (!iUserService.checkAdminRole(user).isSuccess()) {
            return ServerResponse.createByErrorMessage("您没有管理员权限");
        }
        //add 逻辑
        return iCategoryService.getDeepChildrenCategory(categoryId);
    }
}
