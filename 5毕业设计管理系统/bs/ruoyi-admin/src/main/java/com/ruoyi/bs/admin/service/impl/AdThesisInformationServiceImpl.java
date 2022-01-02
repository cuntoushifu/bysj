package com.ruoyi.bs.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bs.admin.mapper.AdThesisInformationMapper;
import com.ruoyi.bs.admin.domain.AdThesisInformation;
import com.ruoyi.bs.admin.service.IAdThesisInformationService;

/**
 * 文档提交表Service业务层处理
 * 
 * @author Ystarry
 * @date 2021-12-01
 */
@Service
public class AdThesisInformationServiceImpl implements IAdThesisInformationService 
{
    @Autowired
    private AdThesisInformationMapper adThesisInformationMapper;

    /**
     * 查询文档提交表
     * 
     * @param id 文档提交表主键
     * @return 文档提交表
     */
    @Override
    public AdThesisInformation selectAdThesisInformationById(Long id)
    {
        return adThesisInformationMapper.selectAdThesisInformationById(id);
    }

    /**
     * 查询文档提交表列表
     * 
     * @param adThesisInformation 文档提交表
     * @return 文档提交表
     */
    @Override
    public List<AdThesisInformation> selectAdThesisInformationList(AdThesisInformation adThesisInformation)
    {
        return adThesisInformationMapper.selectAdThesisInformationList(adThesisInformation);
    }

    /**
     * 新增文档提交表
     * 
     * @param adThesisInformation 文档提交表
     * @return 结果
     */
    @Override
    public int insertAdThesisInformation(AdThesisInformation adThesisInformation)
    {
        return adThesisInformationMapper.insertAdThesisInformation(adThesisInformation);
    }

    /**
     * 修改文档提交表
     * 
     * @param adThesisInformation 文档提交表
     * @return 结果
     */
    @Override
    public int updateAdThesisInformation(AdThesisInformation adThesisInformation)
    {
        return adThesisInformationMapper.updateAdThesisInformation(adThesisInformation);
    }

    /**
     * 批量删除文档提交表
     * 
     * @param ids 需要删除的文档提交表主键
     * @return 结果
     */
    @Override
    public int deleteAdThesisInformationByIds(Long[] ids)
    {
        return adThesisInformationMapper.deleteAdThesisInformationByIds(ids);
    }

    /**
     * 删除文档提交表信息
     * 
     * @param id 文档提交表主键
     * @return 结果
     */
    @Override
    public int deleteAdThesisInformationById(Long id)
    {
        return adThesisInformationMapper.deleteAdThesisInformationById(id);
    }
}
