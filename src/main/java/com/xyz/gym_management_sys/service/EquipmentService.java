package com.xyz.gym_management_sys.service;

import java.util.List;

import com.xyz.gym_management_sys.po.Equipment;
import com.xyz.gym_management_sys.vo.EquipmentVO;

public interface EquipmentService 
{
	/**
	 *分页查询器材信息
	 *@param name thisPage 当前页
	 *@param name rowOfEachPage 每一页行数
	 *@return List<EquipmentVO> 器材信息实例集合
	 */
	public List<EquipmentVO> dividePageOfEqu(int nextPage,int rowOfEachPage);
	
	/**
	 *查找所有器材
	 */
	public List<EquipmentVO> findAllEqu();
	
	/**
	 *通过器材类型编号查询器材
	 *@param name equTypeId 器材类型编号
	 *@return List<EquipmentVO> 器材信息实例集合
	 */
	public List<EquipmentVO> findEquByEquTypeId(int equTypeId);
	
	/**
	 *通过器材编号查找器材
	 *@param name equId 器材编号
	 *@return EquipmentVO 器材信息实例
	 */
	public EquipmentVO findEquById(int equId);
	
	/**
	 *增加器材
	 *@param name EquipmentVO 器材信息实例
	 */
	public  void addEqu(EquipmentVO equipmentVO);
	
	/**
	 *删除器材
	 *@param name equId 器材编号
	 */
	public void removeEqu(int equId);
	
	/**
	 *更新器材信息
	 *@param name EquipmentVO 器材信息实例
	 */
	public void updateEqu(EquipmentVO equipmentVO);
}
