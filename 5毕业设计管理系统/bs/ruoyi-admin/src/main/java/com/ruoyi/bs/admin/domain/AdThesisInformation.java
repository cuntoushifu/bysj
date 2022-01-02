package com.ruoyi.bs.admin.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文档提交表对象 t_thesis_information
 *
 * @author Ystarry
 * @date 2021-12-01
 */
@Data
public class AdThesisInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 学号 */
    @Excel(name = "学号id")
    private Long studentid;

    /** 课题 */
    @Excel(name = "文件路径")
    private String thesistext;

    /** 课题 */
    @Excel(name = "学号")
    private String studentNo;

    /** 课题 */
    @Excel(name = "学生")
    private String studentName;

    /** 课题 */
    @Excel(name = "专业")
    private String majorName;


    /** 课题 */
    @Excel(name = "课题")
    private String thesisName;

    /** 状态 */
    @Excel(name = "文件状态")
    private Integer status;

    /** 描述 */
    @Excel(name = "描述")
    private String description;
}
