package com.ruoyi.bs.student.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bs.student.mapper.AllStuTopicesMapper;
import com.ruoyi.bs.student.domain.AllStuTopices;
import com.ruoyi.bs.student.service.IAllStuTopicesService;

/**
 * 选题信息表Service业务层处理
 *
 * @author Ystarry
 * @date 2021-12-05
 */
@Service
public class AllStuTopicesServiceImpl implements IAllStuTopicesService
{
    @Autowired
    private AllStuTopicesMapper allStuTopicesMapper;

//    public AllStuTopicesServiceImpl(AllStuTopicesMapper allStuTopicesMapper) {
//        this.allStuTopicesMapper = allStuTopicesMapper;
//    }

    /**
     * 查询选题信息表
     *
     * @param id 选题信息表主键
     * @return 选题信息表
     */
    @Override
    public AllStuTopices selectAllStuTopicesById(Long id)
    {
        return allStuTopicesMapper.selectAllStuTopicesById(id);
    }

    /**
     * 查询选题信息表列表
     *
     * @param allStuTopices 选题信息表
     * @return 选题信息表
     */
    @Override
    public List<AllStuTopices> selectAllStuTopicesList(AllStuTopices allStuTopices)
    {
        return allStuTopicesMapper.selectAllStuTopicesList(allStuTopices);
    }

    /**
     * 新增选题信息表
     *
     * @param allStuTopices 选题信息表
     * @return 结果
     */
    @Override
    public int insertAllStuTopices(AllStuTopices allStuTopices)
    {
        return allStuTopicesMapper.insertAllStuTopices(allStuTopices);
    }

    /**
     * 修改选题信息表
     *
     * @param allStuTopices 选题信息表
     * @return 结果
     */
    @Override
    public int updateAllStuTopices(AllStuTopices allStuTopices)
    {
        return allStuTopicesMapper.updateAllStuTopices(allStuTopices);
    }

    /**
     * 查询当前学生是否选题
     */
    @Override
    public boolean selStuTopicinfo(String studentNo) {
        if (allStuTopicesMapper.selStuTopicinfo(studentNo) == null) {
            return false;
        }
        /**
         * 审核不通过继续选题
         */
        if (allStuTopicesMapper.selStuTopicinfo(studentNo) == "1"){
            return false;
        }
        return true;
    }

    /**
     * 查询当前课题是否有人选择
     */
    @Override
    public boolean selCurrentTopicStatus(Long id) {
        if (allStuTopicesMapper.selCurrentTopicStatus(id) == null) {
            return false;
        }
        return true;
    }

    /**
     * 批量删除选题信息表
     *
     * @param ids 需要删除的选题信息表主键
     * @return 结果
     */
    @Override
    public int deleteAllStuTopicesByIds(Long[] ids)
    {
        return allStuTopicesMapper.deleteAllStuTopicesByIds(ids);
    }

    /**
     * 删除选题信息表信息
     *
     * @param id 选题信息表主键
     * @return 结果
     */
    @Override
    public int deleteAllStuTopicesById(Long id)
    {
        return allStuTopicesMapper.deleteAllStuTopicesById(id);
    }
}
