package com.ruoyi.bs.student.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bs.student.mapper.MyTopicMapper;
import com.ruoyi.bs.student.domain.MyTopic;
import com.ruoyi.bs.student.service.IMyTopicService;

/**
 * 选题信息表Service业务层处理
 *
 * @author Ystarry
 * @date 2021-11-22
 */
@Service
public class MyTopicServiceImpl implements IMyTopicService
{
    @Autowired
    private MyTopicMapper myTopicMapper;

    /**
     * 查询选题信息表
     *
     * @param id 选题信息表主键
     * @return 选题信息表
     */
    @Override
    public MyTopic selectMyTopicById(Long id)
    {
        return myTopicMapper.selectMyTopicById(id);
    }

    /**
     * 查询选题信息表列表
     *
     * @param myTopic 选题信息表
     * @return 选题信息表
     */
    @Override
    public List<MyTopic> selectMyTopicList(MyTopic myTopic)
    {
        return myTopicMapper.selectMyTopicList(myTopic);
    }

    /**
     * 查询当前用户的选题状态
     */
    public String selectMyTopicByStatus(String studentNo){
        return myTopicMapper.selectMyTopicByStatus(studentNo);
    }

    /**
     * 新增选题信息表
     *
     * @param myTopic 选题信息表
     * @return 结果
     */
    @Override
    public int insertMyTopic(MyTopic myTopic)
    {
        return myTopicMapper.insertMyTopic(myTopic);
    }

    /**
     * 修改选题信息表
     *
     * @param myTopic 选题信息表
     * @return 结果
     */
    @Override
    public int updateMyTopic(MyTopic myTopic)
    {
        return myTopicMapper.updateMyTopic(myTopic);
    }

    /**
     * 批量删除选题信息表
     *
     * @param ids 需要删除的选题信息表主键
     * @return 结果
     */
    @Override
    public int deleteMyTopicByIds(Long[] ids)
    {
        return myTopicMapper.deleteMyTopicByIds(ids);
    }

    /**
     * 删除选题信息表信息
     *
     * @param id 选题信息表主键
     * @return 结果
     */
    @Override
    public int deleteMyTopicById(Long id)
    {
        return myTopicMapper.deleteMyTopicById(id);
    }
}
