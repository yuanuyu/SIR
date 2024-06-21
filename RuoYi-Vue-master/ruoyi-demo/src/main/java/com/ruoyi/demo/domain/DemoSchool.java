package com.ruoyi.demo.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * school对象 school
 * 
 * @author cyx
 * @date 2024-06-17
 */
public class DemoSchool extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 删除标识（0为已删除，1为正常） */
    private String delFlag;

    /** 学校名称 */
    @Excel(name = "学校名称")
    private String schoolName;

    /** 学校建学年限 */
    @Excel(name = "学校建学年限")
    private String schoolAge;

    /** 学校面积 */
    @Excel(name = "学校面积")
    private String schoolArea;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setSchoolName(String schoolName) 
    {
        this.schoolName = schoolName;
    }

    public String getSchoolName() 
    {
        return schoolName;
    }
    public void setSchoolAge(String schoolAge) 
    {
        this.schoolAge = schoolAge;
    }

    public String getSchoolAge() 
    {
        return schoolAge;
    }
    public void setSchoolArea(String schoolArea) 
    {
        this.schoolArea = schoolArea;
    }

    public String getSchoolArea() 
    {
        return schoolArea;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("delFlag", getDelFlag())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("schoolName", getSchoolName())
            .append("schoolAge", getSchoolAge())
            .append("schoolArea", getSchoolArea())
            .toString();
    }
}
