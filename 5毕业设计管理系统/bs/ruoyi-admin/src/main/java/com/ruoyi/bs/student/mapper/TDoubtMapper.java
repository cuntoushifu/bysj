package com.ruoyi.bs.student.mapper;

import java.util.List;
import com.ruoyi.bs.student.domain.TDoubt;
import org.apache.ibatis.annotations.Mapper;

/**
 * 疑问表Mapper接口
 *
 * @author Ystarry
 * @date 2021-11-22
 */
@Mapper
public interface TDoubtMapper
{
    /**
     * 查询疑问表
     *
     * @param id 疑问表主键
     * @return 疑问表
     */
    public TDoubt selectTDoubtById(Integer id);

    /**
     * 查询疑问表列表
     *
     * @param tDoubt 疑问表
     * @return 疑问表集合
     */
    public List<TDoubt> selectTDoubtList(TDoubt tDoubt);

    /**
     * 新增疑问表
     *
     * @param tDoubt 疑问表
     * @return 结果
     */
    public int insertTDoubt(TDoubt tDoubt);

    /**
     * 修改疑问表
     *
     * @param tDoubt 疑问表
     * @return 结果
     */
    public int updateTDoubt(TDoubt tDoubt);

    /**
     * 删除疑问表
     *
     * @param id 疑问表主键
     * @return 结果
     */
    public int deleteTDoubtById(Integer id);

    /**
     * 批量删除疑问表
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTDoubtByIds(Integer[] ids);
}
