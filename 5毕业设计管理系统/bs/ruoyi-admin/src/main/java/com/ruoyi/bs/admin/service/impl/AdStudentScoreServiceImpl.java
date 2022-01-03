package com.ruoyi.bs.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bs.admin.mapper.AdStudentScoreMapper;
import com.ruoyi.bs.admin.domain.AdStudentScore;
import com.ruoyi.bs.admin.service.IAdStudentScoreService;

/**
 * 学生成绩表Service业务层处理
 *
 * @author Ystarry
 * @date 2021-12-01
 */
@Service
public class AdStudentScoreServiceImpl implements IAdStudentScoreService
{
    @Autowired
    private AdStudentScoreMapper adStudentScoreMapper;

    /**
     * 查询学生成绩表
     *
     * @param id 学生成绩表主键
     * @return 学生成绩表
     */
    @Override
    public AdStudentScore selectAdStudentScoreById(Long id)
    {
        return adStudentScoreMapper.selectAdStudentScoreById(id);
    }

    public AdStudentScore selectAdStudentScoreByStudentNo(String studentNo){
        return adStudentScoreMapper.selectAdStudentScoreByStudentNo(studentNo);
    }

    /**
     * 查询学生成绩表列表
     *
     * @param adStudentScore 学生成绩表
     * @return 学生成绩表
     */
    @Override
    public List<AdStudentScore> selectAdStudentScoreList(AdStudentScore adStudentScore)
    {
        return adStudentScoreMapper.selectAdStudentScoreList(adStudentScore);
    }

    /**
     * 新增学生成绩表
     *
     * @param adStudentScore 学生成绩表
     * @return 结果
     */
    @Override
    public int insertAdStudentScore(AdStudentScore adStudentScore)
    {
        return adStudentScoreMapper.insertAdStudentScore(adStudentScore);
    }

    /**
     * 修改学生成绩表
     *
     * @param adStudentScore 学生成绩表
     * @return 结果
     */
    @Override
    public int updateAdStudentScore(AdStudentScore adStudentScore)
    {
        return adStudentScoreMapper.updateAdStudentScore(adStudentScore);
    }

    /**
     * 批量删除学生成绩表
     *
     * @param ids 需要删除的学生成绩表主键
     * @return 结果
     */
    @Override
    public int deleteAdStudentScoreByIds(Long[] ids)
    {
        return adStudentScoreMapper.deleteAdStudentScoreByIds(ids);
    }

    /**
     * 删除学生成绩表信息
     *
     * @param id 学生成绩表主键
     * @return 结果
     */
    @Override
    public int deleteAdStudentScoreById(Long id)
    {
        return adStudentScoreMapper.deleteAdStudentScoreById(id);
    }
}
