package com.ruoyi.demo.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.demo.domain.DemoSchool;
import com.ruoyi.demo.mapper.DemoSchoolMapper;
import com.ruoyi.demo.service.IDemoSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * schoolService业务层处理
 * 
 * @author cyx
 * @date 2024-06-17
 */
@Service
public class DemoSchoolServiceImpl implements IDemoSchoolService
{
    @Autowired
    private DemoSchoolMapper schoolMapper;

    /**
     * 查询school
     * 
     * @param id school主键
     * @return school
     */
    @Override
    public DemoSchool selectSchoolById(Long id)
    {
        return schoolMapper.selectSchoolById(id);
    }

    /**
     * 查询school列表
     * 
     * @param school school
     * @return school
     */
    @Override
    public List<DemoSchool> selectSchoolList(DemoSchool school)
    {
        return schoolMapper.selectSchoolList(school);
    }

    /**
     * 新增school
     * 
     * @param school school
     * @return 结果
     */
    @Override
    public int insertSchool(DemoSchool school)
    {
        school.setCreateTime(DateUtils.getNowDate());
        return schoolMapper.insertSchool(school);
    }

    /**
     * 修改school
     * 
     * @param school school
     * @return 结果
     */
    @Override
    public int updateSchool(DemoSchool school)
    {
        school.setUpdateTime(DateUtils.getNowDate());
        return schoolMapper.updateSchool(school);
    }

    /**
     * 批量删除school
     * 
     * @param ids 需要删除的school主键
     * @return 结果
     */
    @Override
    public int deleteSchoolByIds(Long[] ids)
    {
        return schoolMapper.deleteSchoolByIds(ids);
    }

    /**
     * 删除school信息
     * 
     * @param id school主键
     * @return 结果
     */
    @Override
    public int deleteSchoolById(Long id)
    {
        return schoolMapper.deleteSchoolById(id);
    }
}
