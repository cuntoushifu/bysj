package com.ruoyi.bs.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bs.admin.mapper.AdThesisTitleMapper;
import com.ruoyi.bs.admin.domain.AdThesisTitle;
import com.ruoyi.bs.admin.service.IAdThesisTitleService;

/**
 * 教师提交课题表Service业务层处理
 *
 * @author Ystarry
 * @date 2021-12-01
 */
@Service
public class AdThesisTitleServiceImpl implements IAdThesisTitleService
{
    @Autowired
    private AdThesisTitleMapper tThesisTitleMapper;

    /**
     * 查询课题申请表
     *
     * @param id 课题申请表主键
     * @return 课题申请表
     */
    @Override
    public AdThesisTitle selectTThesisTitleById(Long id)
    {
        return tThesisTitleMapper.selectTThesisTitleById(id);
    }

    /**
     * 查询课题申请表列表
     *
     * @param tThesisTitle 课题申请表
     * @return 课题申请表
     */
    @Override
    public List<AdThesisTitle> selectTThesisTitleList(AdThesisTitle tThesisTitle)
    {
        return tThesisTitleMapper.selectTThesisTitleList(tThesisTitle);
    }

    /**
     * 新增课题申请表
     *
     * @param tThesisTitle 课题申请表
     * @return 结果
     */
    @Override
    public int insertTThesisTitle(AdThesisTitle tThesisTitle)
    {
        return tThesisTitleMapper.insertTThesisTitle(tThesisTitle);
    }

    /**
     * 修改课题申请表
     *
     * @param tThesisTitle 课题申请表
     * @return 结果
     */
    @Override
    public int updateTThesisTitle(AdThesisTitle tThesisTitle)
    {
        return tThesisTitleMapper.updateTThesisTitle(tThesisTitle);
    }

    /**
     * 批量删除课题申请表
     *
     * @param ids 需要删除的课题申请表主键
     * @return 结果
     */
    @Override
    public int deleteTThesisTitleByIds(Long[] ids)
    {
        return tThesisTitleMapper.deleteTThesisTitleByIds(ids);
    }

    /**
     * 删除课题申请表信息
     *
     * @param id 课题申请表主键
     * @return 结果
     */
    @Override
    public int deleteTThesisTitleById(Long id)
    {
        return tThesisTitleMapper.deleteTThesisTitleById(id);
    }
}
