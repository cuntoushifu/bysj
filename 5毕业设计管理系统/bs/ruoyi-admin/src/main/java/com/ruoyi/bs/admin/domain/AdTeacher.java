package com.ruoyi.bs.admin.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.DataSource;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教师表对象 t_teacher
 *
 * @author Ystarry
 * @date 2021-12-01
 */
@Data
public class AdTeacher extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 教师号 */
    @Excel(name = "教师号")
    private String teacherNo;

    /** 姓名 */
    @Excel(name = "教师")
    private String teacherName;

    /** 学院id */
    @Excel(name = "学院id")
    private Long departmentId;

    /** 性别 */
    @Excel(name = "学院")
    private String departmentName;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 创建者 */
    @Excel(name = "创建者")
    private String inputMan;

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastModifyTime;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 职称 */
    @Excel(name = "职称")
    private String zhicheng;
}
