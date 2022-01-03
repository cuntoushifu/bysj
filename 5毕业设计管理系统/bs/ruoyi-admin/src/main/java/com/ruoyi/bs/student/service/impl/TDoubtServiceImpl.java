package com.ruoyi.bs.student.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bs.student.mapper.TDoubtMapper;
import com.ruoyi.bs.student.domain.TDoubt;
import com.ruoyi.bs.student.service.ITDoubtService;

/**
 * 疑问表Service业务层处理
 * 
 * @author Ystarry
 * @date 2021-11-22
 */
@Service
public class TDoubtServiceImpl implements ITDoubtService 
{
    @Autowired
    private TDoubtMapper tDoubtMapper;

    /**
     * 查询疑问表
     * 
     * @param id 疑问表主键
     * @return 疑问表
     */
    @Override
    public TDoubt selectTDoubtById(Integer id)
    {
        return tDoubtMapper.selectTDoubtById(id);
    }

    /**
     * 查询疑问表列表
     * 
     * @param tDoubt 疑问表
     * @return 疑问表
     */
    @Override
    public List<TDoubt> selectTDoubtList(TDoubt tDoubt)
    {
        return tDoubtMapper.selectTDoubtList(tDoubt);
    }

    /**
     * 新增疑问表
     * 
     * @param tDoubt 疑问表
     * @return 结果
     */
    @Override
    public int insertTDoubt(TDoubt tDoubt)
    {
        return tDoubtMapper.insertTDoubt(tDoubt);
    }

    /**
     * 修改疑问表
     * 
     * @param tDoubt 疑问表
     * @return 结果
     */
    @Override
    public int updateTDoubt(TDoubt tDoubt)
    {
        return tDoubtMapper.updateTDoubt(tDoubt);
    }

    /**
     * 批量删除疑问表
     * 
     * @param ids 需要删除的疑问表主键
     * @return 结果
     */
    @Override
    public int deleteTDoubtByIds(Integer[] ids)
    {
        return tDoubtMapper.deleteTDoubtByIds(ids);
    }

    /**
     * 删除疑问表信息
     * 
     * @param id 疑问表主键
     * @return 结果
     */
    @Override
    public int deleteTDoubtById(Integer id)
    {
        return tDoubtMapper.deleteTDoubtById(id);
    }
}
