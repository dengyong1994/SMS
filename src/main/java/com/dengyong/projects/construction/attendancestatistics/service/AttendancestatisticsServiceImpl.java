package com.dengyong.projects.construction.attendancestatistics.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dengyong.common.exception.BusinessException;
import com.dengyong.common.utils.StringUtils;
import com.dengyong.common.utils.security.ShiroUtils;
import com.dengyong.common.utils.text.Convert;
import com.dengyong.projects.construction.attendancestatistics.mapper.AttendancestatisticsMapper;
import com.dengyong.projects.construction.workattendance.domain.Workattendance;
import com.dengyong.projects.construction.workattendance.mapper.WorkattendanceMapper;
import com.dengyong.projects.construction.workplace.mapper.WorkplaceMapper;
import com.dengyong.projects.system.user.domain.UserWorkplace;
import com.dengyong.projects.system.user.mapper.UserMapper;
import com.dengyong.projects.system.user.mapper.UserWorkplaceMapper;

/**
 * 工地信息 服务层处理
 * 
 * @author dengyong
 */
@Service
public class AttendancestatisticsServiceImpl implements IAttendancestatisticsService {
	@Autowired
	private AttendancestatisticsMapper attendancestatisticsMapper;

	@Autowired
	private WorkplaceMapper workplaceMapper;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserWorkplaceMapper userWorkplaceMapper;

	/**
	 * 查询考勤信息集合
	 * 
	 * @param workattendance 考勤信息
	 * @return 考勤信息集合
	 */
	@Override
	public List<Workattendance> selectWorkattendanceList(Workattendance workattendance) {

		List<Workattendance> selectWorkplaceList = attendancestatisticsMapper.selectWorkattendanceList(workattendance);
		return selectWorkplaceList;
	}

	/**
	 * 通过工地ID查询考勤信息
	 * 
	 * @param workattendance 考勤ID
	 * @return 角色对象信息
	 */
	@Override
	public Workattendance selectWorkattendanceById(Long workattendance) {
		return attendancestatisticsMapper.selectWorkattendanceById(workattendance);
	}

}
