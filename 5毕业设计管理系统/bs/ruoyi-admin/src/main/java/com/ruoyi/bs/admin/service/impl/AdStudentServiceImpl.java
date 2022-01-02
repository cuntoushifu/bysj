package com.ruoyi.bs.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bs.admin.mapper.AdStudentMapper;
import com.ruoyi.bs.admin.domain.AdStudent;
import com.ruoyi.bs.admin.service.IAdStudentService;

/**
 * 学生表Service业务层处理
 *
 * @author Ystarry
 * @date 2021-12-01
 */
@Service
public class AdStudentServiceImpl implements IAdStudentService
{
    @Autowired
    private AdStudentMapper adStudentMapper;

    /**
     * 查询学生表
     *
     * @param id 学生表主键
     * @return 学生表
     */
    @Override
    public AdStudent selectAdStudentById(Long id)
    {
        return adStudentMapper.selectAdStudentById(id);
    }

    public AdStudent selectAdStudentByStudentNo(String studentNo){
        return adStudentMapper.selectAdStudentByStudentNo(studentNo);
    }

    /**
     * 查询学生表列表
     *
     * @param adStudent 学生表
     * @return 学生表
     */
    @Override
    public List<AdStudent> selectAdStudentList(AdStudent adStudent)
    {
        return adStudentMapper.selectAdStudentList(adStudent);
    }

    /**
     * 新增学生表
     *
     * @param adStudent 学生表
     * @return 结果
     */
    @Override
    public int insertAdStudent(AdStudent adStudent)
    {
        return adStudentMapper.insertAdStudent(adStudent);
    }

    /**
     * 修改学生表
     *
     * @param adStudent 学生表
     * @return 结果
     */
    @Override
    public int updateAdStudent(AdStudent adStudent)
    {
        return adStudentMapper.updateAdStudent(adStudent);
    }

    /**
     * 批量删除学生表
     *
     * @param ids 需要删除的学生表主键
     * @return 结果
     */
    @Override
    public int deleteAdStudentByIds(Long[] ids)
    {
        return adStudentMapper.deleteAdStudentByIds(ids);
    }

    /**
     * 删除学生表信息
     *
     * @param id 学生表主键
     * @return 结果
     */
    @Override
    public int deleteAdStudentById(Long id)
    {
        return adStudentMapper.deleteAdStudentById(id);
    }
}
