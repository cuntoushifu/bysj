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
import com.ruoyi.bs.teacher.domain.TeaThesisTitle;
import com.ruoyi.bs.teacher.service.ITeaThesisTitleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教师提交课题表Controller
 *
 * @author Ystarry
 * @date 2021-12-01
 */
@RestController
@RequestMapping("/teacher/teaThesisTitle")
public class TeaThesisTitleController extends BaseController
{
    @Autowired
    private ITeaThesisTitleService teaThesisTitleService;

    /**
     * 查询教师提交课题表列表
     */
    @PreAuthorize("@ss.hasPermi('teacher:teaThesisTitle:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeaThesisTitle teaThesisTitle)
    {
        startPage();
        List<TeaThesisTitle> list = teaThesisTitleService.selectTeaThesisTitleList(teaThesisTitle);
        System.out.println(list);
        System.out.println("*************");
        return getDataTable(list);
    }

    /**
     * 导出教师提交课题表列表
     */
    @PreAuthorize("@ss.hasPermi('teacher:teaThesisTitle:export')")
    @Log(title = "教师提交课题表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TeaThesisTitle teaThesisTitle)
    {
        List<TeaThesisTitle> list = teaThesisTitleService.selectTeaThesisTitleList(teaThesisTitle);
        ExcelUtil<TeaThesisTitle> util = new ExcelUtil<TeaThesisTitle>(TeaThesisTitle.class);
        util.exportExcel(response, list, "教师提交课题表数据");
    }

    /**
     * 获取教师提交课题表详细信息
     */
    @PreAuthorize("@ss.hasPermi('teacher:teaThesisTitle:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        System.out.println("--------------");
        System.out.println(id);
        System.out.println("--------------");
        return AjaxResult.success(teaThesisTitleService.selectTeaThesisTitleById(id));
    }

    /**
     * 新增教师提交课题表
     */
    @PreAuthorize("@ss.hasPermi('teacher:teaThesisTitle:add')")
    @Log(title = "教师提交课题表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaThesisTitle teaThesisTitle)
    {
        return toAjax(teaThesisTitleService.insertTeaThesisTitle(teaThesisTitle));
    }

    /**
     * 修改教师提交课题表
     */
    @PreAuthorize("@ss.hasPermi('teacher:teaThesisTitle:edit')")
    @Log(title = "教师提交课题表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaThesisTitle teaThesisTitle)
    {
        return toAjax(teaThesisTitleService.updateTeaThesisTitle(teaThesisTitle));
    }

    /**
     * 删除教师提交课题表
     */
    @PreAuthorize("@ss.hasPermi('teacher:teaThesisTitle:remove')")
    @Log(title = "教师提交课题表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaThesisTitleService.deleteTeaThesisTitleByIds(ids));
    }
}
