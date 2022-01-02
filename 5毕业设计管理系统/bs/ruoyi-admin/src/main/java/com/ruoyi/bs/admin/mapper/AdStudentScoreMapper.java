package com.ruoyi.bs.admin.mapper;

import java.util.List;
import com.ruoyi.bs.admin.domain.AdStudentScore;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生成绩表Mapper接口
 *
 * @author Ystarry
 * @date 2021-12-01
 */
@Mapper
public interface AdStudentScoreMapper
{
    /**
     * 查询学生成绩表
     *
     * @param id 学生成绩表主键
     * @return 学生成绩表
     */
    public AdStudentScore selectAdStudentScoreById(Long id);

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
     * 删除学生成绩表
     *
     * @param id 学生成绩表主键
     * @return 结果
     */
    public int deleteAdStudentScoreById(Long id);

    public AdStudentScore selectAdStudentScoreByStudentNo(String studentNo);

    /**
     * 批量删除学生成绩表
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAdStudentScoreByIds(Long[] ids);
}
