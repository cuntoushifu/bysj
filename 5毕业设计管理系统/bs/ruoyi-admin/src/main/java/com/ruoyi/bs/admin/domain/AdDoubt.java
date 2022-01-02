package com.ruoyi.bs.admin.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 疑问表对象 t_doubt
 *
 * @author Ystarry
 * @date 2021-12-28
 */
@Data
public class AdDoubt extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @Excel(name = "主键")
    private Integer id;

    /** 学号 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 疑问内容 */
    @Excel(name = "疑问内容")
    private String studentdoubt;

    /** 疑问内容 */
    @Excel(name = "疑问内容")
    private String answer;

}
