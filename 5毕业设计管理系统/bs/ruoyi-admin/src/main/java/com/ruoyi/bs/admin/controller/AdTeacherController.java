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
import com.ruoyi.bs.admin.domain.AdTeacher;
import com.ruoyi.bs.admin.service.IAdTeacherService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教师表Controller
 *
 * @author Ystarry
 * @date 2021-12-01
 */
@RestController
@RequestMapping("/admin/teacher")
public class AdTeacherController extends BaseController
{
    @Autowired
    private IAdTeacherService adTeacherService;

    /**
     * 查询教师表列表
     */
    @PreAuthorize("@ss.hasPermi('admin:teacher:list')")
    @GetMapping("/list")
    public TableDataInfo list(AdTeacher adTeacher)
    {
        startPage();
        List<AdTeacher> list = adTeacherService.selectAdTeacherList(adTeacher);
        return getDataTable(list);
    }

    /**
     * 导出教师表列表
     */
    @PreAuthorize("@ss.hasPermi('admin:teacher:export')")
    @Log(title = "教师表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AdTeacher adTeacher)
    {
        List<AdTeacher> list = adTeacherService.selectAdTeacherList(adTeacher);
        ExcelUtil<AdTeacher> util = new ExcelUtil<AdTeacher>(AdTeacher.class);
        util.exportExcel(response, list, "教师表数据");
    }

    /**
     * 获取教师表详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:teacher:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(adTeacherService.selectAdTeacherById(id));
    }

    /**
     * 新增教师表
     */
    @PreAuthorize("@ss.hasPermi('admin:teacher:add')")
    @Log(title = "教师表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AdTeacher adTeacher)
    {
        /**
         * 检索教师职工号，如果存在，返回添加失败信息
         */
        if (adTeacherService.selectAdTeacherByTeacherNo(adTeacher.getTeacherNo()) != null){
            return AjaxResult.error("添加失败，当前教职工号"+ adTeacher.getTeacherNo() +"也存在");
        }
        return toAjax(adTeacherService.insertAdTeacher(adTeacher));
    }

    /**
     * 修改教师表
     */
    @PreAuthorize("@ss.hasPermi('admin:teacher:edit')")
    @Log(title = "教师表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AdTeacher adTeacher)
    {
        return toAjax(adTeacherService.updateAdTeacher(adTeacher));
    }

    /**
     * 删除教师表
     */
    @PreAuthorize("@ss.hasPermi('admin:teacher:remove')")
    @Log(title = "教师表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(adTeacherService.deleteAdTeacherByIds(ids));
    }
}
