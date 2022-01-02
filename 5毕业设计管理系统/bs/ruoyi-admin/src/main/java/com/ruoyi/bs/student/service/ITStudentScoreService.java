package com.ruoyi.bs.student.service;

import java.util.List;
import com.ruoyi.bs.student.domain.TStudentScore;

/**
 * 学生成绩表Service接口
 * 
 * @author Ystarry
 * @date 2021-11-22
 */
public interface ITStudentScoreService 
{
    /**
     * 查询学生成绩表
     * 
     * @param id 学生成绩表主键
     * @return 学生成绩表
     */
    public TStudentScore selectTStudentScoreById(Long id);

    /**
     * 查询学生成绩表列表
     * 
     * @param tStudentScore 学生成绩表
     * @return 学生成绩表集合
     */
    public List<TStudentScore> selectTStudentScoreList(TStudentScore tStudentScore);

    /**
     * 新增学生成绩表
     * 
     * @param tStudentScore 学生成绩表
     * @return 结果
     */
    public int insertTStudentScore(TStudentScore tStudentScore);

    /**
     * 修改学生成绩表
     * 
     * @param tStudentScore 学生成绩表
     * @return 结果
     */
    public int updateTStudentScore(TStudentScore tStudentScore);

    /**
     * 批量删除学生成绩表
     * 
     * @param ids 需要删除的学生成绩表主键集合
     * @return 结果
     */
    public int deleteTStudentScoreByIds(Long[] ids);

    /**
     * 删除学生成绩表信息
     * 
     * @param id 学生成绩表主键
     * @return 结果
     */
    public int deleteTStudentScoreById(Long id);
}
