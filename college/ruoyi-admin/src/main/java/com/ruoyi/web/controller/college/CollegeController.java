package com.ruoyi.web.controller.college;

import com.ruoyi.college.domain.College;
import com.ruoyi.college.service.CollegeService;
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
 * 高校管理Controller
 *
 * @author 我的名字
 * @date 2025-02-26
 */
@RestController
@RequestMapping("/college/college")
public class CollegeController extends BaseController
{
    @Autowired
    private CollegeService collegeService;

    /**
     * 查询高校管理列表
     */
    @PreAuthorize("@ss.hasPermi('college:college:list')")
    @GetMapping("/list")
    public TableDataInfo list(College college)
    {
        startPage();
        List<College> list = collegeService.list(college);
        return getDataTable(list);
    }

    /**
     * 导出高校管理列表

    /**
     * 获取高校管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('college:college:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(collegeService.getById(id));
    }

    /**
     * 新增高校管理
     */
    @PreAuthorize("@ss.hasPermi('college:college:add')")
    @Log(title = "高校管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody College college)
    {
        return toAjax(collegeService.save(college));
    }

    /**
     * 修改高校管理
     */
    @PreAuthorize("@ss.hasPermi('college:college:edit')")
    @Log(title = "高校管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody College college)
    {
        return toAjax(collegeService.updateById(college));
    }

    /**
     * 删除高校管理
     */
    @PreAuthorize("@ss.hasPermi('college:college:remove')")
    @Log(title = "高校管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")

    public AjaxResult remove(@PathVariable List<Long> ids)
    {
        return toAjax(collegeService.removeBatchByIds(ids));
    }
    @PreAuthorize("@ss.hasPermi('college:college:getColleges')")
    @GetMapping("/getColleges")
    public AjaxResult getColleges(){
    return success( collegeService.list());
}






}
//
