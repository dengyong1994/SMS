package com.dengyong.projects.construction.workplace.service;

import java.util.List;

import com.dengyong.projects.construction.workplace.domain.Workplace;
import com.dengyong.projects.system.post.domain.Post;


/**
 * 工地信息 服务层
 * 
 * @author dengyong
 */
public interface IWorkplaceService
{
    /**
     * 查询工地信息集合
     * 
     * @param workplace 工地信息
     * @return 工地信息集合
     */
    public List<Workplace> selectWorkplaceList(Workplace workplace);


    /**
     * 通过工地ID查询岗位信息
     * 
     * @param workplaceId 工地ID
     * @return 角色对象信息
     */
    public Workplace selectWorkplaceById(Long workplaceId);
    /**
    * 查询所有工地
    * 
    * @return 工地列表
    */
   public List<Workplace> selectWorkplaceAll();
    /**
     * 批量删除工地信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteWorkplaceByIds(String ids) throws Exception;

    /**
     * 新增保存工地信息
     * 
     * @param workplace 工地信息
     * @return 结果
     */
    public int insertWorkplace(Workplace workplace);

    /**
     * 修改保存工地信息
     * 
     * @param workplace 工地信息
     * @return 结果
     */
    public int updateWorkplace(Workplace workplace);

    /**
     * 通过工地ID查询工地使用数量
     * 
     * @param workplaceId 工地ID
     * @return 结果
     */
    public int countUserWorkplaceById(Long workplaceId);

    /**
     * 校验工地名称
     * 
     * @param workplace 工地信息
     * @return 结果
     */
    public String checkWorkplaceNameUnique(Workplace workplace);
}
