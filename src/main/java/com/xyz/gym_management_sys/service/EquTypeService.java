package com.xyz.gym_management_sys.service;

import java.util.List;

import com.xyz.gym_management_sys.vo.EquTypeVO;

public interface EquTypeService 
{
	/**
	 *增加器材类型
	 *@param name equType 器材类型实例
	 */
	public void addEquType(EquTypeVO equTypeVO);
	
	/**
	 *删除器材类型
	 *@param name equTypeId 器材类型编号
	 */
	public void removeEquType(int equTypeId);
	
	/**
	 *更新器材类型
	 *@param name EquType 器材类型实例
	 */
	public void updateEquType(EquTypeVO equTypeVO);
	
	/**
	 *查找器材类型
	 *@param name equTypeId 器材类型编号
	 *@return EquType
	 */
	public EquTypeVO findById(int equTypeId);
	
	/**
	 *查找所有器材类型
	 *@return List<EquType>
	 */
	public List<EquTypeVO> findAllEquType();
	
}
