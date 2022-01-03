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
import com.ruoyi.bs.admin.domain.AdDoubt;
import com.ruoyi.bs.admin.service.IAdDoubtService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 疑问表Controller
 * 
 * @author Ystarry
 * @date 2021-12-28
 */
@RestController
@RequestMapping("/admin/doubt")
public class AdDoubtController extends BaseController
{
    @Autowired
    private IAdDoubtService adDoubtService;

    /**
     * 查询疑问表列表
     */
    @PreAuthorize("@ss.hasPermi('admin:doubt:list')")
    @GetMapping("/list")
    public TableDataInfo list(AdDoubt adDoubt)
    {
        startPage();
        List<AdDoubt> list = adDoubtService.selectAdDoubtList(adDoubt);
        return getDataTable(list);
    }

    /**
     * 导出疑问表列表
     */
    @PreAuthorize("@ss.hasPermi('admin:doubt:export')")
    @Log(title = "疑问表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AdDoubt adDoubt)
    {
        List<AdDoubt> list = adDoubtService.selectAdDoubtList(adDoubt);
        ExcelUtil<AdDoubt> util = new ExcelUtil<AdDoubt>(AdDoubt.class);
        util.exportExcel(response, list, "疑问表数据");
    }

    /**
     * 获取疑问表详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:doubt:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(adDoubtService.selectAdDoubtById(id));
    }

    /**
     * 新增疑问表
     */
    @PreAuthorize("@ss.hasPermi('admin:doubt:add')")
    @Log(title = "疑问表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AdDoubt adDoubt)
    {
        return toAjax(adDoubtService.insertAdDoubt(adDoubt));
    }

    /**
     * 修改疑问表
     */
    @PreAuthorize("@ss.hasPermi('admin:doubt:edit')")
    @Log(title = "疑问表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AdDoubt adDoubt)
    {
        return toAjax(adDoubtService.updateAdDoubt(adDoubt));
    }

    /**
     * 删除疑问表
     */
    @PreAuthorize("@ss.hasPermi('admin:doubt:remove')")
    @Log(title = "疑问表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(adDoubtService.deleteAdDoubtByIds(ids));
    }
}
