package com.ruoyi.bs.admin.service;

import java.util.List;
import com.ruoyi.bs.admin.domain.AdStudentScore;

/**
 * 学生成绩表Service接口
 *
 * @author Ystarry
 * @date 2021-12-01
 */
public interface IAdStudentScoreService
{
    /**
     * 查询学生成绩表
     *
     * @param id 学生成绩表主键
     * @return 学生成绩表
     */
    public AdStudentScore selectAdStudentScoreById(Long id);

    public AdStudentScore selectAdStudentScoreByStudentNo(String studentNo);

    /**
     * 查询学生成绩表列表
     *
     * @param adStudentScore 学生成绩表
     * @return 学生成绩表集合
     */
    public List<AdStudentScore> selectAdStudentScoreList(AdStudentScore adStudentScore);

    /**
     * 新增学生成绩表
     *
     * @param adStudentScore 学生成绩表
     * @return 结果
     */
    public int insertAdStudentScore(AdStudentScore adStudentScore);

    /**
     * 修改学生成绩表
     *
     * @param adStudentScore 学生成绩表
     * @return 结果
     */
    public int updateAdStudentScore(AdStudentScore adStudentScore);

    /**
     * 批量删除学生成绩表
     *
     * @param ids 需要删除的学生成绩表主键集合
     * @return 结果
     */
    public int deleteAdStudentScoreByIds(Long[] ids);

    /**
     * 删除学生成绩表信息
     *
     * @param id 学生成绩表主键
     * @return 结果
     */
    public int deleteAdStudentScoreById(Long id);
}
