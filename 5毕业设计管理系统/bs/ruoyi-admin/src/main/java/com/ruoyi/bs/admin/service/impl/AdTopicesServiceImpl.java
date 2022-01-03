package com.ruoyi.bs.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bs.admin.mapper.AdTopicesMapper;
import com.ruoyi.bs.admin.domain.AdTopices;
import com.ruoyi.bs.admin.service.IAdTopicesService;

/**
 * 选题信息表Service业务层处理
 * 
 * @author Ystarry
 * @date 2021-12-01
 */
@Service
public class AdTopicesServiceImpl implements IAdTopicesService 
{
    @Autowired
    private AdTopicesMapper adTopicesMapper;

    /**
     * 查询选题信息表
     * 
     * @param id 选题信息表主键
     * @return 选题信息表
     */
    @Override
    public AdTopices selectAdTopicesById(Long id)
    {
        return adTopicesMapper.selectAdTopicesById(id);
    }

    /**
     * 查询选题信息表列表
     * 
     * @param adTopices 选题信息表
     * @return 选题信息表
     */
    @Override
    public List<AdTopices> selectAdTopicesList(AdTopices adTopices)
    {
        return adTopicesMapper.selectAdTopicesList(adTopices);
    }

    /**
     * 新增选题信息表
     * 
     * @param adTopices 选题信息表
     * @return 结果
     */
    @Override
    public int insertAdTopices(AdTopices adTopices)
    {
        return adTopicesMapper.insertAdTopices(adTopices);
    }

    /**
     * 修改选题信息表
     * 
     * @param adTopices 选题信息表
     * @return 结果
     */
    @Override
    public int updateAdTopices(AdTopices adTopices)
    {
        return adTopicesMapper.updateAdTopices(adTopices);
    }

    /**
     * 批量删除选题信息表
     * 
     * @param ids 需要删除的选题信息表主键
     * @return 结果
     */
    @Override
    public int deleteAdTopicesByIds(Long[] ids)
    {
        return adTopicesMapper.deleteAdTopicesByIds(ids);
    }

    /**
     * 删除选题信息表信息
     * 
     * @param id 选题信息表主键
     * @return 结果
     */
    @Override
    public int deleteAdTopicesById(Long id)
    {
        return adTopicesMapper.deleteAdTopicesById(id);
    }
}
