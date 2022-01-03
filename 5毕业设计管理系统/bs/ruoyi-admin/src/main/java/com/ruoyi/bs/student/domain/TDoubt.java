package com.ruoyi.bs.student.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 疑问表对象 t_doubt
 *
 * @author Ystarry
 * @date 2021-11-22
 */
@Data
public class TDoubt extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @Excel(name = "编号")
    private Integer id;

    /** 学号 */
    @Excel(name = "学生id")
    private Integer studentid;

    /** 学号 */
    @Excel(name = "学生")
    private String studentName;

    /** 学号 */
    @Excel(name = "学号")
    private String studentNo;

    /** 疑问内容 */
    @Excel(name = "疑问内容")
    private String studentdoubt;

    /** 疑问内容 */
    @Excel(name = "疑问答复")
    private String answer;

}
