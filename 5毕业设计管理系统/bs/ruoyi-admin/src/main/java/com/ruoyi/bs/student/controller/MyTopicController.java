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
import com.ruoyi.bs.student.domain.MyTopic;
import com.ruoyi.bs.student.service.IMyTopicService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 选题信息表Controller
 *
 * @author Ystarry
 * @date 2021-11-22
 */
@RestController
@RequestMapping("/student/myTopic")
public class MyTopicController extends BaseController
{
    @Autowired
    private IMyTopicService myTopicService;

    /**
     * 查询选题信息表列表
     */
    @PreAuthorize("@ss.hasPermi('student:myTopic:list')")
    @GetMapping("/list")
    public TableDataInfo list(MyTopic myTopic)
    {
        startPage();
        List<MyTopic> list = myTopicService.selectMyTopicList(myTopic);
        System.out.println(list + "**********************");
        return getDataTable(list);
    }

    /**
     * 导出选题信息表列表
     */
    @PreAuthorize("@ss.hasPermi('student:myTopic:export')")
    @Log(title = "选题信息表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MyTopic myTopic)
    {
        List<MyTopic> list = myTopicService.selectMyTopicList(myTopic);
        ExcelUtil<MyTopic> util = new ExcelUtil<MyTopic>(MyTopic.class);
        util.exportExcel(response, list, "选题信息表数据");
    }

    /**
     * 查询当前用户的选题状态
     */
    @PreAuthorize("@ss.hasPermi('student:myTopic:query')")
    public String selectMyTopicByStatus(String studentNo){
        return myTopicService.selectMyTopicByStatus(studentNo);
    }

    /**
     * 获取选题信息表详细信息
     */
    @PreAuthorize("@ss.hasPermi('student:myTopic:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(myTopicService.selectMyTopicById(id));
    }

    /**
     * 新增选题信息表
     */
    @PreAuthorize("@ss.hasPermi('student:myTopic:add')")
    @Log(title = "选题信息表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MyTopic myTopic)
    {
        return toAjax(myTopicService.insertMyTopic(myTopic));
    }

    /**
     * 修改选题信息表
     */
    @PreAuthorize("@ss.hasPermi('student:myTopic:edit')")
    @Log(title = "选题信息表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MyTopic myTopic)
    {
        return toAjax(myTopicService.updateMyTopic(myTopic));
    }

    /**
     * 删除选题信息表
     */
    @PreAuthorize("@ss.hasPermi('student:myTopic:remove')")
    @Log(title = "选题信息表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(myTopicService.deleteMyTopicByIds(ids));
    }
}
