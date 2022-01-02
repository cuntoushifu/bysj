package com.ruoyi.bs.teacher.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bs.teacher.mapper.TeaThesisTitleMapper;
import com.ruoyi.bs.teacher.domain.TeaThesisTitle;
import com.ruoyi.bs.teacher.service.ITeaThesisTitleService;

/**
 * 教师提交课题表Service业务层处理
 * 
 * @author Ystarry
 * @date 2021-12-01
 */
@Service
public class TeaThesisTitleServiceImpl implements ITeaThesisTitleService 
{
    @Autowired
    private TeaThesisTitleMapper teaThesisTitleMapper;

    /**
     * 查询教师提交课题表
     * 
     * @param id 教师提交课题表主键
     * @return 教师提交课题表
     */
    @Override
    public TeaThesisTitle selectTeaThesisTitleById(Long id)
    {
        return teaThesisTitleMapper.selectTeaThesisTitleById(id);
    }

    /**
     * 查询教师提交课题表列表
     * 
     * @param teaThesisTitle 教师提交课题表
     * @return 教师提交课题表
     */
    @Override
    public List<TeaThesisTitle> selectTeaThesisTitleList(TeaThesisTitle teaThesisTitle)
    {
        return teaThesisTitleMapper.selectTeaThesisTitleList(teaThesisTitle);
    }

    /**
     * 新增教师提交课题表
     * 
     * @param teaThesisTitle 教师提交课题表
     * @return 结果
     */
    @Override
    public int insertTeaThesisTitle(TeaThesisTitle teaThesisTitle)
    {
        return teaThesisTitleMapper.insertTeaThesisTitle(teaThesisTitle);
    }

    /**
     * 修改教师提交课题表
     * 
     * @param teaThesisTitle 教师提交课题表
     * @return 结果
     */
    @Override
    public int updateTeaThesisTitle(TeaThesisTitle teaThesisTitle)
    {
        return teaThesisTitleMapper.updateTeaThesisTitle(teaThesisTitle);
    }

    /**
     * 批量删除教师提交课题表
     * 
     * @param ids 需要删除的教师提交课题表主键
     * @return 结果
     */
    @Override
    public int deleteTeaThesisTitleByIds(Long[] ids)
    {
        return teaThesisTitleMapper.deleteTeaThesisTitleByIds(ids);
    }

    /**
     * 删除教师提交课题表信息
     * 
     * @param id 教师提交课题表主键
     * @return 结果
     */
    @Override
    public int deleteTeaThesisTitleById(Long id)
    {
        return teaThesisTitleMapper.deleteTeaThesisTitleById(id);
    }
}
