package com.ruoyi.bs.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bs.admin.mapper.AdTeacherMapper;
import com.ruoyi.bs.admin.domain.AdTeacher;
import com.ruoyi.bs.admin.service.IAdTeacherService;

/**
 * 教师表Service业务层处理
 *
 * @author Ystarry
 * @date 2021-12-01
 */
@Service
public class AdTeacherServiceImpl implements IAdTeacherService
{
    @Autowired
    private AdTeacherMapper adTeacherMapper;

    /**
     * 查询教师表
     *
     * @param id 教师表主键
     * @return 教师表
     */
    @Override
    public AdTeacher selectAdTeacherById(Long id)
    {
        return adTeacherMapper.selectAdTeacherById(id);
    }

    /**
     * 检索教师职工号，如果存在，返回添加失败信息
     */
    public AdTeacher selectAdTeacherByTeacherNo(String teacherNo){
        return adTeacherMapper.selectAdTeacherByTeacherNo(teacherNo);
    }

    /**
     * 查询教师表列表
     *
     * @param adTeacher 教师表
     * @return 教师表
     */
    @Override
    public List<AdTeacher> selectAdTeacherList(AdTeacher adTeacher)
    {
        return adTeacherMapper.selectAdTeacherList(adTeacher);
    }

    /**
     * 新增教师表
     *
     * @param adTeacher 教师表
     * @return 结果
     */
    @Override
    public int insertAdTeacher(AdTeacher adTeacher)
    {
        return adTeacherMapper.insertAdTeacher(adTeacher);
    }

    /**
     * 修改教师表
     *
     * @param adTeacher 教师表
     * @return 结果
     */
    @Override
    public int updateAdTeacher(AdTeacher adTeacher)
    {
        return adTeacherMapper.updateAdTeacher(adTeacher);
    }

    /**
     * 批量删除教师表
     *
     * @param ids 需要删除的教师表主键
     * @return 结果
     */
    @Override
    public int deleteAdTeacherByIds(Long[] ids)
    {
        return adTeacherMapper.deleteAdTeacherByIds(ids);
    }

    /**
     * 删除教师表信息
     *
     * @param id 教师表主键
     * @return 结果
     */
    @Override
    public int deleteAdTeacherById(Long id)
    {
        return adTeacherMapper.deleteAdTeacherById(id);
    }
}
