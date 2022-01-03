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
import com.ruoyi.bs.teacher.domain.TeaStudent;
import com.ruoyi.bs.teacher.service.ITeaStudentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生表Controller
 *
 * @author Ystarry
 * @date 2021-11-23
 */
@RestController
@RequestMapping("/teacher/student")
public class TeaStudentController extends BaseController
{
    @Autowired
    private ITeaStudentService teaStudentService;

    /**
     * 查询学生表列表
     */
    @PreAuthorize("@ss.hasPermi('teacher:student:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeaStudent teaStudent)
    {
        startPage();
        List<TeaStudent> list = teaStudentService.selectTeaStudentList(teaStudent);
        return getDataTable(list);
    }

    /**
     * 导出学生表列表
     */
    @PreAuthorize("@ss.hasPermi('teacher:student:export')")
    @Log(title = "学生表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TeaStudent teaStudent)
    {
        List<TeaStudent> list = teaStudentService.selectTeaStudentList(teaStudent);
        ExcelUtil<TeaStudent> util = new ExcelUtil<TeaStudent>(TeaStudent.class);
        util.exportExcel(response, list, "学生表数据");
    }

    /**
     * 获取学生表详细信息
     */
    @PreAuthorize("@ss.hasPermi('teacher:student:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaStudentService.selectTeaStudentById(id));
    }

    /**
     * 新增学生表
     */
    @PreAuthorize("@ss.hasPermi('teacher:student:add')")
    @Log(title = "学生表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaStudent teaStudent)
    {
        return toAjax(teaStudentService.insertTeaStudent(teaStudent));
    }

    /**
     * 修改学生表
     */
    @PreAuthorize("@ss.hasPermi('teacher:student:edit')")
    @Log(title = "学生表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaStudent teaStudent)
    {
        return toAjax(teaStudentService.updateTeaStudent(teaStudent));
    }

    /**
     * 删除学生表
     */
    @PreAuthorize("@ss.hasPermi('teacher:student:remove')")
    @Log(title = "学生表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaStudentService.deleteTeaStudentByIds(ids));
    }
}
