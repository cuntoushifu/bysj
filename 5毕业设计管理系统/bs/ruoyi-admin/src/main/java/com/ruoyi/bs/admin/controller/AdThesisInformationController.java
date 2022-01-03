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
import com.ruoyi.bs.admin.domain.AdThesisInformation;
import com.ruoyi.bs.admin.service.IAdThesisInformationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文档提交表Controller
 *
 * @author Ystarry
 * @date 2021-12-01
 */
@RestController
@RequestMapping("/admin/fileInformation")
public class AdThesisInformationController extends BaseController
{
    @Autowired
    private IAdThesisInformationService adThesisInformationService;

    /**
     * 查询文档提交表列表
     */
    @PreAuthorize("@ss.hasPermi('admin:fileInformation:list')")
    @GetMapping("/list")
    public TableDataInfo list(AdThesisInformation adThesisInformation)
    {
        startPage();
        List<AdThesisInformation> list = adThesisInformationService.selectAdThesisInformationList(adThesisInformation);
        return getDataTable(list);
    }

    /**
     * 导出文档提交表列表
     */
    @PreAuthorize("@ss.hasPermi('admin:fileInformation:export')")
    @Log(title = "文档提交表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AdThesisInformation adThesisInformation)
    {
        List<AdThesisInformation> list = adThesisInformationService.selectAdThesisInformationList(adThesisInformation);
        ExcelUtil<AdThesisInformation> util = new ExcelUtil<AdThesisInformation>(AdThesisInformation.class);
        util.exportExcel(response, list, "文档提交表数据");
    }

    /**
     * 获取文档提交表详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:fileInformation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(adThesisInformationService.selectAdThesisInformationById(id));
    }

    /**
     * 新增文档提交表
     */
    @PreAuthorize("@ss.hasPermi('admin:fileInformation:add')")
    @Log(title = "文档提交表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AdThesisInformation adThesisInformation)
    {
        return toAjax(adThesisInformationService.insertAdThesisInformation(adThesisInformation));
    }

    /**
     * 修改文档提交表
     */
    @PreAuthorize("@ss.hasPermi('admin:fileInformation:edit')")
    @Log(title = "文档提交表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AdThesisInformation adThesisInformation)
    {
        return toAjax(adThesisInformationService.updateAdThesisInformation(adThesisInformation));
    }

    /**
     * 删除文档提交表
     */
    @PreAuthorize("@ss.hasPermi('admin:fileInformation:remove')")
    @Log(title = "文档提交表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(adThesisInformationService.deleteAdThesisInformationByIds(ids));
    }
}
