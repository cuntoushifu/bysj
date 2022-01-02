package com.ruoyi.bs.teacher.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bs.teacher.mapper.TeaStudentScoreMapper;
import com.ruoyi.bs.teacher.domain.TeaStudentScore;
import com.ruoyi.bs.teacher.service.ITeaStudentScoreService;

/**
 * 学生成绩表Service业务层处理
 * 
 * @author Ystarry
 * @date 2021-11-23
 */
@Service
public class TeaStudentScoreServiceImpl implements ITeaStudentScoreService 
{
    @Autowired
    private TeaStudentScoreMapper teaStudentScoreMapper;

    /**
     * 查询学生成绩表
     * 
     * @param id 学生成绩表主键
     * @return 学生成绩表
     */
    @Override
    public TeaStudentScore selectTeaStudentScoreById(Long id)
    {
        return teaStudentScoreMapper.selectTeaStudentScoreById(id);
    }

    /**
     * 查询学生成绩表列表
     * 
     * @param teaStudentScore 学生成绩表
     * @return 学生成绩表
     */
    @Override
    public List<TeaStudentScore> selectTeaStudentScoreList(TeaStudentScore teaStudentScore)
    {
        return teaStudentScoreMapper.selectTeaStudentScoreList(teaStudentScore);
    }

    /**
     * 新增学生成绩表
     * 
     * @param teaStudentScore 学生成绩表
     * @return 结果
     */
    @Override
    public int insertTeaStudentScore(TeaStudentScore teaStudentScore)
    {
        return teaStudentScoreMapper.insertTeaStudentScore(teaStudentScore);
    }

    /**
     * 修改学生成绩表
     * 
     * @param teaStudentScore 学生成绩表
     * @return 结果
     */
    @Override
    public int updateTeaStudentScore(TeaStudentScore teaStudentScore)
    {
        return teaStudentScoreMapper.updateTeaStudentScore(teaStudentScore);
    }

    /**
     * 批量删除学生成绩表
     * 
     * @param ids 需要删除的学生成绩表主键
     * @return 结果
     */
    @Override
    public int deleteTeaStudentScoreByIds(Long[] ids)
    {
        return teaStudentScoreMapper.deleteTeaStudentScoreByIds(ids);
    }

    /**
     * 删除学生成绩表信息
     * 
     * @param id 学生成绩表主键
     * @return 结果
     */
    @Override
    public int deleteTeaStudentScoreById(Long id)
    {
        return teaStudentScoreMapper.deleteTeaStudentScoreById(id);
    }
}
