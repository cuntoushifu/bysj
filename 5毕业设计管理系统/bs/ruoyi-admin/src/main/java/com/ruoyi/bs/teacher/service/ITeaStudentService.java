package com.ruoyi.bs.teacher.service;

import java.util.List;
import com.ruoyi.bs.teacher.domain.TeaStudent;

/**
 * 学生表Service接口
 * 
 * @author Ystarry
 * @date 2021-11-23
 */
public interface ITeaStudentService 
{
    /**
     * 查询学生表
     * 
     * @param id 学生表主键
     * @return 学生表
     */
    public TeaStudent selectTeaStudentById(Long id);

    /**
     * 查询学生表列表
     * 
     * @param teaStudent 学生表
     * @return 学生表集合
     */
    public List<TeaStudent> selectTeaStudentList(TeaStudent teaStudent);

    /**
     * 新增学生表
     * 
     * @param teaStudent 学生表
     * @return 结果
     */
    public int insertTeaStudent(TeaStudent teaStudent);

    /**
     * 修改学生表
     * 
     * @param teaStudent 学生表
     * @return 结果
     */
    public int updateTeaStudent(TeaStudent teaStudent);

    /**
     * 批量删除学生表
     * 
     * @param ids 需要删除的学生表主键集合
     * @return 结果
     */
    public int deleteTeaStudentByIds(Long[] ids);

    /**
     * 删除学生表信息
     * 
     * @param id 学生表主键
     * @return 结果
     */
    public int deleteTeaStudentById(Long id);
}
