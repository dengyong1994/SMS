package com.dengyong.projects.construction.workattendance.service;

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
    public Workplace selectWorkplaceById(Long workplaceId)
    {
        return workplaceMapper.selectWorkplaceById(workplaceId);
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
        Long[] workplaceIds = Convert.toLongArray(ids);
        for (Long workplaceId : workplaceIds)
        {
        	Workplace workplace = selectWorkplaceById(workplaceId);
            if (countUserWorkplaceById(workplaceId) > 0)
            {
                throw new BusinessException(String.format("%1$s正在被使用,不能删除", workplace.getWorkplaceName()));
            }
        }
        return workplaceMapper.deleteWorkplaceByIds(workplaceIds);
    }

    /**
     * 新增保存工地信息
     * 
     * @param workplace 工地信息
     * @return 结果
     */
    @Override
    public int insertWorkplace(Workplace workplace)
    {
    	workplace.setCreateBy(ShiroUtils.getLoginName());
        return workplaceMapper.insertWorkplace(workplace);
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
