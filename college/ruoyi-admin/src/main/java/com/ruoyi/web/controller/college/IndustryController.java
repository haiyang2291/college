package com.ruoyi.web.controller.college;

import com.ruoyi.college.domain.Industry;
import com.ruoyi.college.service.IndustryService;
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
 * 行业管理Controller
 *
 * @author 你的名字
 * @date 2025-02-27
 */
@RestController
@RequestMapping("/industry/industry")
public class IndustryController extends BaseController
{
    @Autowired
    private IndustryService industryService;

    /**
     * 查询行业管理列表
     */
    @PreAuthorize("@ss.hasPermi('industry:industry:list')")
    @GetMapping("/list")
    public TableDataInfo list(Industry industry)
    {
        startPage();
        List<Industry> list = industryService.selectIndustryList(industry);
        return getDataTable(list);
    }

    /**
     * 导出行业管理列表
     */

    /**
     * 获取行业管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('industry:industry:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(industryService.getById(id));
    }

    /**
     * 新增行业管理
     */
    @PreAuthorize("@ss.hasPermi('industry:industry:add')")
    @Log(title = "行业管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Industry industry)
    {
        return toAjax(industryService.save(industry));
    }

    /**
     * 修改行业管理
     */
    @PreAuthorize("@ss.hasPermi('industry:industry:edit')")
    @Log(title = "行业管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Industry industry)
    {
        return toAjax(industryService.updateById(industry));
    }

    /**
     * 删除行业管理
     */
    @PreAuthorize("@ss.hasPermi('industry:industry:remove')")
    @Log(title = "行业管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable List<Long> ids)
    {
        return toAjax(industryService.removeBatchByIds(ids));
    }
}
