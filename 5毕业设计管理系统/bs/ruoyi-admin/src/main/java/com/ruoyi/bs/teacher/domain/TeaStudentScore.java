package com.ruoyi.bs.teacher.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生成绩表对象 t_student_score
 *
 * @author Ystarry
 * @date 2021-11-23
 */
@Data
public class TeaStudentScore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 学号 */
    @Excel(name = "学生id")
    private Long studentid;

    /** 学号 */
    @Excel(name = "学号")
    private String studentNo;

    /** 学号 */
    @Excel(name = "学生")
    private String studentName;

    /** 成绩 */
    @Excel(name = "成绩")
    private Long thesisresult;

    /** 创建者 */
    @Excel(name = "创建者")
    private String inputman;

    /** 创建者 */
    @Excel(name = "教师号")
    private String teacherNo;

}
