package com.dengyong.projects.construction.workattendance.mapper;

import java.util.List;

import com.dengyong.projects.construction.workplace.domain.Workplace;

/**
 * 工地信息 数据层
 * 
 * @author dengyong
 */
public interface WorkattendanceMapper
{
    /**
     * 查询工地数据集合
     * 
     * @param Workplace 工地信息
     * @return 工地数据集合
     */
    public List<Workplace> selectWorkplaceList(Workplace workplace);


    /**
     * 通过工地ID查询工地信息
     * 
     * @param workplace 工地ID
     * @return 角色对象信息
     */
    public Workplace selectWorkplaceById(Long workplace);

    /**
     * 批量删除工地信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWorkplaceByIds(Long[] ids);

    /**
     * 修改工地信息
     * 
     * @param workplace 工地信息
     * @return 结果
     */
    public int updateWorkplace(Workplace workplace);

    /**
     * 新增工地信息
     * 
     * @param workplace 工地信息
     * @return 结果
     */
    public int insertWorkplace(Workplace workplace);

    /**
     * 校验工地名称
     * 
     * @param workplace 工地名称
     * @return 结果
     */
    public Workplace checkWorkplaceNameUnique(String workplace);

}
