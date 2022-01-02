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
import com.ruoyi.bs.teacher.domain.TeaStudentScore;
import com.ruoyi.bs.teacher.service.ITeaStudentScoreService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生成绩表Controller
 *
 * @author Ystarry
 * @date 2021-11-23
 */
@RestController
@RequestMapping("/teacher/score")
public class TeaStudentScoreController extends BaseController
{
    @Autowired
    private ITeaStudentScoreService teaStudentScoreService;

    /**
     * 查询学生成绩表列表
     */
    @PreAuthorize("@ss.hasPermi('teacher:score:list')")
    @GetMapping("/list")
    public TableDataInfo list(TeaStudentScore teaStudentScore)
    {
        startPage();
        List<TeaStudentScore> list = teaStudentScoreService.selectTeaStudentScoreList(teaStudentScore);
        return getDataTable(list);
    }

    /**
     * 导出学生成绩表列表
     */
    @PreAuthorize("@ss.hasPermi('teacher:score:export')")
    @Log(title = "学生成绩表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TeaStudentScore teaStudentScore)
    {
        List<TeaStudentScore> list = teaStudentScoreService.selectTeaStudentScoreList(teaStudentScore);
        ExcelUtil<TeaStudentScore> util = new ExcelUtil<TeaStudentScore>(TeaStudentScore.class);
        util.exportExcel(response, list, "学生成绩表数据");
    }

    /**
     * 获取学生成绩表详细信息
     */
    @PreAuthorize("@ss.hasPermi('teacher:score:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(teaStudentScoreService.selectTeaStudentScoreById(id));
    }

    /**
     * 新增学生成绩表
     */
    @PreAuthorize("@ss.hasPermi('teacher:score:add')")
    @Log(title = "学生成绩表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeaStudentScore teaStudentScore)
    {
        System.out.println("**************");
        System.out.println(teaStudentScore);
        return toAjax(teaStudentScoreService.insertTeaStudentScore(teaStudentScore));
    }

    /**
     * 修改学生成绩表
     */
    @PreAuthorize("@ss.hasPermi('teacher:score:edit')")
    @Log(title = "学生成绩表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeaStudentScore teaStudentScore)
    {
        return toAjax(teaStudentScoreService.updateTeaStudentScore(teaStudentScore));
    }

    /**
     * 删除学生成绩表
     */
    @PreAuthorize("@ss.hasPermi('teacher:score:remove')")
    @Log(title = "学生成绩表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teaStudentScoreService.deleteTeaStudentScoreByIds(ids));
    }
}
