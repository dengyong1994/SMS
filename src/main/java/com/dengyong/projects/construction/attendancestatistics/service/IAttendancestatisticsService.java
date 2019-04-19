package com.dengyong.projects.construction.attendancestatistics.service;

import java.util.List;

import com.dengyong.projects.construction.workattendance.domain.Workattendance;

/**
 * 考勤信息 服务层
 * 
 * @author dengyong
 */
public interface IAttendancestatisticsService {
	/**
	 * 查询考勤信息集合
	 * 
	 * @param workplace 考勤信息
	 * @return 考勤信息集合
	 */
	public List<Workattendance> selectWorkattendanceList(Workattendance workattendance);

	/**
	 * 通过考勤ID查询考勤信息
	 * 
	 * @param workplaceId 考勤ID
	 * @return 考勤对象信息
	 */
	public Workattendance selectWorkattendanceById(Long workattendance);


}
