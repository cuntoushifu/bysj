package com.ruoyi.bs.admin.controller;

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
import com.ruoyi.bs.admin.domain.AdTopices;
import com.ruoyi.bs.admin.service.IAdTopicesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 选题信息表Controller
 *
 * @author Ystarry
 * @date 2021-12-01
 */
@RestController
@RequestMapping("/admin/allTopices")
public class AdTopicesController extends BaseController
{
    @Autowired
    private IAdTopicesService adTopicesService;

    /**
     * 查询选题信息表列表
     */
//    @PreAuthorize("@ss.hasPermi('admin:allTopices:list')")
    @PreAuthorize("@ss.hasRole('common')")
    @GetMapping("/list")
    public TableDataInfo list(AdTopices adTopices)
    {
        startPage();
        List<AdTopices> list = adTopicesService.selectAdTopicesList(adTopices);
        return getDataTable(list);
    }

    /**
     * 导出选题信息表列表
     */
//    @PreAuthorize("@ss.hasPermi('admin:allTopices:export')")
    @PreAuthorize("@ss.hasRole('common')")
    @Log(title = "选题信息表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AdTopices adTopices)
    {
        List<AdTopices> list = adTopicesService.selectAdTopicesList(adTopices);
        ExcelUtil<AdTopices> util = new ExcelUtil<AdTopices>(AdTopices.class);
        util.exportExcel(response, list, "选题信息表数据");
    }

    /**
     * 获取选题信息表详细信息
     */
//    @PreAuthorize("@ss.hasPermi('admin:allTopices:query')")
    @PreAuthorize("@ss.hasRole('common')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(adTopicesService.selectAdTopicesById(id));
    }

    /**
     * 新增选题信息表
     */
//    @PreAuthorize("@ss.hasPermi('admin:allTopices:add')")
    @PreAuthorize("@ss.hasRole('common')")
    @Log(title = "选题信息表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AdTopices adTopices)
    {
        return toAjax(adTopicesService.insertAdTopices(adTopices));
    }

    /**
     * 修改选题信息表
     */
//    @PreAuthorize("@ss.hasPermi('admin:allTopices:edit')")
    @PreAuthorize("@ss.hasRole('common')")
    @Log(title = "选题信息表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AdTopices adTopices)
    {
        System.out.println("//////////////////////////");
        System.out.println(adTopices);
        System.out.println("//////////////////////////");
        return toAjax(adTopicesService.updateAdTopices(adTopices));
    }

    /**
     * 删除选题信息表
     */
//    @PreAuthorize("@ss.hasPermi('admin:allTopices:remove')")
    @PreAuthorize("@ss.hasRole('common')")
    @Log(title = "选题信息表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(adTopicesService.deleteAdTopicesByIds(ids));
    }
}
