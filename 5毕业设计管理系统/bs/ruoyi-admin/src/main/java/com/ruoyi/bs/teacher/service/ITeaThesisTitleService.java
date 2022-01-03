package com.ruoyi.bs.teacher.service;

import java.util.List;
import com.ruoyi.bs.teacher.domain.TeaThesisTitle;

/**
 * 教师提交课题表Service接口
 * 
 * @author Ystarry
 * @date 2021-12-01
 */
public interface ITeaThesisTitleService 
{
    /**
     * 查询教师提交课题表
     * 
     * @param id 教师提交课题表主键
     * @return 教师提交课题表
     */
    public TeaThesisTitle selectTeaThesisTitleById(Long id);

    /**
     * 查询教师提交课题表列表
     * 
     * @param teaThesisTitle 教师提交课题表
     * @return 教师提交课题表集合
     */
    public List<TeaThesisTitle> selectTeaThesisTitleList(TeaThesisTitle teaThesisTitle);

    /**
     * 新增教师提交课题表
     * 
     * @param teaThesisTitle 教师提交课题表
     * @return 结果
     */
    public int insertTeaThesisTitle(TeaThesisTitle teaThesisTitle);

    /**
     * 修改教师提交课题表
     * 
     * @param teaThesisTitle 教师提交课题表
     * @return 结果
     */
    public int updateTeaThesisTitle(TeaThesisTitle teaThesisTitle);

    /**
     * 批量删除教师提交课题表
     * 
     * @param ids 需要删除的教师提交课题表主键集合
     * @return 结果
     */
    public int deleteTeaThesisTitleByIds(Long[] ids);

    /**
     * 删除教师提交课题表信息
     * 
     * @param id 教师提交课题表主键
     * @return 结果
     */
    public int deleteTeaThesisTitleById(Long id);
}
