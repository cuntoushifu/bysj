package com.ruoyi.bs.admin.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生表对象 t_student
 *
 * @author Ystarry
 * @date 2021-12-01
 */
@Data
public class AdStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 学号 */
    @Excel(name = "学号")
    private String studentNo;

    /** 姓名 */
    @Excel(name = "姓名")
    private String studentName;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 专业号 */
    @Excel(name = "专业id")
    private Long majorid;

    /** 年级 */
    @Excel(name = "专业")
    private String majorName;

    /** 年级 */
    @Excel(name = "年级")
    private String grade;

    /** 创建者 */
    @Excel(name = "创建者")
    private String inputMan;

    /** 时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastModifyTime;

    /** $column.columnComment */
    @Excel(name = "手机")
    private String phone;

    /** $column.columnComment */
    @Excel(name = "邮箱")
    private String email;

}
