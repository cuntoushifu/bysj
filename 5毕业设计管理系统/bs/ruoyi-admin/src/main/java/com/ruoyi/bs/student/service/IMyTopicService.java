package com.ruoyi.bs.student.service;

import java.util.List;
import com.ruoyi.bs.student.domain.MyTopic;

/**
 * 选题信息表Service接口
 *
 * @author Ystarry
 * @date 2021-11-22
 */
public interface IMyTopicService
{
    /**
     * 查询选题信息表
     *
     * @param id 选题信息表主键
     * @return 选题信息表
     */
    public MyTopic selectMyTopicById(Long id);

    /**
     * 查询选题信息表列表
     *
     * @param myTopic 选题信息表
     * @return 选题信息表集合
     */
    public List<MyTopic> selectMyTopicList(MyTopic myTopic);

    /**
     * 新增选题信息表
     *
     * @param myTopic 选题信息表
     * @return 结果
     */
    public int insertMyTopic(MyTopic myTopic);

    /**
     * 查询当前用户的选题状态
     */
    public String selectMyTopicByStatus(String studentNo);

    /**
     * 修改选题信息表
     *
     * @param myTopic 选题信息表
     * @return 结果
     */
    public int updateMyTopic(MyTopic myTopic);

    /**
     * 批量删除选题信息表
     *
     * @param ids 需要删除的选题信息表主键集合
     * @return 结果
     */
    public int deleteMyTopicByIds(Long[] ids);

    /**
     * 删除选题信息表信息
     *
     * @param id 选题信息表主键
     * @return 结果
     */
    public int deleteMyTopicById(Long id);
}
