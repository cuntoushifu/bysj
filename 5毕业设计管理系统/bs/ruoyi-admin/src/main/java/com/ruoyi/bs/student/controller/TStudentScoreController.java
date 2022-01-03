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
import com.ruoyi.bs.student.domain.TStudentScore;
import com.ruoyi.bs.student.service.ITStudentScoreService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生成绩表Controller
 * 
 * @author Ystarry
 * @date 2021-11-22
 */
@RestController
@RequestMapping("/student/score")
public class TStudentScoreController extends BaseController
{
    @Autowired
    private ITStudentScoreService tStudentScoreService;

    /**
     * 查询学生成绩表列表
     */
    @PreAuthorize("@ss.hasPermi('student:score:list')")
    @GetMapping("/list")
    public TableDataInfo list(TStudentScore tStudentScore)
    {
        startPage();
        List<TStudentScore> list = tStudentScoreService.selectTStudentScoreList(tStudentScore);
        return getDataTable(list);
    }

    /**
     * 导出学生成绩表列表
     */
    @PreAuthorize("@ss.hasPermi('student:score:export')")
    @Log(title = "学生成绩表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TStudentScore tStudentScore)
    {
        List<TStudentScore> list = tStudentScoreService.selectTStudentScoreList(tStudentScore);
        ExcelUtil<TStudentScore> util = new ExcelUtil<TStudentScore>(TStudentScore.class);
        util.exportExcel(response, list, "学生成绩表数据");
    }

    /**
     * 获取学生成绩表详细信息
     */
    @PreAuthorize("@ss.hasPermi('student:score:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tStudentScoreService.selectTStudentScoreById(id));
    }

    /**
     * 新增学生成绩表
     */
    @PreAuthorize("@ss.hasPermi('student:score:add')")
    @Log(title = "学生成绩表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TStudentScore tStudentScore)
    {
        return toAjax(tStudentScoreService.insertTStudentScore(tStudentScore));
    }

    /**
     * 修改学生成绩表
     */
    @PreAuthorize("@ss.hasPermi('student:score:edit')")
    @Log(title = "学生成绩表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TStudentScore tStudentScore)
    {
        return toAjax(tStudentScoreService.updateTStudentScore(tStudentScore));
    }

    /**
     * 删除学生成绩表
     */
    @PreAuthorize("@ss.hasPermi('student:score:remove')")
    @Log(title = "学生成绩表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tStudentScoreService.deleteTStudentScoreByIds(ids));
    }
}
