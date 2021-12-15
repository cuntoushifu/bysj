package pers.sms.dao;

import pers.sms.bean.Grade;

import java.util.List;

/**
 * @project: sms
 * @description: 数据访问层-操控年级信息
 */
public interface GradeMapper {

    // TODO:根据年级名称查询指定/全部年级信息列表
    List<Grade> selectList(Grade gradename);

    // TODO:查询所有年级信息列表(用于在班级管理页面中获取年级信息)
    List<Grade> selectAll();

    // TODO:根据年级名称查询指定的年级信息
    Grade findByName(String gradename);

    // TODO:添加年级信息
    int insert(Grade grade);

    // TODO:根据id修改指定年级信息
    int update(Grade grade);

    // TODO:根据id删除指定年级信息
    int deleteById(Integer[] ids);
}
