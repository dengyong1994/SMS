package com.dengyong.projects.construction.attendancestatistics.controller;

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

import com.dengyong.common.utils.poi.ExcelUtil;
import com.dengyong.framework.aspectj.lang.annotation.Log;
import com.dengyong.framework.aspectj.lang.enums.BusinessType;
import com.dengyong.framework.web.controller.BaseController;
import com.dengyong.framework.web.domain.AjaxResult;
import com.dengyong.framework.web.page.TableDataInfo;
import com.dengyong.projects.construction.attendancestatistics.service.IAttendancestatisticsService;
import com.dengyong.projects.construction.workattendance.domain.Workattendance;
import com.dengyong.projects.construction.workattendance.service.IWorkattendanceService;

import com.dengyong.projects.construction.workplace.service.IWorkplaceService;
import com.dengyong.projects.monitor.operlog.domain.OperLog;
import com.dengyong.projects.system.user.service.IUserService;

/**
 * 考勤统计信息操作处理
 * 
 * @author dengyong
 */
@Controller
@RequestMapping("/construction/attendancestatistics")
public class AttendancestatisticsController extends BaseController {
	private String prefix = "construction/attendancestatistics";
	@Autowired
	IUserService userService;
	@Autowired
	IWorkplaceService workplaceService;
	@Autowired
	private IAttendancestatisticsService attendancestatisticsService;

	@RequiresPermissions("construction:attendancestatistics:view")
	@GetMapping()
	public String workplace(ModelMap mmap) {
		mmap.put("workplaces", workplaceService.selectWorkplaceAll());
		mmap.put("users", userService.selectUserAll());
		return prefix + "/attendancestatistics";
	}

	@RequiresPermissions("construction:attendancestatistics:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Workattendance workattendance) {
		startPage();
		List<Workattendance> list = attendancestatisticsService.selectWorkattendanceList(workattendance);
		return getDataTable(list);
	}
	
    @RequiresPermissions("construction:attendancestatistics:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Workattendance workattendance)
    {
		List<Workattendance> list = attendancestatisticsService.selectWorkattendanceList(workattendance);
        ExcelUtil<Workattendance> util = new ExcelUtil<Workattendance>(Workattendance.class);
        return util.exportExcel(list, "考勤统计");
    }
}
