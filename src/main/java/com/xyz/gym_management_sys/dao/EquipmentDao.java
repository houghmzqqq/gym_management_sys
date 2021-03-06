package com.xyz.gym_management_sys.dao;

import java.util.List;

import com.xyz.gym_management_sys.po.EquType;
import com.xyz.gym_management_sys.po.Equipment;
import com.xyz.gym_management_sys.po.DividePage;

public interface EquipmentDao 
{
	/**
	 *增加器材
	 *@param name Equipment 器材实例
	 */
	public void addEquipment(Equipment equipment);
	
	/**
	 *删除器材
	 *@param name Equipment 器材实例
	 */
	public void deleteEquipment(Equipment equipment);
	
	/**
	 *更新/修改器材信息
	 *@param name equipment 器材实例
	 */
	public void updateEquipment(Equipment equipment);
	
	/**
	 *合并器材信息
	 *@param name Equipment 器材实例
	 */
	public void mergeEquipment(Equipment equipment);
	
	/**
	 *根据器材编号查找器材
	 *@param name equId 器材编号
	 *@return Equipment 器材室里
	 */
	public Equipment getEquipmentById(int equId);
	
	/**
	 *根据器材类型编号查找器材
	 *@param name EquType 器材类型实例
	 *@return List<Equipment> 器材实例集合
	 */
	public List<Equipment> getEquipmentsByEquType(EquType equType);
	
	/**
	 *获取所有器材
	 */
	public List<Equipment> getAllEquipment();
	
	/**
	 *获取分页中显示的器材
	 *@param name thisPage 开始行
	 *@param name rowOrEachPage 每一页的行数
	 *@return DividePage 分页信息实例
	 */
	public DividePage getPageEquipment(int thisPage,int rowOfEachPage);
	
	/**
	 *根据器材类型进行分页查询
	 *@param name thisPage 当前页
	 *@param name rowOfEachPage 每一页行数
	 *@param name equTypeId 器材类型编号
	 *@return DividePage 分页信息实例
	 */
	public DividePage getPageEquipmentByEquTypeId(int thisPage,int rowOfEachPage,int equTypeId);
	
}
