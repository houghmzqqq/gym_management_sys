package com.xyz.gym_management_sys.dao;

import java.util.List;

import com.xyz.gym_management_sys.po.EquType;

public interface EquTypeDao
{
	/**
	 *增加器材类型
	 *@param name EquType 器材类型实例
	 */
	public void addEquType(EquType equType);
	
	/**
	 *删除器材类型
	 *@param name equType 器材类型实例
	 */
	public void deleteEquType(EquType equType);
	
	/**
	 *更新器材累心
	 *@param name EquType 器材类型实例
	 */
	public void updateEquType(EquType equType);
	
	/**
	 *通过器材类型编号查找器材类型
	 *@param name equTypeId 器材类型编号
	 *@return EquType 器材类型实例
	 */
	public EquType getEquTypeById(int equTypeId);
	
	/**
	 *查找所有器材类型
	 */
	public List<EquType> getAllEquType();
}
