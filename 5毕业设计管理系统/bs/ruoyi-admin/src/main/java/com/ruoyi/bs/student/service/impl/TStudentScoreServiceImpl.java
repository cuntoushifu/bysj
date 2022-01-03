package com.ruoyi.bs.student.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bs.student.mapper.TStudentScoreMapper;
import com.ruoyi.bs.student.domain.TStudentScore;
import com.ruoyi.bs.student.service.ITStudentScoreService;

/**
 * 学生成绩表Service业务层处理
 * 
 * @author Ystarry
 * @date 2021-11-22
 */
@Service
public class TStudentScoreServiceImpl implements ITStudentScoreService 
{
    @Autowired
    private TStudentScoreMapper tStudentScoreMapper;

    /**
     * 查询学生成绩表
     * 
     * @param id 学生成绩表主键
     * @return 学生成绩表
     */
    @Override
    public TStudentScore selectTStudentScoreById(Long id)
    {
        return tStudentScoreMapper.selectTStudentScoreById(id);
    }

    /**
     * 查询学生成绩表列表
     * 
     * @param tStudentScore 学生成绩表
     * @return 学生成绩表
     */
    @Override
    public List<TStudentScore> selectTStudentScoreList(TStudentScore tStudentScore)
    {
        return tStudentScoreMapper.selectTStudentScoreList(tStudentScore);
    }

    /**
     * 新增学生成绩表
     * 
     * @param tStudentScore 学生成绩表
     * @return 结果
     */
    @Override
    public int insertTStudentScore(TStudentScore tStudentScore)
    {
        return tStudentScoreMapper.insertTStudentScore(tStudentScore);
    }

    /**
     * 修改学生成绩表
     * 
     * @param tStudentScore 学生成绩表
     * @return 结果
     */
    @Override
    public int updateTStudentScore(TStudentScore tStudentScore)
    {
        return tStudentScoreMapper.updateTStudentScore(tStudentScore);
    }

    /**
     * 批量删除学生成绩表
     * 
     * @param ids 需要删除的学生成绩表主键
     * @return 结果
     */
    @Override
    public int deleteTStudentScoreByIds(Long[] ids)
    {
        return tStudentScoreMapper.deleteTStudentScoreByIds(ids);
    }

    /**
     * 删除学生成绩表信息
     * 
     * @param id 学生成绩表主键
     * @return 结果
     */
    @Override
    public int deleteTStudentScoreById(Long id)
    {
        return tStudentScoreMapper.deleteTStudentScoreById(id);
    }
}
