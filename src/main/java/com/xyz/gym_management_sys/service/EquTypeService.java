package com.xyz.gym_management_sys.service;

import java.util.List;

import com.xyz.gym_management_sys.po.EquType;

public interface EquTypeService 
{
	/**
	 *增加器材类型
	 */
	public void addEquType();
	
	/**
	 *删除器材类型
	 */
	public void removeEquType(int equTypeId);
	
	/**
	 *查找器材类型
	 *@param name equTypeId 器材类型编号
	 *@return EquType
	 */
	public EquType findById(int equTypeId);
	
	/**
	 *查找所有器材类型
	 *@return List<EquType>
	 */
	public List<EquType> findAllEquType();
}
