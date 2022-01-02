package com.ruoyi.bs.admin.mapper;

import java.util.List;
import com.ruoyi.bs.admin.domain.AdStudent;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生表Mapper接口
 *
 * @author Ystarry
 * @date 2021-12-01
 */
@Mapper
public interface AdStudentMapper
{
    /**
     * 查询学生表
     *
     * @param id 学生表主键
     * @return 学生表
     */
    public AdStudent selectAdStudentById(Long id);

    public AdStudent selectAdStudentByStudentNo(String studentNo);

    /**
     * 查询学生表列表
     *
     * @param adStudent 学生表
     * @return 学生表集合
     */
    public List<AdStudent> selectAdStudentList(AdStudent adStudent);

    /**
     * 新增学生表
     *
     * @param adStudent 学生表
     * @return 结果
     */
    public int insertAdStudent(AdStudent adStudent);

    /**
     * 修改学生表
     *
     * @param adStudent 学生表
     * @return 结果
     */
    public int updateAdStudent(AdStudent adStudent);

    /**
     * 删除学生表
     *
     * @param id 学生表主键
     * @return 结果
     */
    public int deleteAdStudentById(Long id);

    /**
     * 批量删除学生表
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAdStudentByIds(Long[] ids);
}
