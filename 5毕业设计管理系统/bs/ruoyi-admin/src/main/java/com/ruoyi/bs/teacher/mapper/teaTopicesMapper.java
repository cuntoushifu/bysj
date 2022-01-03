package com.ruoyi.bs.teacher.mapper;

import java.util.List;
import com.ruoyi.bs.teacher.domain.teaTopices;
import org.apache.ibatis.annotations.Mapper;

/**
 * 选题信息表Mapper接口
 *
 * @author Ystarry
 * @date 2021-12-01
 */
@Mapper
public interface teaTopicesMapper
{
    /**
     * 查询选题信息表
     *
     * @param id 选题信息表主键
     * @return 选题信息表
     */
    public teaTopices selectteaTopicesById(Long id);

    /**
     * 查询选题信息表列表
     *
     * @param teaTopices 选题信息表
     * @return 选题信息表集合
     */
    public List<teaTopices> selectteaTopicesList(teaTopices teaTopices);

    /**
     * 新增选题信息表
     *
     * @param teaTopices 选题信息表
     * @return 结果
     */
    public int insertteaTopices(teaTopices teaTopices);

    /**
     * 修改选题信息表
     *
     * @param teaTopices 选题信息表
     * @return 结果
     */
    public int updateteaTopices(teaTopices teaTopices);

    /**
     * 删除选题信息表
     *
     * @param id 选题信息表主键
     * @return 结果
     */
    public int deleteteaTopicesById(Long id);

    /**
     * 批量删除选题信息表
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteteaTopicesByIds(Long[] ids);
}
