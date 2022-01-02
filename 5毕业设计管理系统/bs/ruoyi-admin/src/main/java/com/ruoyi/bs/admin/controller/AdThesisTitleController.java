package com.ruoyi.bs.admin.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.bs.admin.domain.AdTopices;
import com.ruoyi.bs.admin.service.IAdTopicesService;
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
import com.ruoyi.bs.admin.domain.AdThesisTitle;
import com.ruoyi.bs.admin.service.IAdThesisTitleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教师提交课题表Controller
 *
 * @author Ystarry
 * @date 2021-12-01
 */
@RestController
@RequestMapping("/admin/AdThesisTitle")
public class AdThesisTitleController extends BaseController
{
    @Autowired
    private IAdThesisTitleService iAdThesisTitleService;

    /**
     * 课题审核通过就添加到选题表topic
     */
    @Autowired
    private IAdTopicesService iAdTopicesService;
//    private Object adTopices;

    /**
     * 查询课题申请表列表
     */
//    @PreAuthorize("@ss.hasPermi('admin:title:list')")
//    @RequiresRoles("admin")
//    @RequiresPermissions({"system:user:add", "system:user:update"})
    @PreAuthorize("@ss.hasRole('common')")
    @GetMapping("/list")
    public TableDataInfo list(AdThesisTitle tThesisTitle)
    {
        startPage();
        List<AdThesisTitle> list = iAdThesisTitleService.selectTThesisTitleList(tThesisTitle);
        return getDataTable(list);
    }

    /**
     * 导出课题申请表列表
     */
//    @PreAuthorize("@ss.hasPermi('admin:title:export')")
    @PreAuthorize("@ss.hasRole('common')")
    @Log(title = "课题申请表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AdThesisTitle tThesisTitle)
    {
        List<AdThesisTitle> list = iAdThesisTitleService.selectTThesisTitleList(tThesisTitle);
        ExcelUtil<AdThesisTitle> util = new ExcelUtil<AdThesisTitle>(AdThesisTitle.class);
        util.exportExcel(response, list, "课题申请表数据");
    }

    /**
     * 获取课题申请表详细信息
     */
//    @PreAuthorize("@ss.hasPermi('admin:title:query')")
    @PreAuthorize("@ss.hasRole('common')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(iAdThesisTitleService.selectTThesisTitleById(id));
    }

    /**
     * 新增课题申请表
     */
//    @PreAuthorize("@ss.hasPermi('admin:title:add')")
    @PreAuthorize("@ss.hasRole('common')")
    @Log(title = "课题申请表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AdThesisTitle tThesisTitle)
    {
        return toAjax(iAdThesisTitleService.insertTThesisTitle(tThesisTitle));
    }

    /**
     * 修改课题申请表
     */
//    @PreAuthorize("@ss.hasPermi('admin:title:edit')")
    @PreAuthorize("@ss.hasRole('common')")
    @Log(title = "课题申请表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AdThesisTitle tThesisTitle)
    {
        if (tThesisTitle.getStatus().equals(2)){
            AdTopices adTopices = new AdTopices();
            adTopices.setThesisid(tThesisTitle.getId());
//            adTopices.setSelecttime(tThesisTitle.getSubmittime());
            iAdTopicesService.insertAdTopices(adTopices);
        }
        return toAjax(iAdThesisTitleService.updateTThesisTitle(tThesisTitle));
    }

    /**
     * 删除课题申请表
     */
//    @PreAuthorize("@ss.hasPermi('admin:title:remove')")
    @PreAuthorize("@ss.hasRole('common')")
    @Log(title = "课题申请表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(iAdThesisTitleService.deleteTThesisTitleByIds(ids));
    }
}
