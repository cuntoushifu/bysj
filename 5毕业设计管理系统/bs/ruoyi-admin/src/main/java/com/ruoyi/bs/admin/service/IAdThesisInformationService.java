package com.ruoyi.bs.admin.service;

import java.util.List;
import com.ruoyi.bs.admin.domain.AdThesisInformation;

/**
 * 文档提交表Service接口
 * 
 * @author Ystarry
 * @date 2021-12-01
 */
public interface IAdThesisInformationService 
{
    /**
     * 查询文档提交表
     * 
     * @param id 文档提交表主键
     * @return 文档提交表
     */
    public AdThesisInformation selectAdThesisInformationById(Long id);

    /**
     * 查询文档提交表列表
     * 
     * @param adThesisInformation 文档提交表
     * @return 文档提交表集合
     */
    public List<AdThesisInformation> selectAdThesisInformationList(AdThesisInformation adThesisInformation);

    /**
     * 新增文档提交表
     * 
     * @param adThesisInformation 文档提交表
     * @return 结果
     */
    public int insertAdThesisInformation(AdThesisInformation adThesisInformation);

    /**
     * 修改文档提交表
     * 
     * @param adThesisInformation 文档提交表
     * @return 结果
     */
    public int updateAdThesisInformation(AdThesisInformation adThesisInformation);

    /**
     * 批量删除文档提交表
     * 
     * @param ids 需要删除的文档提交表主键集合
     * @return 结果
     */
    public int deleteAdThesisInformationByIds(Long[] ids);

    /**
     * 删除文档提交表信息
     * 
     * @param id 文档提交表主键
     * @return 结果
     */
    public int deleteAdThesisInformationById(Long id);
}
