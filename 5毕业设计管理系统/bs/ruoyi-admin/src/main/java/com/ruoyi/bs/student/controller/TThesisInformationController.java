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
import com.ruoyi.bs.student.domain.TThesisInformation;
import com.ruoyi.bs.student.service.ITThesisInformationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文档提交表Controller
 *
 * @author Ystarry
 * @date 2021-11-22
 */
@RestController
@RequestMapping("/student/FileInformation")
public class TThesisInformationController extends BaseController
{
    @Autowired
    private ITThesisInformationService tThesisInformationService;

    /**
     * 查询文档提交表列表
     */
    @PreAuthorize("@ss.hasPermi('student:FileInformation:list')")
    @GetMapping("/list")
    public TableDataInfo list(TThesisInformation tThesisInformation)
    {
        startPage();
        List<TThesisInformation> list = tThesisInformationService.selectTThesisInformationList(tThesisInformation);
        return getDataTable(list);
    }

    /**
     * 导出文档提交表列表
     */
    @PreAuthorize("@ss.hasPermi('student:FileInformation:export')")
    @Log(title = "文档提交表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TThesisInformation tThesisInformation)
    {
        List<TThesisInformation> list = tThesisInformationService.selectTThesisInformationList(tThesisInformation);
        ExcelUtil<TThesisInformation> util = new ExcelUtil<TThesisInformation>(TThesisInformation.class);
        util.exportExcel(response, list, "文档提交表数据");
    }

    /**
     * 获取文档提交表详细信息
     */
    /**
     * 查询学生文件是否提交
     */
    @PreAuthorize("@ss.hasPermi('student:FileInformation:query')")
    @GetMapping(value = "/{studentNo}")
    public AjaxResult getInfo(@PathVariable("studentNo") String studentNo)
    {
        return AjaxResult.success(tThesisInformationService.selectTThesisInformationByStuNo(studentNo));
    }

    /**
     * 新增文档提交表
     */
    @PreAuthorize("@ss.hasPermi('student:FileInformation:add')")
    @Log(title = "文档提交表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TThesisInformation tThesisInformation)
    {
        if (tThesisInformationService.selectTThesisInformationByStuNo(tThesisInformation.getStudentNo()) != null){
            return AjaxResult.error("系统也有你的文件，请选择重新上传！");
        }
        return toAjax(tThesisInformationService.insertTThesisInformation(tThesisInformation));
    }


//    @GetMapping()
//    public

    /**
     * 修改文档提交表
     */
    @PreAuthorize("@ss.hasPermi('student:FileInformation:edit')")
    @Log(title = "文档提交表", businessType = BusinessType.UPDATE)
    @PutMapping(value = "/edit")
    public AjaxResult edit(@RequestBody TThesisInformation tThesisInformation)
    {
        return toAjax(tThesisInformationService.updateTThesisInformation(tThesisInformation));
    }

    /**
     * 删除文档提交表
     */
    @PreAuthorize("@ss.hasPermi('student:FileInformation:remove')")
    @Log(title = "文档提交表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tThesisInformationService.deleteTThesisInformationByIds(ids));
    }
}
