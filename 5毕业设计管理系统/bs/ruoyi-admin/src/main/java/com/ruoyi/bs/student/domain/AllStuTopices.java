package com.ruoyi.bs.student.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 选题信息表对象 t_topic
 *
 * @author Ystarry
 * @date 2021-12-05
 */
@Data
public class AllStuTopices extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 课题号 */
    @Excel(name = "课题名")
    private String thesisName;

    /** 课题号 */
    @Excel(name = "教师")
    private String teacherName;

    /** 课题号 */
    @Excel(name = "审核状态")
    private int status;

    /** 课题号 */
    @Excel(name = "难度")
    private String nandu;

    /** 课题号 */
    @Excel(name = "量")
    private String liang;

    /** 课题号 */
    @Excel(name = "题目类型")
    private String tofrom;

    /** 课题号 */
    @Excel(name = "系统类型")
    private String leixing;

    /** 课题号 */
    @Excel(name = "描述")
    private String descriptions;

    /** 课题号 */
    @Excel(name = "学号")
    private String studentNo;

    /** 课题号 */
    @Excel(name = "课题id")
    private Long thesisid;

    /** 学号 */
    @Excel(name = "学生id")
    private Long studentid;

    /** 选题时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "选题时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date selecttime;

}
