package com.dengyong.projects.construction.workattendance.mapper;

import java.util.List;

import com.dengyong.projects.construction.workattendance.domain.Workattendance;

/**
 * 考勤信息 数据层
 * 
 * @author dengyong
 */
public interface WorkattendanceMapper {
	/**
	 * 查询考勤数据集合
	 * 
	 * @param workattendance 考勤信息
	 * @return 考勤数据集合
	 */
	public List<Workattendance> selectWorkattendanceList(Workattendance workattendance);

	/**
	 * 通过考勤ID查询考勤信息
	 * 
	 * @param workattendance 考勤ID
	 * @return 考勤对象信息
	 */
	public Workattendance selectWorkattendanceById(Long workattendanceId);

	/**
	 * 批量删除考勤信息
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	public int deleteWorkattendanceByIds(Long[] ids);
	
	

	/**
	 * 修改考勤信息
	 * 
	 * @param workattendance 考勤信息
	 * @return 结果
	 */
	public int updateWorkattendance(Workattendance workattendance);

	/**
	 * 新增考勤信息
	 * 
	 * @param workattendance 考勤信息
	 * @return 结果
	 */
	public int insertWorkattendance(List<Workattendance> workattendanceList);

}
