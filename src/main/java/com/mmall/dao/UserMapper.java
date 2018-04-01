package com.mmall.dao;

import com.mmall.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

//    判断用户名
    int checkUsername(String username);
    //判断email
    int checkEmail(String email);

    //登录
    User selectLogin(@Param("username") String username,@Param("password") String password);

    //找回密码问题
    String selectQuestionByUsername(String username);

    //找回密码答案
    int checkAnswer(@Param("username") String username,@Param("question") String question,@Param("answer") String answer);

    int updatePasswordByUsername(@Param("username") String username,@Param("passwordNew") String passwordNew);
}