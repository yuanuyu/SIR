package com.ruoyi.demo.service;

import com.ruoyi.demo.domain.DemoSchool;

import java.util.List;

/**
 * schoolService接口
 * 
 * @author cyx
 * @date 2024-06-17
 */
public interface IDemoSchoolService
{
    /**
     * 查询school
     * 
     * @param id school主键
     * @return school
     */
    public DemoSchool selectSchoolById(Long id);

    /**
     * 查询school列表
     * 
     * @param school school
     * @return school集合
     */
    public List<DemoSchool> selectSchoolList(DemoSchool school);

    /**
     * 新增school
     * 
     * @param school school
     * @return 结果
     */
    public int insertSchool(DemoSchool school);

    /**
     * 修改school
     * 
     * @param school school
     * @return 结果
     */
    public int updateSchool(DemoSchool school);

    /**
     * 批量删除school
     * 
     * @param ids 需要删除的school主键集合
     * @return 结果
     */
    public int deleteSchoolByIds(Long[] ids);

    /**
     * 删除school信息
     * 
     * @param id school主键
     * @return 结果
     */
    public int deleteSchoolById(Long id);
}
