package com.ruoyi.bs.teacher.service;

import java.util.List;
import com.ruoyi.bs.teacher.domain.TeaThesisInformation;

/**
 * 文档提交表Service接口
 * 
 * @author Ystarry
 * @date 2021-11-23
 */
public interface ITeaThesisInformationService 
{
    /**
     * 查询文档提交表
     * 
     * @param id 文档提交表主键
     * @return 文档提交表
     */
    public TeaThesisInformation selectTeaThesisInformationById(Long id);

    /**
     * 查询文档提交表列表
     * 
     * @param teaThesisInformation 文档提交表
     * @return 文档提交表集合
     */
    public List<TeaThesisInformation> selectTeaThesisInformationList(TeaThesisInformation teaThesisInformation);

    /**
     * 新增文档提交表
     * 
     * @param teaThesisInformation 文档提交表
     * @return 结果
     */
    public int insertTeaThesisInformation(TeaThesisInformation teaThesisInformation);

    /**
     * 修改文档提交表
     * 
     * @param teaThesisInformation 文档提交表
     * @return 结果
     */
    public int updateTeaThesisInformation(TeaThesisInformation teaThesisInformation);

    /**
     * 批量删除文档提交表
     * 
     * @param ids 需要删除的文档提交表主键集合
     * @return 结果
     */
    public int deleteTeaThesisInformationByIds(Long[] ids);

    /**
     * 删除文档提交表信息
     * 
     * @param id 文档提交表主键
     * @return 结果
     */
    public int deleteTeaThesisInformationById(Long id);
}
