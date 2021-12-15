package pers.sms.dao;

import pers.sms.bean.LoginForm;
import pers.sms.bean.Student;

import java.util.List;

/**
 * @project: sms
 * @description: 数据访问层-操控学生信息
 */
public interface StudentMapper {

    // TODO:验证登录信息是否正确
    Student login(LoginForm loginForm);

    // TODO:根据班级与学生名获取指定或全部学生信息列表
    List<Student> selectList(Student student);

    // TODO:根据学号查询指定学生信息
    Student findBySno(Student student);

    // TODO:添加班级信息
    int insert(Student student);

    // TODO:根据id修改指定学生信息
    int update(Student student);

    // TODO:根据id修改指定学生密码
    int updatePassword(Student student);

    // TODO:根据id删除指定学生信息
    int deleteById(Integer[] ids);

}
