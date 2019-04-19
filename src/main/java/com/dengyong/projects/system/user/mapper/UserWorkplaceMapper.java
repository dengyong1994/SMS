package com.dengyong.projects.system.user.mapper;

import java.util.List;
import com.dengyong.projects.system.user.domain.UserWorkplace;


/**
 * 用户与工地 表 数据层
 * 
 * @author dengyong
 */
public interface UserWorkplaceMapper
{
    /**
     * 通过用户ID删除用户和工地关联
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public int deleteUserWorkplaceByUserId(Long userId);
    
    /**
     * 通过工地ID查询工地使用数量
     * 
     * @param workplaceId 工地ID
     * @return 结果
     */
    public int countUserWorkplaceById(Long workplaceId);
    
    /**
     * 批量删除用户和工地关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserWorkplace(List<Long> ids);

    /**
     * 批量新增用户工地信息
     * 
     * @param userWorkplaceList 用户角色列表
     * @return 结果
     */
    public int batchUserWorkplace(List<UserWorkplace> userWorkplaceList);
}
