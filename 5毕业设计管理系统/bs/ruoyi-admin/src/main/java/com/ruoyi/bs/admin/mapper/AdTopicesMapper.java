package com.ruoyi.bs.admin.mapper;

import java.util.List;
import com.ruoyi.bs.admin.domain.AdTopices;
import org.apache.ibatis.annotations.Mapper;

/**
 * 选题信息表Mapper接口
 *
 * @author Ystarry
 * @date 2021-12-01
 */
@Mapper
public interface AdTopicesMapper
{
    /**
     * 查询选题信息表
     *
     * @param id 选题信息表主键
     * @return 选题信息表
     */
    public AdTopices selectAdTopicesById(Long id);

    /**
     * 查询选题信息表列表
     *
     * @param adTopices 选题信息表
     * @return 选题信息表集合
     */
    public List<AdTopices> selectAdTopicesList(AdTopices adTopices);

    /**
     * 新增选题信息表
     *
     * @param adTopices 选题信息表
     * @return 结果
     */
    public int insertAdTopices(AdTopices adTopices);

    /**
     * 修改选题信息表
     *
     * @param adTopices 选题信息表
     * @return 结果
     */
    public int updateAdTopices(AdTopices adTopices);

    /**
     * 删除选题信息表
     *
     * @param id 选题信息表主键
     * @return 结果
     */
    public int deleteAdTopicesById(Long id);

    /**
     * 批量删除选题信息表
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAdTopicesByIds(Long[] ids);
}
