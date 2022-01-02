package com.ruoyi.bs.admin.service;

import java.util.List;
import com.ruoyi.bs.admin.domain.AdStudent;

/**
 * 学生表Service接口
 *
 * @author Ystarry
 * @date 2021-12-01
 */
public interface IAdStudentService
{
    /**
     * 查询学生表
     *
     * @param id 学生表主键
     * @return 学生表
     */
    public AdStudent selectAdStudentById(Long id);


    /**
     * 学生学号检索
     * @param studentNo
     * @return
     */
    public AdStudent selectAdStudentByStudentNo(String studentNo);

    /**
     * 查询学生表列表
     *
     * @param adStudent 学生表
     * @return 学生表集合
     */
    public List<AdStudent> selectAdStudentList(AdStudent adStudent);

    /**
     * 新增学生表
     *
     * @param adStudent 学生表
     * @return 结果
     */
    public int insertAdStudent(AdStudent adStudent);

    /**
     * 修改学生表
     *
     * @param adStudent 学生表
     * @return 结果
     */
    public int updateAdStudent(AdStudent adStudent);

    /**
     * 批量删除学生表
     *
     * @param ids 需要删除的学生表主键集合
     * @return 结果
     */
    public int deleteAdStudentByIds(Long[] ids);

    /**
     * 删除学生表信息
     *
     * @param id 学生表主键
     * @return 结果
     */
    public int deleteAdStudentById(Long id);
}
