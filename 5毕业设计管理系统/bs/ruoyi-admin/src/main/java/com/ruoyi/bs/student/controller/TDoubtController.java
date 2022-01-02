package com.ruoyi.bs.student.controller;

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
import com.ruoyi.bs.student.domain.TDoubt;
import com.ruoyi.bs.student.service.ITDoubtService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 疑问表Controller
 * 
 * @author Ystarry
 * @date 2021-11-22
 */
@RestController
@RequestMapping("/student/doubt")
public class TDoubtController extends BaseController
{
    @Autowired
    private ITDoubtService tDoubtService;

    /**
     * 查询疑问表列表
     */
    @PreAuthorize("@ss.hasPermi('student:doubt:list')")
    @GetMapping("/list")
    public TableDataInfo list(TDoubt tDoubt)
    {
        startPage();
        List<TDoubt> list = tDoubtService.selectTDoubtList(tDoubt);
        return getDataTable(list);
    }

    /**
     * 导出疑问表列表
     */
    @PreAuthorize("@ss.hasPermi('student:doubt:export')")
    @Log(title = "疑问表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TDoubt tDoubt)
    {
        List<TDoubt> list = tDoubtService.selectTDoubtList(tDoubt);
        ExcelUtil<TDoubt> util = new ExcelUtil<TDoubt>(TDoubt.class);
        util.exportExcel(response, list, "疑问表数据");
    }

    /**
     * 获取疑问表详细信息
     */
    @PreAuthorize("@ss.hasPermi('student:doubt:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(tDoubtService.selectTDoubtById(id));
    }

    /**
     * 新增疑问表
     */
    @PreAuthorize("@ss.hasPermi('student:doubt:add')")
    @Log(title = "疑问表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TDoubt tDoubt)
    {
        return toAjax(tDoubtService.insertTDoubt(tDoubt));
    }

    /**
     * 修改疑问表
     */
    @PreAuthorize("@ss.hasPermi('student:doubt:edit')")
    @Log(title = "疑问表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TDoubt tDoubt)
    {
        return toAjax(tDoubtService.updateTDoubt(tDoubt));
    }

    /**
     * 删除疑问表
     */
    @PreAuthorize("@ss.hasPermi('student:doubt:remove')")
    @Log(title = "疑问表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(tDoubtService.deleteTDoubtByIds(ids));
    }
}
