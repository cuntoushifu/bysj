package com.ruoyi.bs.teacher.mapper;

import java.util.List;
import com.ruoyi.bs.teacher.domain.TeaStudentScore;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生成绩表Mapper接口
 *
 * @author Ystarry
 * @date 2021-11-23
 */
@Mapper
public interface TeaStudentScoreMapper
{
    /**
     * 查询学生成绩表
     *
     * @param id 学生成绩表主键
     * @return 学生成绩表
     */
    public TeaStudentScore selectTeaStudentScoreById(Long id);

    /**
     * 查询学生成绩表列表
     *
     * @param teaStudentScore 学生成绩表
     * @return 学生成绩表集合
     */
    public List<TeaStudentScore> selectTeaStudentScoreList(TeaStudentScore teaStudentScore);

    /**
     * 新增学生成绩表
     *
     * @param teaStudentScore 学生成绩表
     * @return 结果
     */
    public int insertTeaStudentScore(TeaStudentScore teaStudentScore);

    /**
     * 修改学生成绩表
     *
     * @param teaStudentScore 学生成绩表
     * @return 结果
     */
    public int updateTeaStudentScore(TeaStudentScore teaStudentScore);

    /**
     * 删除学生成绩表
     *
     * @param id 学生成绩表主键
     * @return 结果
     */
    public int deleteTeaStudentScoreById(Long id);

    /**
     * 批量删除学生成绩表
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTeaStudentScoreByIds(Long[] ids);
}
