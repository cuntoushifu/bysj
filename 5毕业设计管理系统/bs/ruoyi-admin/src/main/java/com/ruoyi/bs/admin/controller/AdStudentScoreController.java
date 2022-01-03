package com.ruoyi.bs.admin.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.bs.admin.mapper.AdStudentMapper;
import com.ruoyi.bs.admin.service.IAdStudentService;
import com.ruoyi.bs.admin.service.impl.AdStudentServiceImpl;
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
import com.ruoyi.bs.admin.domain.AdStudentScore;
import com.ruoyi.bs.admin.service.IAdStudentScoreService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生成绩表Controller
 *
 * @author Ystarry
 * @date 2021-12-01
 */
@RestController
@RequestMapping("/admin/StuScore")
public class AdStudentScoreController extends BaseController {
    @Autowired
    private IAdStudentScoreService adStudentScoreService;

    @Autowired
    private IAdStudentService adStudentService;

    /**
     * 查询学生成绩表列表
     */
    @PreAuthorize("@ss.hasPermi('admin:StuScore:list')")
    @GetMapping("/list")
    public TableDataInfo list(AdStudentScore adStudentScore) {
        startPage();
        List<AdStudentScore> list = adStudentScoreService.selectAdStudentScoreList(adStudentScore);
        return getDataTable(list);
    }

    /**
     * 导出学生成绩表列表
     */
    @PreAuthorize("@ss.hasPermi('admin:StuScore:export')")
    @Log(title = "学生成绩表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AdStudentScore adStudentScore) {
        List<AdStudentScore> list = adStudentScoreService.selectAdStudentScoreList(adStudentScore);
        ExcelUtil<AdStudentScore> util = new ExcelUtil<AdStudentScore>(AdStudentScore.class);
        util.exportExcel(response, list, "学生成绩表数据");
    }

    /**
     * 获取学生成绩表详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:StuScore:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(adStudentScoreService.selectAdStudentScoreById(id));
    }

    /**
     * 新增学生成绩表
     */
    @PreAuthorize("@ss.hasPermi('admin:StuScore:add')")
    @Log(title = "学生成绩表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AdStudentScore adStudentScore) {
        /**
         * 搜索学生表
         * 如果学生不存在，提示学生不存在
         */
        if (adStudentService.selectAdStudentByStudentNo(adStudentScore.getStudentNo()).equals(null)) {
            return AjaxResult.error("添加失败，学生不存在");
        }
        /**
         * 如果学生成绩存在，提示学生存在了
         */
        if (adStudentScoreService.selectAdStudentScoreByStudentNo(adStudentScore.getStudentNo()) != null) {
            return AjaxResult.error("添加失败，学生成绩以存在");
        }
        /**
         * 添加
         */
        return toAjax(adStudentScoreService.insertAdStudentScore(adStudentScore));
    }

    /**
     * 修改学生成绩表
     */
    @PreAuthorize("@ss.hasPermi('admin:StuScore:edit')")
    @Log(title = "学生成绩表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AdStudentScore adStudentScore) {
        return toAjax(adStudentScoreService.updateAdStudentScore(adStudentScore));
    }

    /**
     * 删除学生成绩表
     */
    @PreAuthorize("@ss.hasPermi('admin:StuScore:remove')")
    @Log(title = "学生成绩表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(adStudentScoreService.deleteAdStudentScoreByIds(ids));
    }
}
