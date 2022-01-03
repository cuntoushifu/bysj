package com.ruoyi.bs.admin.mapper;

import java.util.List;
import com.ruoyi.bs.admin.domain.AdThesisInformation;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文档提交表Mapper接口
 *
 * @author Ystarry
 * @date 2021-12-01
 */
@Mapper
public interface AdThesisInformationMapper
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
     * 删除文档提交表
     *
     * @param id 文档提交表主键
     * @return 结果
     */
    public int deleteAdThesisInformationById(Long id);

    /**
     * 批量删除文档提交表
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAdThesisInformationByIds(Long[] ids);
}
