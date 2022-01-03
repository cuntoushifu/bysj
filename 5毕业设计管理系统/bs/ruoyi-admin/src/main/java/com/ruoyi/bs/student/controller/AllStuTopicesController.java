package com.ruoyi.bs.student.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.bs.student.service.impl.MyTopicServiceImpl;
import com.ruoyi.common.constant.UserConstants;
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
import com.ruoyi.bs.student.domain.AllStuTopices;
import com.ruoyi.bs.student.service.IAllStuTopicesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 选题信息表Controller
 *
 * @author Ystarry
 * @date 2021-12-05
 */
@RestController
@RequestMapping("/student/allStuTopices")
public class AllStuTopicesController extends BaseController
{
    @Autowired
    private IAllStuTopicesService allStuTopicesService;

    /**
     * 查询选题信息表列表
     */
    @PreAuthorize("@ss.hasPermi('student:allStuTopices:list')")
    @GetMapping("/list")
    public TableDataInfo list(AllStuTopices allStuTopices)
    {
        startPage();
        List<AllStuTopices> list = allStuTopicesService.selectAllStuTopicesList(allStuTopices);
        return getDataTable(list);
    }

    /**
     * 导出选题信息表列表
     */
    @PreAuthorize("@ss.hasPermi('student:allStuTopices:export')")
    @Log(title = "选题信息表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AllStuTopices allStuTopices)
    {
        List<AllStuTopices> list = allStuTopicesService.selectAllStuTopicesList(allStuTopices);
        ExcelUtil<AllStuTopices> util = new ExcelUtil<AllStuTopices>(AllStuTopices.class);
        util.exportExcel(response, list, "选题信息表数据");
    }

    /**
     * 获取选题信息表详细信息
     */
    @PreAuthorize("@ss.hasPermi('student:allStuTopices:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(allStuTopicesService.selectAllStuTopicesById(id));
    }

    /**
     * 新增选题信息表
     */
//    @PreAuthorize("@ss.hasPermi('student:allStuTopices:add')")
//    @Log(title = "选题信息表", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult add(@RequestBody AllStuTopices allStuTopices)
//    {
//        return toAjax(allStuTopicesService.insertAllStuTopices(allStuTopices));
//    }

    /**
     * 修改选题信息表
     */
    @PreAuthorize("@ss.hasPermi('student:allStuTopices:edit')")
    @Log(title = "选题信息表", businessType = BusinessType.UPDATE)
    @PutMapping(value = "/edit")
    public AjaxResult edit(@RequestBody AllStuTopices allStuTopices)
    {
        if (allStuTopicesService.selCurrentTopicStatus(allStuTopices.getId())) {
            System.out.println(allStuTopicesService.selCurrentTopicStatus(allStuTopices.getId()));

            return AjaxResult.error("课题：'" + allStuTopices.getThesisName() + "'已不可选");
        }

        if (allStuTopicesService.selStuTopicinfo(allStuTopices.getStudentNo()))
        {
            return AjaxResult.error("你已选择其他课题");
        }

        return toAjax(allStuTopicesService.updateAllStuTopices(allStuTopices));
    }

    /**
     * 删除选题信息表
     */
    @PreAuthorize("@ss.hasPermi('student:allStuTopices:remove')")
    @Log(title = "选题信息表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(allStuTopicesService.deleteAllStuTopicesByIds(ids));
    }
}
