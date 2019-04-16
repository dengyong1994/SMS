package com.dengyong.projects.construction.workattendance.controller;

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
import com.dengyong.projects.construction.workattendance.domain.Workattendance;
import com.dengyong.projects.construction.workattendance.service.IWorkattendanceService;
import com.dengyong.projects.construction.workplace.domain.Workplace;
import com.dengyong.projects.construction.workplace.service.IWorkplaceService;

/**
 * 工地信息操作处理
 * 
 * @author dengyong
 */
@Controller
@RequestMapping("/construction/workattendance")
public class WorkattendanceController extends BaseController
{
    private String prefix = "construction/workattendance";

    
    @Autowired
    private IWorkattendanceService workattendanceService;
    @RequiresPermissions("construction:workattendance:view")
    @GetMapping()
    public String workplace()
    {
        return prefix + "/workattendance";
    }

    @RequiresPermissions("construction:workattendance:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Workattendance workattendance)
    {
        startPage();
        List<Workattendance> list = workattendanceService.selectWorkattendanceList(workattendance);
        return getDataTable(list);
    }

    /**
     * 删除工地
     */
    @RequiresPermissions("construction:workattendance:remove")
    @Log(title = "工地管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(workattendanceService.deleteWorkplaceByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     * 新增工地
     */
    @GetMapping("/workattendance")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存工地
     */
    @RequiresPermissions("construction:workattendance:add")
    @Log(title = "工地管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Workplace workplace)
    {
        return toAjax(workattendanceService.insertWorkplace(workplace));
    }

    /**
     * 修改工地
     */
    @GetMapping("/edit/{workattendanceId}")
    public String edit(@PathVariable("workattendanceId") Long workplaceId, ModelMap mmap)
    {
        mmap.put("workattendance", workattendanceService.selectWorkplaceById(workplaceId));
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位
     */
    @RequiresPermissions("construction:workattendance:edit")
    @Log(title = "工地管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Workplace workplace)
    {
        return toAjax(workattendanceService.updateWorkplace(workplace));
    }

    /**
     * 校验工地名称
     */
    @PostMapping("/checkWorkplaceNameUnique")
    @ResponseBody
    public String checkWorkplaceNameUnique(Workplace workplace)
    {
        return workattendanceService.checkWorkplaceNameUnique(workplace);
    }

}
