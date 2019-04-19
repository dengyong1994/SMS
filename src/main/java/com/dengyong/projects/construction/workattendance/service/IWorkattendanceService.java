package com.dengyong.projects.construction.workattendance.service;

import java.util.List;

import com.dengyong.projects.construction.workattendance.domain.Workattendance;

/**
 * 考勤信息 服务层
 * 
 * @author dengyong
 */
public interface IWorkattendanceService {
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

	/**
	 * 批量删除考勤信息
	 * 
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 * @throws Exception 异常
	 */
	public int deleteWorkattendanceByIds(String ids) throws Exception;

	/**
	 * 新增保存考勤信息
	 * 
	 * @param workattendance 考勤信息
	 * @return 结果
	 */
	public int insertWorkattendance(Workattendance workattendance);

	/**
	 * 修改保存考勤信息
	 * 
	 * @param workattendance 考勤信息
	 * @return 结果
	 */
	public int updateWorkattendance(Workattendance workattendance);

}
