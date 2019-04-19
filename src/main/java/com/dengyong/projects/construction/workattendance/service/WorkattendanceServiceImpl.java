package com.dengyong.projects.construction.workattendance.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dengyong.common.exception.BusinessException;
import com.dengyong.common.utils.StringUtils;
import com.dengyong.common.utils.security.ShiroUtils;
import com.dengyong.common.utils.text.Convert;
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
public class WorkattendanceServiceImpl implements IWorkattendanceService {
	@Autowired
	private WorkattendanceMapper workattendanceMapper;

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

		List<Workattendance> selectWorkplaceList = workattendanceMapper.selectWorkattendanceList(workattendance);
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
		return workattendanceMapper.selectWorkattendanceById(workattendance);
	}

	/**
	 * 批量删除考勤信息
	 * 
	 * @param ids 需要删除的数据ID
	 * @throws Exception
	 */
	@Override
	public int deleteWorkattendanceByIds(String ids) throws BusinessException {
		Long[] workattendanceIds = Convert.toLongArray(ids);
		List<Long> workUserIds = new ArrayList<Long>();
		for (Long workattendanceId : workattendanceIds) {
			Workattendance workattendance = workattendanceMapper.selectWorkattendanceById(workattendanceId);
			Long userId = workattendance.getUserId();
			workUserIds.add(userId);
		}
		if (!workUserIds.equals(null)) {
			userWorkplaceMapper.deleteUserWorkplace(workUserIds);
		}
		return workattendanceMapper.deleteWorkattendanceByIds(workattendanceIds);

	}

	/**
	 * 新增保存考勤信息
	 * 
	 * @param workplace 考勤信息
	 * @return 结果
	 */
	@Override
	public int insertWorkattendance(Workattendance workattendance) {

		List<Workattendance> list = new ArrayList<Workattendance>();

		for (Long userId : workattendance.getUserIds()) {
			Workattendance wa = new Workattendance();
			wa.setCreateUser(ShiroUtils.getLoginName());
			wa.setUserId(userId);
			wa.setWorkHour(workattendance.getWorkHour());
			wa.setRemark(workattendance.getRemark());
			wa.setWorkplaceId(workattendance.getWorkplaceId());
			wa.setWorkplaceName(
					workplaceMapper.selectWorkplaceNameById(workattendance.getWorkplaceId()).getWorkplaceName());
			wa.setUserName(userMapper.selectUserNameById(userId).getUserName());
			wa.setWorkattendanceType(workattendance.getWorkattendanceType());
			list.add(wa);
		}
		insertUserWorkplace(workattendance);
		return workattendanceMapper.insertWorkattendance(list);

	}

	public void insertUserWorkplace(Workattendance workattendance) {
		Long workplaceId = workattendance.getWorkplaceId();
		if (StringUtils.isNotNull(workplaceId)) {
			// 新增用户与工地管理
			List<UserWorkplace> list = new ArrayList<UserWorkplace>();
			for (Long userId : workattendance.getUserIds()) {
				UserWorkplace uw = new UserWorkplace();
				uw.setUserId(userId);
				uw.setworkplaceId(workattendance.getWorkplaceId());
				list.add(uw);
			}
			if (list.size() > 0) {
				userWorkplaceMapper.batchUserWorkplace(list);
			}
		}
	}

	/**
	 * 修改保存考勤信息
	 * 
	 * @param workattendance 考勤信息
	 * @return 结果
	 */
	@Override
	public int updateWorkattendance(Workattendance workattendance) {
		workattendance.setUpdateUser(ShiroUtils.getLoginName());
		workattendance.setWorkplaceName(
				workplaceMapper.selectWorkplaceNameById(workattendance.getWorkplaceId()).getWorkplaceName());
		return workattendanceMapper.updateWorkattendance(workattendance);
	}

}
