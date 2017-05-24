package com.xyz.gym_management_sys.dao;

import java.util.List;

import com.xyz.gym_management_sys.po.Equipment;

public interface EquipmentDao 
{
		/**
		 *增加器材
		 *@param name Equipment 器材实例
		 */
		public void addEquipment(Equipment equipment);
		
		/**
		 *删除器材
		 *@param name equId 器材编号
		 */
		public void deleteEquipment(int equId);
		
		/**
		 *更新/修改器材信息
		 *@param name equipment 器材实例
		 */
		public void updateEquipment(Equipment equipment);
		
		/**
		 *根据器材编号查找器材
		 *@param name equId 器材编号
		 *@return Equipment 器材室里
		 */
		public Equipment getEquipmentById(int equId);
		
		/**
		 *根据器材类型编号查找器材
		 *@param name equTypeId 器材类型编号
		 *@return List<Equipment> 器材实例集合
		 */
		public List<Equipment> getEquipmentsByEquTypeId(int equTypeId);
		

}
