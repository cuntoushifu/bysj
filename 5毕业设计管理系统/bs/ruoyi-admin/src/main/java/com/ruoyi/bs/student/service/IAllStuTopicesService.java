package com.ruoyi.bs.student.service;

import java.util.List;
import com.ruoyi.bs.student.domain.AllStuTopices;

/**
 * 选题信息表Service接口
 *
 * @author Ystarry
 * @date 2021-12-05
 */
public interface IAllStuTopicesService
{
    /**
     * 查询选题信息表
     *
     * @param id 选题信息表主键
     * @return 选题信息表
     */
    public AllStuTopices selectAllStuTopicesById(Long id);

    /**
     * 查询选题信息表列表
     *
     * @param allStuTopices 选题信息表
     * @return 选题信息表集合
     */
    public List<AllStuTopices> selectAllStuTopicesList(AllStuTopices allStuTopices);

    /**
     * 新增选题信息表
     *
     * @param allStuTopices 选题信息表
     * @return 结果
     */
    public int insertAllStuTopices(AllStuTopices allStuTopices);

    /**
     * 修改选题信息表
     *
     * @param allStuTopices 选题信息表
     * @return 结果
     */
    public int updateAllStuTopices(AllStuTopices allStuTopices);

    /**
     * 查询当前学生是否选题
     */
    public boolean selStuTopicinfo(String studentNo);

    /**
     * 查询当前课题是否有人选择
     */
    public boolean selCurrentTopicStatus(Long id);

    /**
     * 批量删除选题信息表
     *
     * @param ids 需要删除的选题信息表主键集合
     * @return 结果
     */
    public int deleteAllStuTopicesByIds(Long[] ids);

    /**
     * 删除选题信息表信息
     *
     * @param id 选题信息表主键
     * @return 结果
     */
    public int deleteAllStuTopicesById(Long id);
}
