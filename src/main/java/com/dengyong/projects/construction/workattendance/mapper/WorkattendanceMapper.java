package com.dengyong.projects.construction.workattendance.mapper;

import java.util.List;

import com.dengyong.projects.construction.workattendance.domain.Workattendance;
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
    public List<Workattendance> selectWorkattendanceList(Workattendance workattendance);


    /**
     * 通过考勤ID查询工地信息
     * 
     * @param workplace 考勤ID
     * @return 考勤对象信息
     */
    public Workattendance selectWorkattendanceById(Long workattendanceId);

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
    public int insertWorkattendance(List<Workattendance> workattendanceList);

    /**
     * 校验工地名称
     * 
     * @param workplace 工地名称
     * @return 结果
     */
    public Workplace checkWorkplaceNameUnique(String workplace);

}
