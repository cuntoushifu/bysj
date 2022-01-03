package com.ruoyi.bs.teacher.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bs.teacher.mapper.TeaThesisInformationMapper;
import com.ruoyi.bs.teacher.domain.TeaThesisInformation;
import com.ruoyi.bs.teacher.service.ITeaThesisInformationService;

/**
 * 文档提交表Service业务层处理
 * 
 * @author Ystarry
 * @date 2021-11-23
 */
@Service
public class TeaThesisInformationServiceImpl implements ITeaThesisInformationService 
{
    @Autowired
    private TeaThesisInformationMapper teaThesisInformationMapper;

    /**
     * 查询文档提交表
     * 
     * @param id 文档提交表主键
     * @return 文档提交表
     */
    @Override
    public TeaThesisInformation selectTeaThesisInformationById(Long id)
    {
        return teaThesisInformationMapper.selectTeaThesisInformationById(id);
    }

    /**
     * 查询文档提交表列表
     * 
     * @param teaThesisInformation 文档提交表
     * @return 文档提交表
     */
    @Override
    public List<TeaThesisInformation> selectTeaThesisInformationList(TeaThesisInformation teaThesisInformation)
    {
        return teaThesisInformationMapper.selectTeaThesisInformationList(teaThesisInformation);
    }

    /**
     * 新增文档提交表
     * 
     * @param teaThesisInformation 文档提交表
     * @return 结果
     */
    @Override
    public int insertTeaThesisInformation(TeaThesisInformation teaThesisInformation)
    {
        return teaThesisInformationMapper.insertTeaThesisInformation(teaThesisInformation);
    }

    /**
     * 修改文档提交表
     * 
     * @param teaThesisInformation 文档提交表
     * @return 结果
     */
    @Override
    public int updateTeaThesisInformation(TeaThesisInformation teaThesisInformation)
    {
        return teaThesisInformationMapper.updateTeaThesisInformation(teaThesisInformation);
    }

    /**
     * 批量删除文档提交表
     * 
     * @param ids 需要删除的文档提交表主键
     * @return 结果
     */
    @Override
    public int deleteTeaThesisInformationByIds(Long[] ids)
    {
        return teaThesisInformationMapper.deleteTeaThesisInformationByIds(ids);
    }

    /**
     * 删除文档提交表信息
     * 
     * @param id 文档提交表主键
     * @return 结果
     */
    @Override
    public int deleteTeaThesisInformationById(Long id)
    {
        return teaThesisInformationMapper.deleteTeaThesisInformationById(id);
    }
}
