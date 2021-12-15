package pers.sms.dao;

import pers.sms.bean.Clazz;

import java.util.List;

/**
 * @project: sms
 * @description: 数据访问层-操控班级信息
 */
public interface ClazzMapper {

    // TODO:根据班级名称获取指定/全部班级信息列表
    List<Clazz> selectList(Clazz clazz);

    // TODO:查询所有班级列表信息(用于在学生管理页面中获取班级信息)
    List<Clazz> selectAll();

    // TODO:获取指定名称的班级信息
    Clazz findByName(String name);

    // TODO:添加班级信息
    int insert(Clazz clazz);

    // TODO:根据id删除指定班级信息
    int deleteById(Integer[] ids);

    // TODO:根据id修改指定班级信息
    int update(Clazz clazz);

}
