package com.ruoyi.bs.teacher.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bs.teacher.mapper.TeaStudentMapper;
import com.ruoyi.bs.teacher.domain.TeaStudent;
import com.ruoyi.bs.teacher.service.ITeaStudentService;

/**
 * 学生表Service业务层处理
 * 
 * @author Ystarry
 * @date 2021-11-23
 */
@Service
public class TeaStudentServiceImpl implements ITeaStudentService 
{
    @Autowired
    private TeaStudentMapper teaStudentMapper;

    /**
     * 查询学生表
     * 
     * @param id 学生表主键
     * @return 学生表
     */
    @Override
    public TeaStudent selectTeaStudentById(Long id)
    {
        return teaStudentMapper.selectTeaStudentById(id);
    }

    /**
     * 查询学生表列表
     * 
     * @param teaStudent 学生表
     * @return 学生表
     */
    @Override
    public List<TeaStudent> selectTeaStudentList(TeaStudent teaStudent)
    {
        return teaStudentMapper.selectTeaStudentList(teaStudent);
    }

    /**
     * 新增学生表
     * 
     * @param teaStudent 学生表
     * @return 结果
     */
    @Override
    public int insertTeaStudent(TeaStudent teaStudent)
    {
        return teaStudentMapper.insertTeaStudent(teaStudent);
    }

    /**
     * 修改学生表
     * 
     * @param teaStudent 学生表
     * @return 结果
     */
    @Override
    public int updateTeaStudent(TeaStudent teaStudent)
    {
        return teaStudentMapper.updateTeaStudent(teaStudent);
    }

    /**
     * 批量删除学生表
     * 
     * @param ids 需要删除的学生表主键
     * @return 结果
     */
    @Override
    public int deleteTeaStudentByIds(Long[] ids)
    {
        return teaStudentMapper.deleteTeaStudentByIds(ids);
    }

    /**
     * 删除学生表信息
     * 
     * @param id 学生表主键
     * @return 结果
     */
    @Override
    public int deleteTeaStudentById(Long id)
    {
        return teaStudentMapper.deleteTeaStudentById(id);
    }
}
