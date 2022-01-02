package com.ruoyi.bs.admin.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教师提交课题表对象 t_thesis_title
 *
 * @author Ystarry
 * @date 2021-12-01
 */
@Data
public class AdThesisTitle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 课题 */
    @Excel(name = "课题")
    private String thesisname;

    /** 教师 */
    @Excel(name = "教师id")
    private Long teacherid;

    /** 教师 */
    @Excel(name = "教师")
    private String teacherName;

    /** 提交时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "提交时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date submittime;

    /** 课题审核 */
    @Excel(name = "课题审核")
    private Integer status;

    /** 创建者 */
    @Excel(name = "创建者")
    private String inputman;

    /** 难度 */
    @Excel(name = "难度")
    private String nandu;

    /** $column.columnComment */
    @Excel(name = "难度")
    private String liang;

    /** 发起人 */
    @Excel(name = "课题类型")
    private String tofrom;

    /** 类型 */
    @Excel(name = "系统类型")
    private String leixing;

    /** 描述 */
    @Excel(name = "描述")
    private String descriptions;

}
