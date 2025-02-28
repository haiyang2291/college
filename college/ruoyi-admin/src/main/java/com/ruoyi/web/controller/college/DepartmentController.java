package com.ruoyi.web.controller.college;

import com.ruoyi.college.domain.Department;
import com.ruoyi.college.domain.dto.DepartmentDTO;
import com.ruoyi.college.service.DepartmentService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 院系管理Controller
 *
 * @author 你的名字
 * 2025-02-27
 */
@RestController
@RequestMapping("/department/department")
public class DepartmentController extends BaseController
{
    @Autowired
    private DepartmentService departmentService;

    /**
     * 查询院系管理列表
     */
    @PreAuthorize("@ss.hasPermi('department:department:list')")
    @GetMapping("/list")
    public TableDataInfo list(Department department)
    {
        startPage();
        List<DepartmentDTO> list = departmentService.selectDepartmentList(department);
        return getDataTable(list);
    }
    /*
     * 导出院系管理列表
     */
    /**
     * 获取院系管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('department:department:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(departmentService.getById(id));
    }

    /**
     * 新增院系管理
     */
    @PreAuthorize("@ss.hasPermi('department:department:add')")
    @Log(title = "院系管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Department department)
    {
        return toAjax(departmentService.save(department));
    }

    /**
     * 修改院系管理
     */
    @PreAuthorize("@ss.hasPermi('department:department:edit')")
    @Log(title = "院系管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Department department)
    {
        return toAjax(departmentService.updateById(department));
    }

    /**
     * 删除院系管理
     */
    @PreAuthorize("@ss.hasPermi('department:department:remove')")
    @Log(title = "院系管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable List<Long> ids)
    {
        return toAjax(departmentService.removeBatchByIds(ids));
    }
    @PreAuthorize("@ss.hasPermi('department:department:getCollegeIdDepartment')")
    @GetMapping("/getCollegeIdDepartment/{collegeId}")
    public AjaxResult getCollegeIdDepartment(@PathVariable("collegeId")Long collegeId){
        return success(departmentService.getCollegeIdDepartment(collegeId));
    }
}