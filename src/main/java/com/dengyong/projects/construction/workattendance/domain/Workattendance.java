package com.dengyong.projects.construction.workattendance.domain;

import java.util.Date;
import com.dengyong.framework.web.domain.BaseEntity;

/**
 * 考勤表 sms_Workattendance
 * 
 * @author dengyong
 */
public class Workattendance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 考勤序号 */
    private Long workattendanceId;

    /** 用户编码 */
    private Long userId;

    /** 考勤种类 */
    private String workattendanceType;

    /** 工时 */
    private Double workHour;
    
    /** 工地id */
    private Long workplaceId;
    
    //创建人员
  	private String createUser;
  	
  	//工地排序
  	private String workplaceSort;
  	
  	//更新人员
  	private String updateUser;
  	
  	//创建时间
  	private Date createTime;
  	
  	//更新时间
  	private Date updateTime;
  	
  	//备注
  	private String remark;
  	
    @Override
	public String toString() {
		return "Workattendance [workattendanceId=" + workattendanceId + ", userId=" + userId + ", workattendanceType="
				+ workattendanceType + ", workHour=" + workHour + ", workplaceId=" + workplaceId + ", createUser="
				+ createUser + ", workplaceSort=" + workplaceSort + ", updateUser=" + updateUser + ", createTime="
				+ createTime + ", updateTime=" + updateTime + ", remark=" + remark + "]";
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

	public String getWorkplaceSort() {
		return workplaceSort;
	}

	public void setWorkplaceSort(String workplaceSort) {
		this.workplaceSort = workplaceSort;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
