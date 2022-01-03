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
import com.ruoyi.bs.teacher.domain.TeaThesisInformation;
import com.ruoyi.bs.teacher.service.ITeaThesisInformationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文档提交表Controller
 *
 * @author Ystarry
 * @date 2021-11-23
 */
@RestController
@RequestMapping("/teacher/fileInformation")
public class TeaThesisInformationController extends BaseController
{
    @Autowired
    private ITeaThesisInformationService teaThesisInformationService;

    /**
     * 查询文档提交表列表
     */
//    @PreAuthorize("@ss.hasPermi('teacher:fileInformation:list')")
    @PreAuthorize("@ss.hasRole('teacher')")
    @GetMapping("/list")
    public TableDataInfo list(TeaThesisInformation teaThesisInformation)
    {
        startPage();
        List<TeaThesisInformation> list = teaThesisInformationService.selectTeaThesisInformationList(teaThesisInformation);
        return getDataTable(list);
    }

    /**
     * 导出文档提交表列表
     */
    @PreAuthorize("@ss.hasPermi('teacher:fileInformation:export')")
    @Log(title = "文档提交表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TeaThesisInformation teaThesisInformation)
    {
        List<TeaThesisInformation> list = teaThesisInformationService.selectTeaThesisInformationList(teaThesisInformation);
        ExcelUtil<TeaThesisInformation> util = new ExcelUtil<TeaThesisInformation>(TeaThesisInformation.class);
        util.exportExcel(response, list, "文档提交表数据");
    }

    /**
     * 获取文档提交表详细信息
     */
    @PreAuthorize("@ss.hasPermi('teacher:fileInformation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaThesisInformationService.selectTeaThesisInformationById(id));
    }

    /**
     * 新增文档提交表
     */
    @PreAuthorize("@ss.hasPermi('teacher:fileInformation:add')")
    @Log(title = "文档提交表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaThesisInformation teaThesisInformation)
    {
        return toAjax(teaThesisInformationService.insertTeaThesisInformation(teaThesisInformation));
    }

    /**
     * 修改文档提交表
     */
    @PreAuthorize("@ss.hasPermi('teacher:fileInformation:edit')")
    @Log(title = "文档提交表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaThesisInformation teaThesisInformation)
    {
        return toAjax(teaThesisInformationService.updateTeaThesisInformation(teaThesisInformation));
    }

    /**
     * 删除文档提交表
     */
    @PreAuthorize("@ss.hasPermi('teacher:fileInformation:remove')")
    @Log(title = "文档提交表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaThesisInformationService.deleteTeaThesisInformationByIds(ids));
    }
}
