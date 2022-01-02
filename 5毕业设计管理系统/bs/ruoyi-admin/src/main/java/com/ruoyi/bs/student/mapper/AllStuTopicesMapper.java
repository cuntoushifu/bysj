package com.ruoyi.bs.student.mapper;

import java.util.List;
import com.ruoyi.bs.student.domain.AllStuTopices;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

/**
 * 选题信息表Mapper接口
 *
 * @author Ystarry
 * @date 2021-12-05
 */
@Mapper
public interface AllStuTopicesMapper
{
    /**
     * 查询选题信息表
     *
     * @param id 选题信息表主键
     * @return 选题信息表
     */
    public AllStuTopices selectAllStuTopicesById(Long id);

    /**
     * 查询选题信息表列表
     *
     * @param allStuTopices 选题信息表
     * @return 选题信息表集合
     */
    public List<AllStuTopices> selectAllStuTopicesList(AllStuTopices allStuTopices);

    /**
     * 新增选题信息表
     *
     * @param allStuTopices 选题信息表
     * @return 结果
     */
    public int insertAllStuTopices(AllStuTopices allStuTopices);

    /**
     * 修改选题信息表
     *
     * @param allStuTopices 选题信息表
     * @return 结果
     */
    public int updateAllStuTopices(AllStuTopices allStuTopices);

    /**
     * 查询当前学生是否选题
     */
    public String selStuTopicinfo(String studentNo);

    /**
     * 查询当前课题是否有人选择
     */
    public String selCurrentTopicStatus(Long id);
    /**
     * 删除选题信息表
     *
     * @param id 选题信息表主键
     * @return 结果
     */
    public int deleteAllStuTopicesById(Long id);

    /**
     * 批量删除选题信息表
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAllStuTopicesByIds(Long[] ids);
}
