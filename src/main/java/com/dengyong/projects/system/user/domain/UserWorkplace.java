package com.dengyong.projects.system.user.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户和岗位关联 sms_user_workplace
 * 
 * @author dengyong
 */
public class UserWorkplace
{
    /** 用户ID */
    private Long userId;
    /** 工地ID */
    private Long workplaceId;

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getworkplaceId()
    {
        return workplaceId;
    }

    public void setworkplaceId(Long workplaceId)
    {
        this.workplaceId = workplaceId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("workplaceId", getworkplaceId())
            .toString();
    }
}
