package com.ruoyi.bs.student.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bs.student.mapper.TThesisInformationMapper;
import com.ruoyi.bs.student.domain.TThesisInformation;
import com.ruoyi.bs.student.service.ITThesisInformationService;

/**
 * 文档提交表Service业务层处理
 *
 * @author Ystarry
 * @date 2021-11-22
 */
@Service
public class TThesisInformationServiceImpl implements ITThesisInformationService
{
    @Autowired
    private TThesisInformationMapper tThesisInformationMapper;

    /**
     * 查询文档提交表
     *
     * @param
     * @return 文档提交表
     */
    @Override
    public TThesisInformation selectTThesisInformationByStuNo(String studentNo)
    {
        return tThesisInformationMapper.selectTThesisInformationByStuNo(studentNo);
    }

    /**
     * 查询文档提交表列表
     *
     * @param tThesisInformation 文档提交表
     * @return 文档提交表
     */
    @Override
    public List<TThesisInformation> selectTThesisInformationList(TThesisInformation tThesisInformation)
    {
        return tThesisInformationMapper.selectTThesisInformationList(tThesisInformation);
    }

    /**
     * 新增文档提交表
     *
     * @param tThesisInformation 文档提交表
     * @return 结果
     */
    @Override
    public int insertTThesisInformation(TThesisInformation tThesisInformation)
    {
        return tThesisInformationMapper.insertTThesisInformation(tThesisInformation);
    }

    /**
     * 修改文档提交表
     *
     * @param tThesisInformation 文档提交表
     * @return 结果
     */
    @Override
    public int updateTThesisInformation(TThesisInformation tThesisInformation)
    {
        return tThesisInformationMapper.updateTThesisInformation(tThesisInformation);
    }

    /**
     * 批量删除文档提交表
     *
     * @param ids 需要删除的文档提交表主键
     * @return 结果
     */
    @Override
    public int deleteTThesisInformationByIds(Long[] ids)
    {
        return tThesisInformationMapper.deleteTThesisInformationByIds(ids);
    }

    /**
     * 删除文档提交表信息
     *
     * @param id 文档提交表主键
     * @return 结果
     */
    @Override
    public int deleteTThesisInformationById(Long id)
    {
        return tThesisInformationMapper.deleteTThesisInformationById(id);
    }
}
