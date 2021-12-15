package pers.sms.dao;

import pers.sms.bean.Admin;
import pers.sms.bean.LoginForm;

import java.util.List;

/**
 * @project: sms
 * @description: 数据访问层-操控管理员信息
 */
public interface AdminMapper {

    // TODO:验证登录信息是否正确
    Admin login(LoginForm loginForm);

    // TODO:通过姓名查询指定管理员信息
    Admin findByName(String name);

    // TODO:添加管理员信息
    int insert(Admin admin);

    // TODO: 根据姓名查询指定/所有管理员信息列表
    List<Admin> selectList(Admin admin);

    // TODO: 根据id更新指定管理员信息
    int update(Admin admin);

    // TODO:  根据id修改指定管理员密码
    int updatePassword(Admin admin);

    // TODO: 根据id删除指定管理员信息
    int deleteById(Integer[] ids);

}