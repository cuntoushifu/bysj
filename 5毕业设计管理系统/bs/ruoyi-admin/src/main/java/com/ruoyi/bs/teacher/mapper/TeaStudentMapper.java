package com.ruoyi.bs.teacher.mapper;

import java.util.List;
import com.ruoyi.bs.teacher.domain.TeaStudent;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生表Mapper接口
 *
 * @author Ystarry
 * @date 2021-11-23
 */
@Mapper
public interface TeaStudentMapper
{
    /**
     * 查询学生表
     *
     * @param id 学生表主键
     * @return 学生表
     */
    public TeaStudent selectTeaStudentById(Long id);

    /**
     * 查询学生表列表
     *
     * @param teaStudent 学生表
     * @return 学生表集合
     */
    public List<TeaStudent> selectTeaStudentList(TeaStudent teaStudent);

    /**
     * 新增学生表
     *
     * @param teaStudent 学生表
     * @return 结果
     */
    public int insertTeaStudent(TeaStudent teaStudent);

    /**
     * 修改学生表
     *
     * @param teaStudent 学生表
     * @return 结果
     */
    public int updateTeaStudent(TeaStudent teaStudent);

    /**
     * 删除学生表
     *
     * @param id 学生表主键
     * @return 结果
     */
    public int deleteTeaStudentById(Long id);

    /**
     * 批量删除学生表
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTeaStudentByIds(Long[] ids);
}
