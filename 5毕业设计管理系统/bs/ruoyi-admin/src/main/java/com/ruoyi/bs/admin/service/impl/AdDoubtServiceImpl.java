package com.ruoyi.bs.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bs.admin.mapper.AdDoubtMapper;
import com.ruoyi.bs.admin.domain.AdDoubt;
import com.ruoyi.bs.admin.service.IAdDoubtService;

/**
 * 疑问表Service业务层处理
 * 
 * @author Ystarry
 * @date 2021-12-28
 */
@Service
public class AdDoubtServiceImpl implements IAdDoubtService 
{
    @Autowired
    private AdDoubtMapper adDoubtMapper;

    /**
     * 查询疑问表
     * 
     * @param id 疑问表主键
     * @return 疑问表
     */
    @Override
    public AdDoubt selectAdDoubtById(Integer id)
    {
        return adDoubtMapper.selectAdDoubtById(id);
    }

    /**
     * 查询疑问表列表
     * 
     * @param adDoubt 疑问表
     * @return 疑问表
     */
    @Override
    public List<AdDoubt> selectAdDoubtList(AdDoubt adDoubt)
    {
        return adDoubtMapper.selectAdDoubtList(adDoubt);
    }

    /**
     * 新增疑问表
     * 
     * @param adDoubt 疑问表
     * @return 结果
     */
    @Override
    public int insertAdDoubt(AdDoubt adDoubt)
    {
        return adDoubtMapper.insertAdDoubt(adDoubt);
    }

    /**
     * 修改疑问表
     * 
     * @param adDoubt 疑问表
     * @return 结果
     */
    @Override
    public int updateAdDoubt(AdDoubt adDoubt)
    {
        return adDoubtMapper.updateAdDoubt(adDoubt);
    }

    /**
     * 批量删除疑问表
     * 
     * @param ids 需要删除的疑问表主键
     * @return 结果
     */
    @Override
    public int deleteAdDoubtByIds(Integer[] ids)
    {
        return adDoubtMapper.deleteAdDoubtByIds(ids);
    }

    /**
     * 删除疑问表信息
     * 
     * @param id 疑问表主键
     * @return 结果
     */
    @Override
    public int deleteAdDoubtById(Integer id)
    {
        return adDoubtMapper.deleteAdDoubtById(id);
    }
}
