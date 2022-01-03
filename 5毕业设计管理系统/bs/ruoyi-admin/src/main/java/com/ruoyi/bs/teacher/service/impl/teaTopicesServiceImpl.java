package com.ruoyi.bs.teacher.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bs.teacher.mapper.teaTopicesMapper;
import com.ruoyi.bs.teacher.domain.teaTopices;
import com.ruoyi.bs.teacher.service.IteaTopicesService;

/**
 * 选题信息表Service业务层处理
 * 
 * @author Ystarry
 * @date 2021-12-01
 */
@Service
public class teaTopicesServiceImpl implements IteaTopicesService 
{
    @Autowired
    private teaTopicesMapper teaTopicesMapper;

    /**
     * 查询选题信息表
     * 
     * @param id 选题信息表主键
     * @return 选题信息表
     */
    @Override
    public teaTopices selectteaTopicesById(Long id)
    {
        return teaTopicesMapper.selectteaTopicesById(id);
    }

    /**
     * 查询选题信息表列表
     * 
     * @param teaTopices 选题信息表
     * @return 选题信息表
     */
    @Override
    public List<teaTopices> selectteaTopicesList(teaTopices teaTopices)
    {
        return teaTopicesMapper.selectteaTopicesList(teaTopices);
    }

    /**
     * 新增选题信息表
     * 
     * @param teaTopices 选题信息表
     * @return 结果
     */
    @Override
    public int insertteaTopices(teaTopices teaTopices)
    {
        return teaTopicesMapper.insertteaTopices(teaTopices);
    }

    /**
     * 修改选题信息表
     * 
     * @param teaTopices 选题信息表
     * @return 结果
     */
    @Override
    public int updateteaTopices(teaTopices teaTopices)
    {
        return teaTopicesMapper.updateteaTopices(teaTopices);
    }

    /**
     * 批量删除选题信息表
     * 
     * @param ids 需要删除的选题信息表主键
     * @return 结果
     */
    @Override
    public int deleteteaTopicesByIds(Long[] ids)
    {
        return teaTopicesMapper.deleteteaTopicesByIds(ids);
    }

    /**
     * 删除选题信息表信息
     * 
     * @param id 选题信息表主键
     * @return 结果
     */
    @Override
    public int deleteteaTopicesById(Long id)
    {
        return teaTopicesMapper.deleteteaTopicesById(id);
    }
}
