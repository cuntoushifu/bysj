package com.ruoyi.bs.admin.mapper;

import java.util.List;
import com.ruoyi.bs.admin.domain.AdTeacher;
import org.apache.ibatis.annotations.Mapper;

/**
 * 教师表Mapper接口
 *
 * @author Ystarry
 * @date 2021-12-01
 */
@Mapper
public interface AdTeacherMapper
{
    /**
     * 查询教师表
     *
     * @param id 教师表主键
     * @return 教师表
     */
    public AdTeacher selectAdTeacherById(Long id);

    /**
     *
     */
    /**
     * 检索教师职工号，如果存在，返回添加失败信息
     */
    public AdTeacher selectAdTeacherByTeacherNo(String teacherNo);

    /**
     * 查询教师表列表
     *
     * @param adTeacher 教师表
     * @return 教师表集合
     */
    public List<AdTeacher> selectAdTeacherList(AdTeacher adTeacher);

    /**
     * 新增教师表
     *
     * @param adTeacher 教师表
     * @return 结果
     */
    public int insertAdTeacher(AdTeacher adTeacher);

    /**
     * 修改教师表
     *
     * @param adTeacher 教师表
     * @return 结果
     */
    public int updateAdTeacher(AdTeacher adTeacher);

    /**
     * 删除教师表
     *
     * @param id 教师表主键
     * @return 结果
     */
    public int deleteAdTeacherById(Long id);

    /**
     * 批量删除教师表
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAdTeacherByIds(Long[] ids);
}
