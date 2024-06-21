package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.School;
import com.ruoyi.system.service.ISchoolService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * schoolController
 * 
 * @author ruoyi
 * @date 2024-06-17
 */
@RestController
@RequestMapping("/system/school")
public class SchoolController extends BaseController
{
    @Autowired
    private ISchoolService schoolService;

    /**
     * 查询school列表
     */
    @PreAuthorize("@ss.hasPermi('system:school:list')")
    @GetMapping("/list")
    public TableDataInfo list(School school)
    {
        startPage();
        List<School> list = schoolService.selectSchoolList(school);
        return getDataTable(list);
    }

    /**
     * 导出school列表
     */
    @PreAuthorize("@ss.hasPermi('system:school:export')")
    @Log(title = "school", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, School school)
    {
        List<School> list = schoolService.selectSchoolList(school);
        ExcelUtil<School> util = new ExcelUtil<School>(School.class);
        util.exportExcel(response, list, "school数据");
    }

    /**
     * 获取school详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:school:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(schoolService.selectSchoolById(id));
    }

    /**
     * 新增school
     */
    @PreAuthorize("@ss.hasPermi('system:school:add')")
    @Log(title = "school", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody School school)
    {
        return toAjax(schoolService.insertSchool(school));
    }

    /**
     * 修改school
     */
    @PreAuthorize("@ss.hasPermi('system:school:edit')")
    @Log(title = "school", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody School school)
    {
        return toAjax(schoolService.updateSchool(school));
    }

    /**
     * 删除school
     */
    @PreAuthorize("@ss.hasPermi('system:school:remove')")
    @Log(title = "school", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(schoolService.deleteSchoolByIds(ids));
    }
}
