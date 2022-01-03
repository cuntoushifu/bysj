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
 * @date 2021-11-22
 */
@Data
public class MyTopic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 课题号 */
    @Excel(name = "课题id")
    private Long thesisid;

    /** 课题号 */
    @Excel(name = "课题")
    private String thesisName;

    /** 学号 */
    @Excel(name = "学生id")
    private Long studentid;

    /** 学号 */
    @Excel(name = "学号")
    private String studentNo;

    /** 学号 */
    @Excel(name = "学生")
    private String studentName;

    /** 课题号 */
    @Excel(name = "教师")
    private String teacherName;

    /** 选题时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "选题时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date selecttime;

    /** 状态*/
    @Excel(name = "课题状态")
    private String status;

    /** 状态*/
    @Excel(name = "选题状态")
    private Integer selectStatus;

}
