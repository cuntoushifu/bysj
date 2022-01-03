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
import com.ruoyi.bs.admin.domain.AdStudent;
import com.ruoyi.bs.admin.service.IAdStudentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生表Controller
 *
 * @author Ystarry
 * @date 2021-12-01
 */
@RestController
@RequestMapping("/admin/student")
public class AdStudentController extends BaseController
{
    @Autowired
    private IAdStudentService adStudentService;

    /**
     * 查询学生表列表
     */
    @PreAuthorize("@ss.hasPermi('admin:student:list')")
    @GetMapping("/list")
    public TableDataInfo list(AdStudent adStudent)
    {
        startPage();
        List<AdStudent> list = adStudentService.selectAdStudentList(adStudent);
        return getDataTable(list);
    }

    /**
     * 导出学生表列表
     */
    @PreAuthorize("@ss.hasPermi('admin:student:export')")
    @Log(title = "学生表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AdStudent adStudent)
    {
        List<AdStudent> list = adStudentService.selectAdStudentList(adStudent);
        ExcelUtil<AdStudent> util = new ExcelUtil<AdStudent>(AdStudent.class);
        util.exportExcel(response, list, "学生表数据");
    }

    /**
     * 获取学生表详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:student:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(adStudentService.selectAdStudentById(id));
    }

    /**
     * 新增学生表
     */
    @PreAuthorize("@ss.hasPermi('admin:student:add')")
    @Log(title = "学生表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AdStudent adStudent)
    {
        /**
         * 检索学生学号，如果学生学号存在，添加失败
         */
        if (adStudentService.selectAdStudentByStudentNo(adStudent.getStudentNo()) != null){
            return AjaxResult.error("添加学生" + adStudent.getStudentNo() + "失败，学生已存在");
        }

        return toAjax(adStudentService.insertAdStudent(adStudent));
    }

    /**
     * 修改学生表
     */
    @PreAuthorize("@ss.hasPermi('admin:student:edit')")
    @Log(title = "学生表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AdStudent adStudent)
    {
        return toAjax(adStudentService.updateAdStudent(adStudent));
    }

    /**
     * 删除学生表
     */
    @PreAuthorize("@ss.hasPermi('admin:student:remove')")
    @Log(title = "学生表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(adStudentService.deleteAdStudentByIds(ids));
    }
}
