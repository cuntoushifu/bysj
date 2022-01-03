package com.ruoyi.bs.admin.service;

import java.util.List;
import com.ruoyi.bs.admin.domain.AdThesisTitle;

/**
 * 教师提交课题表Service接口
 *
 * @author Ystarry
 * @date 2021-12-01
 */
public interface IAdThesisTitleService
{
    /**
     * 查询课题申请表
     *
     * @param id 课题申请表主键
     * @return 课题申请表
     */
    public AdThesisTitle selectTThesisTitleById(Long id);

    /**
     * 查询课题申请表列表
     *
     * @param tThesisTitle 课题申请表
     * @return 课题申请表集合
     */
    public List<AdThesisTitle> selectTThesisTitleList(AdThesisTitle tThesisTitle);

    /**
     * 新增课题申请表
     *
     * @param tThesisTitle 课题申请表
     * @return 结果
     */
    public int insertTThesisTitle(AdThesisTitle tThesisTitle);

    /**
     * 修改课题申请表
     *
     * @param tThesisTitle 课题申请表
     * @return 结果
     */
    public int updateTThesisTitle(AdThesisTitle tThesisTitle);

    /**
     * 批量删除课题申请表
     *
     * @param ids 需要删除的课题申请表主键集合
     * @return 结果
     */
    public int deleteTThesisTitleByIds(Long[] ids);

    /**
     * 删除课题申请表信息
     *
     * @param id 课题申请表主键
     * @return 结果
     */
    public int deleteTThesisTitleById(Long id);
}
