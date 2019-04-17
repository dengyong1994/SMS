package com.dengyong.projects.construction.workattendance.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dengyong.common.constant.UserConstants;
import com.dengyong.common.exception.BusinessException;
import com.dengyong.common.utils.StringUtils;
import com.dengyong.common.utils.security.ShiroUtils;
import com.dengyong.common.utils.text.Convert;
import com.dengyong.projects.construction.workattendance.domain.Workattendance;
import com.dengyong.projects.construction.workattendance.mapper.WorkattendanceMapper;
import com.dengyong.projects.construction.workplace.domain.Workplace;
import com.dengyong.projects.construction.workplace.mapper.WorkplaceMapper;
import com.dengyong.projects.system.user.mapper.UserMapper;
import com.dengyong.projects.system.user.mapper.UserWorkplaceMapper;

/**
 * 工地信息 服务层处理
 * 
 * @author dengyong
 */
@Service
public class WorkattendanceServiceImpl implements IWorkattendanceService
{
    @Autowired
    private WorkattendanceMapper workattendanceMapper;
    
    @Autowired 
    private WorkplaceMapper workplaceMapper;
    
    @Autowired 
    private UserMapper userMapper;

    @Autowired
    private UserWorkplaceMapper userWorkplaceMapper;
    /**
     * 查询工地信息集合
     * 
     * @param Workplace 工地信息
     * @return 工地信息集合
     */
    @Override
    public List<Workattendance> selectWorkattendanceList(Workattendance workattendance)
    {
    	
    	List<Workattendance> selectWorkplaceList = workattendanceMapper.selectWorkattendanceList(workattendance);
        return selectWorkplaceList;
    }


    /**
     * 通过工地ID查询工地信息
     * 
     * @param workplaceId 工地ID
     * @return 角色对象信息
     */
    @Override
    public Workattendance selectWorkattendanceById(Long workattendance)
    {
        return workattendanceMapper.selectWorkattendanceById(workattendance);
    }

    /**
     * 批量删除工地信息
     * 
     * @param ids 需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deleteWorkplaceByIds(String ids) throws BusinessException
    {
        Long[] workattendanceIds = Convert.toLongArray(ids);
        for (Long workattendanceId : workattendanceIds)
        {
        	Workattendance workattendance = selectWorkattendanceById(workattendanceId);
            if (countUserWorkplaceById(workattendanceId) > 0)
            {
                throw new BusinessException(String.format("%1$s正在被使用,不能删除", workattendance.getWorkplaceName()));
            }
        }
        return workplaceMapper.deleteWorkplaceByIds(workattendanceIds);
    }

    /**
     * 新增保存工地信息
     * 
     * @param workplace 工地信息
     * @return 结果
     */
    @Override
    public int insertWorkplace(Workattendance workattendance)
    {
    	
    	
    	 List<Workattendance> list = new ArrayList<Workattendance>();
    	 
    	for (Long userId :  workattendance.getUserIds())
    	{
    		Workattendance  wa = new Workattendance();
    		wa.setCreateUser(ShiroUtils.getLoginName());
    		wa.setUserId(userId);
    		wa.setWorkHour(workattendance.getWorkHour());
    		wa.setRemark(workattendance.getRemark());
    		wa.setWorkplaceId(workattendance.getWorkplaceId());
    		wa.setWorkplaceName(workplaceMapper.selectWorkplaceNameById(workattendance.getWorkplaceId()).getWorkplaceName());
    		wa.setUserName(userMapper.selectUserNameById(userId).getUserName());
    		wa.setWorkattendanceType(workattendance.getWorkattendanceType());
    		list.add(wa);
    	}
   
        return  workattendanceMapper.insertWorkattendance(list);
    	
    }

    /**
     * 修改保存工地信息
     * 
     * @param workplace 工地信息
     * @return 结果
     */
    @Override
    public int updateWorkplace(Workplace workplace)
    {
    	workplace.setUpdateBy(ShiroUtils.getLoginName());
        return workplaceMapper.updateWorkplace(workplace);
    }

    /**
     * 通过工地ID查询工地使用数量
     * 
     * @param workplaceId 工地ID
     * @return 结果
     */
    @Override
    public int countUserWorkplaceById(Long workplaceId)
    {
        return userWorkplaceMapper.countUserWorkplaceById(workplaceId);
    }

    /**
     * 校验工地名称是否唯一
     * 
     * @param workplace 工地信息
     * @return 结果
     */
    @Override
    public String checkWorkplaceNameUnique(Workplace workplace)
    {
        Long workplaceId = StringUtils.isNull(workplace.getWorkplaceId()) ? -1L : workplace.getWorkplaceId();
        Workplace info = workplaceMapper.checkWorkplaceNameUnique(workplace.getWorkplaceName());
        if (StringUtils.isNotNull(info) && info.getWorkplaceId().longValue() != workplaceId.longValue())
        {
            return UserConstants.POST_NAME_NOT_UNIQUE;
        }
        return UserConstants.POST_NAME_UNIQUE;
    }

}
