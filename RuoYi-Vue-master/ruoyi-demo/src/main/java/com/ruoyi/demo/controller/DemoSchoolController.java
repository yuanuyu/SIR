package com.ruoyi.demo.controller;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.demo.domain.DemoSchool;
import com.ruoyi.demo.service.IDemoSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * schoolController
 * 
 * @author cyx
 * @date 2024-06-17
 */
@RestController
@RequestMapping("/demo/demoschool")
public class DemoSchoolController extends BaseController
{
    @Autowired
    private IDemoSchoolService schoolService;

    /**
     * 查询school列表
     */


    @Anonymous
    @GetMapping("/list")
    public TableDataInfo list(DemoSchool school)
    {
        startPage();
        System.out.println("跳转成功");
        List<DemoSchool> list = schoolService.selectSchoolList(school);
        return getDataTable(list);
    }

    /**
     * 导出school列表
     */

    @Log(title = "school", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DemoSchool school)
    {
        List<DemoSchool> list = schoolService.selectSchoolList(school);
        ExcelUtil<DemoSchool> util = new ExcelUtil<DemoSchool>(DemoSchool.class);
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
    public AjaxResult add(@RequestBody DemoSchool school)
    {
        return toAjax(schoolService.insertSchool(school));
    }

    /**
     * 修改school
     */
    @PreAuthorize("@ss.hasPermi('system:school:edit')")
    @Log(title = "school", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DemoSchool school)
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
