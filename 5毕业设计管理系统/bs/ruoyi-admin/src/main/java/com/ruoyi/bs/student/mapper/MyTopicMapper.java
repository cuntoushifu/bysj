package com.ruoyi.bs.student.mapper;

import java.util.List;
import com.ruoyi.bs.student.domain.MyTopic;
import org.apache.ibatis.annotations.Mapper;

/**
 * 选题信息表Mapper接口
 *
 * @author Ystarry
 * @date 2021-11-22
 */
@Mapper
public interface MyTopicMapper
{
    /**
     * 查询选题信息表
     *
     * @param id 选题信息表主键
     * @return 选题信息表
     */
    public MyTopic selectMyTopicById(Long id);

    /**
     * 查询当前用户的选题状态
     */
    public String selectMyTopicByStatus(String studentNo);

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
     * 修改选题信息表
     *
     * @param myTopic 选题信息表
     * @return 结果
     */
    public int updateMyTopic(MyTopic myTopic);

    /**
     * 删除选题信息表
     *
     * @param id 选题信息表主键
     * @return 结果
     */
    public int deleteMyTopicById(Long id);

    /**
     * 批量删除选题信息表
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMyTopicByIds(Long[] ids);
}
