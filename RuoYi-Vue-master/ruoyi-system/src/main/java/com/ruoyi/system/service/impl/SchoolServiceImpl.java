package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SchoolMapper;
import com.ruoyi.system.domain.School;
import com.ruoyi.system.service.ISchoolService;

/**
 * schoolService业务层处理
 * 
 * @author ruoyi
 * @date 2024-06-17
 */
@Service
public class SchoolServiceImpl implements ISchoolService 
{
    @Autowired
    private SchoolMapper schoolMapper;

    /**
     * 查询school
     * 
     * @param id school主键
     * @return school
     */
    @Override
    public School selectSchoolById(Long id)
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
    public List<School> selectSchoolList(School school)
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
    public int insertSchool(School school)
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
    public int updateSchool(School school)
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

    @Override
    public List<School> getAllSchools() {
        return null;
    }
}
