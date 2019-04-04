package com.dengyong.projects.construction.workplace.domain;

import java.util.Date;

import com.dengyong.framework.web.domain.BaseEntity;

/**
 * 
* <p>Title: Workplace</p>  
* <p>Description: 工地信息sms_Workplace</p>  
* @author dengyong  
* @date 2019年4月4日  
* @version 1.0.0
 */
public class Workplace extends BaseEntity{
	private static final long serialVersionUID = 1L;
	//工地id
	private Long workplaceId;
	
	//工地名称
	private String workplaceName;
	
	//工地地点
	private String workplacePlace;
	
	//工地状态1启用 0停用
	private String workplaceStatus;
	
	//删除标志1未删除0删除
	private String workplaceFlag;
	
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
		return "Workplace [workplaceId=" + workplaceId + ", workplaceName=" + workplaceName + ", workplacePlace="
				+ workplacePlace + ", workplaceStatus=" + workplaceStatus + ", workplaceFlag=" + workplaceFlag
				+ ", createUser=" + createUser + ", updateUser=" + updateUser + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", remark=" + remark + "]";
	}

	public String getWorkplaceSort() {
		return workplaceSort;
	}

	public void setWorkplaceSort(String workplaceSort) {
		this.workplaceSort = workplaceSort;
	}
	
	public Long getWorkplaceId() {
		return workplaceId;
	}

	public void setWorkplaceId(Long workplaceId) {
		this.workplaceId = workplaceId;
	}

	public String getWorkplaceName() {
		return workplaceName;
	}

	public void setWorkplaceName(String workplaceName) {
		this.workplaceName = workplaceName;
	}

	public String getWorkplacePlace() {
		return workplacePlace;
	}

	public void setWorkplacePlace(String workplacePlace) {
		this.workplacePlace = workplacePlace;
	}

	public String getWorkplaceStatus() {
		return workplaceStatus;
	}

	public void setWorkplaceStatus(String workplaceStatus) {
		this.workplaceStatus = workplaceStatus;
	}

	public String getWorkplaceFlag() {
		return workplaceFlag;
	}

	public void setWorkplaceFlag(String workplaceFlag) {
		this.workplaceFlag = workplaceFlag;
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
