package com.dengyong.projects.construction.workplace.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dengyong.framework.aspectj.lang.annotation.Log;
import com.dengyong.framework.aspectj.lang.enums.BusinessType;
import com.dengyong.framework.web.controller.BaseController;
import com.dengyong.framework.web.domain.AjaxResult;
import com.dengyong.framework.web.page.TableDataInfo;
import com.dengyong.projects.construction.workplace.domain.Workplace;
import com.dengyong.projects.construction.workplace.service.IWorkplaceService;

/**
 * 工地信息操作处理
 * 
 * @author dengyong
 */
@Controller
@RequestMapping("/construction/workplace")
public class WorkplaceController extends BaseController
{
    private String prefix = "construction/workplace";

    
    @Autowired
    private IWorkplaceService workplaceService;
    @RequiresPermissions("construction:workplace:view")
    @GetMapping()
    public String workplace()
    {
        return prefix + "/workplace";
    }

    @RequiresPermissions("construction:workplace:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Workplace workplace)
    {
        startPage();
        List<Workplace> list = workplaceService.selectWorkplaceList(workplace);
        return getDataTable(list);
    }

    /**
     * 删除工地
     */
    @RequiresPermissions("construction:workplace:remove")
    @Log(title = "工地管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(workplaceService.deleteWorkplaceByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     * 新增工地
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存工地
     */
    @RequiresPermissions("construction:workplace:add")
    @Log(title = "工地管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Workplace workplace)
    {
        return toAjax(workplaceService.insertWorkplace(workplace));
    }

    /**
     * 修改工地
     */
    @GetMapping("/edit/{workplaceId}")
    public String edit(@PathVariable("workplaceId") Long workplaceId, ModelMap mmap)
    {
        mmap.put("workplace", workplaceService.selectWorkplaceById(workplaceId));
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位
     */
    @RequiresPermissions("construction:workplace:edit")
    @Log(title = "工地管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Workplace workplace)
    {
        return toAjax(workplaceService.updateWorkplace(workplace));
    }

    /**
     * 校验工地名称
     */
    @PostMapping("/checkWorkplaceNameUnique")
    @ResponseBody
    public String checkWorkplaceNameUnique(Workplace workplace)
    {
        return workplaceService.checkWorkplaceNameUnique(workplace);
    }

}
