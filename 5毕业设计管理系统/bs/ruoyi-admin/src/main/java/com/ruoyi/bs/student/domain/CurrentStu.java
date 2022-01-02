package com.ruoyi.bs.student.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

@Data
public class CurrentStu extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 学号 */
    @Excel(name = "学号")
    private String studentid;
}
