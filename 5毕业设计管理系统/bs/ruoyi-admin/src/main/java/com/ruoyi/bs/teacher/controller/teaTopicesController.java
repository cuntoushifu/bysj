package com.ruoyi.bs.teacher.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.bs.teacher.domain.teaTopices;
import com.ruoyi.bs.teacher.service.IteaTopicesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 选题信息表Controller
 * 
 * @author Ystarry
 * @date 2021-12-01
 */
@RestController
@RequestMapping("/teacher/allTopices")
public class teaTopicesController extends BaseController
{
    @Autowired
    private IteaTopicesService teaTopicesService;

    /**
     * 查询选题信息表列表
     */
    @PreAuthorize("@ss.hasPermi('teacher:allTopices:list')")
    @GetMapping("/list")
    public TableDataInfo list(teaTopices teaTopices)
    {
        startPage();
        List<teaTopices> list = teaTopicesService.selectteaTopicesList(teaTopices);
        return getDataTable(list);
    }

    /**
     * 导出选题信息表列表
     */
    @PreAuthorize("@ss.hasPermi('teacher:allTopices:export')")
    @Log(title = "选题信息表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, teaTopices teaTopices)
    {
        List<teaTopices> list = teaTopicesService.selectteaTopicesList(teaTopices);
        ExcelUtil<teaTopices> util = new ExcelUtil<teaTopices>(teaTopices.class);
        util.exportExcel(response, list, "选题信息表数据");
    }

    /**
     * 获取选题信息表详细信息
     */
    @PreAuthorize("@ss.hasPermi('teacher:allTopices:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaTopicesService.selectteaTopicesById(id));
    }

    /**
     * 新增选题信息表
     */
    @PreAuthorize("@ss.hasPermi('teacher:allTopices:add')")
    @Log(title = "选题信息表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody teaTopices teaTopices)
    {
        return toAjax(teaTopicesService.insertteaTopices(teaTopices));
    }

    /**
     * 修改选题信息表
     */
    @PreAuthorize("@ss.hasPermi('teacher:allTopices:edit')")
    @Log(title = "选题信息表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody teaTopices teaTopices)
    {
        return toAjax(teaTopicesService.updateteaTopices(teaTopices));
    }

    /**
     * 删除选题信息表
     */
    @PreAuthorize("@ss.hasPermi('teacher:allTopices:remove')")
    @Log(title = "选题信息表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaTopicesService.deleteteaTopicesByIds(ids));
    }
}
