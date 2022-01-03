package com.ruoyi.bs.admin.mapper;

import java.util.List;
import com.ruoyi.bs.admin.domain.AdDoubt;

/**
 * 疑问表Mapper接口
 * 
 * @author Ystarry
 * @date 2021-12-28
 */
public interface AdDoubtMapper 
{
    /**
     * 查询疑问表
     * 
     * @param id 疑问表主键
     * @return 疑问表
     */
    public AdDoubt selectAdDoubtById(Integer id);

    /**
     * 查询疑问表列表
     * 
     * @param adDoubt 疑问表
     * @return 疑问表集合
     */
    public List<AdDoubt> selectAdDoubtList(AdDoubt adDoubt);

    /**
     * 新增疑问表
     * 
     * @param adDoubt 疑问表
     * @return 结果
     */
    public int insertAdDoubt(AdDoubt adDoubt);

    /**
     * 修改疑问表
     * 
     * @param adDoubt 疑问表
     * @return 结果
     */
    public int updateAdDoubt(AdDoubt adDoubt);

    /**
     * 删除疑问表
     * 
     * @param id 疑问表主键
     * @return 结果
     */
    public int deleteAdDoubtById(Integer id);

    /**
     * 批量删除疑问表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAdDoubtByIds(Integer[] ids);
}
