package com.dengyong.projects.construction.workattendance.domain;

import java.util.Date;
import com.dengyong.framework.web.domain.BaseEntity;
import com.dengyong.projects.construction.workplace.domain.Workplace;
import com.dengyong.projects.system.dept.domain.Dept;
import com.dengyong.projects.system.user.domain.User;

/**
 * 考勤表 sms_Workattendance
 * 
 * @author dengyong
 */
public class Workattendance extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 考勤序号 */
	private Long workattendanceId;

	/** 用户编码 */
	private Long userId;

	/** 考勤种类 */
	private String workattendanceType;

	/** 工时 */
	private Double workHour;
	
	/** 用户组 */
    private Long[] userIds;
    
	public Long[] getUserIds() {
		return userIds;
	}

	public void setUserIds(Long[] userIds) {
		this.userIds = userIds;
	}

	/** 工地id */
	private Long workplaceId;
	// 工地名称
	private String workplaceName;
	// 用户姓名
	private String userName;

	public String getWorkplaceName() {
		return workplaceName;
	}

	public void setWorkplaceName(String workplaceName) {
		this.workplaceName = workplaceName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	// 创建人员
	private String createUser;


	// 更新人员
	private String updateUser;

	// 创建时间
	private Date createDate;

	// 更新时间
	private Date updateTime;

	// 备注
	private String remark;

	// 用户
	private User user;

	// 工地
	private Workplace workplace;

	@Override
	public String toString() {
		return "Workattendance [workattendanceId=" + workattendanceId + ", userId=" + userId + ", workattendanceType="
				+ workattendanceType + ", workHour=" + workHour + ", workplaceId=" + workplaceId + ", workplaceName="
				+ workplaceName + ", userName=" + userName + ", createUser=" + createUser + ", workplaceSort="
				 + ", updateUser=" + updateUser + ", createTime=" + createDate + ", updateTime="
				+ updateTime + ", remark=" + remark + ", user=" + user + ", workplace=" + workplace + "]";
	}

	public Workplace getWorkplace() {
		return workplace;
	}

	public void setWorkplace(Workplace workplace) {
		this.workplace = workplace;
	}

	public User getUser() {
		if (user == null) {
			user = new User();
		}
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getWorkattendanceId() {
		return workattendanceId;
	}

	public void setWorkattendanceId(Long workattendanceId) {
		this.workattendanceId = workattendanceId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getWorkattendanceType() {
		return workattendanceType;
	}

	public void setWorkattendanceType(String workattendanceType) {
		this.workattendanceType = workattendanceType;
	}

	public Double getWorkHour() {
		return workHour;
	}

	public void setWorkHour(Double workHour) {
		this.workHour = workHour;
	}

	public Long getWorkplaceId() {
		return workplaceId;
	}

	public void setWorkplaceId(Long workplaceId) {
		this.workplaceId = workplaceId;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
