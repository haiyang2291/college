package com.ruoyi.web.controller.college;

import com.ruoyi.college.domain.Major;
import com.ruoyi.college.domain.dto.MajorDTO;
import com.ruoyi.college.service.MajorService;
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
 * 专业Controller
 *
 * @author 你的名字
 * @date 2025-02-27
 */
@RestController
@RequestMapping("/major/major")
public class MajorController extends BaseController
{
    @Autowired
    private MajorService majorService;

    /**
     * 查询专业列表
     */
    @PreAuthorize("@ss.hasPermi('major:major:list')")
    @GetMapping("/list")
    public TableDataInfo list(Major major)
    {
        startPage();
        List<MajorDTO> list = majorService.selectMajorList(major);
        return getDataTable(list);
    }

    /**
     * 导出专业列表
     */
    /**
     * 获取专业详细信息
     */
    @PreAuthorize("@ss.hasPermi('major:major:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(majorService.getById(id));
    }

    /**
     * 新增专业
     */
    @PreAuthorize("@ss.hasPermi('major:major:add')")
    @Log(title = "专业", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Major major)
    {
        return toAjax(majorService.save(major));
    }

    /**
     * 修改专业
     */
    @PreAuthorize("@ss.hasPermi('major:major:edit')")
    @Log(title = "专业", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Major major)
    {
        return toAjax(majorService.updateById(major));
    }

    /**
     * 删除专业
     */
    @PreAuthorize("@ss.hasPermi('major:major:remove')")
    @Log(title = "专业", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable List<Long> ids)
    {
        return toAjax(majorService.removeBatchByIds(ids));
    }

    @PreAuthorize("@ss.hasPermi('major:major:getDepartmentIdMajors')")
    @GetMapping("/getDepartmentIdMajors/{departmentId}")
    public AjaxResult getDepartmentIdMajors(@PathVariable Long departmentId)
    {
        return super.success(majorService.getDepartmentIdMajors(departmentId));
    }
}
