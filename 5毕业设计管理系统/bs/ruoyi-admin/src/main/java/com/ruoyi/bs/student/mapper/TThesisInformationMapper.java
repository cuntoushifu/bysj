package com.ruoyi.bs.student.mapper;

import java.util.List;
import com.ruoyi.bs.student.domain.TThesisInformation;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文档提交表Mapper接口
 *
 * @author Ystarry
 * @date 2021-11-22
 */
@Mapper
public interface TThesisInformationMapper
{
    /**
     * 查询文档提交表
     *
     * @param
     * @return 文档提交表
     */
    public TThesisInformation selectTThesisInformationByStuNo(String studentNo);

    /**
     * 查询文档提交表列表
     *
     * @param tThesisInformation 文档提交表
     * @return 文档提交表集合
     */
    public List<TThesisInformation> selectTThesisInformationList(TThesisInformation tThesisInformation);

    /**
     * 新增文档提交表
     *
     * @param tThesisInformation 文档提交表
     * @return 结果
     */
    public int insertTThesisInformation(TThesisInformation tThesisInformation);

    /**
     * 修改文档提交表
     *
     * @param tThesisInformation 文档提交表
     * @return 结果
     */
    public int updateTThesisInformation(TThesisInformation tThesisInformation);

    /**
     * 删除文档提交表
     *
     * @param id 文档提交表主键
     * @return 结果
     */
    public int deleteTThesisInformationById(Long id);

    /**
     * 批量删除文档提交表
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTThesisInformationByIds(Long[] ids);
}
