package com.xyz.gym_management_sys.dao;

import java.util.List;

import com.xyz.gym_management_sys.po.Equipment;
import com.xyz.gym_management_sys.po.Field;

public interface FieldDao 
{
	/**
	 *增加场地
	 *@param name Field 场地实例
	 */
	public void addField(Field field);
	
	/**
	 *删除场地
	 *@param name fieldId 场地编号
	 */
	public void deleteField(Field field);
	
	/**
	 *更新/修改场地信息
	 *@param name Field 场地实例
	 */
	public void updateField(Field field);
	
	/**
	 *合并场地
	 *@param name Field 场地实例
	 */
	public void mergeField(Field field);
	
	/**
	 *根据场地编号查找场地
	 *@param name fieldId 场地编号
	 *@return Field 场地实例
	 */
	public Field getFieldById(int fieldId);
	
	/**
	 *根据场地类型编号查找场地
	 *@param name fieldTypeId 场地类型编号
	 *@return List<Field> 场地实例集合
	 */
	public List<Field> getFieldsByEquTypeId(int fieldTypeId);
	
	/**
	 *获取所有场地
	 */
	public List<Field> getAllField();
	
	/**
	 *获取分页中显示的场地
	 *@param name startRow 开始行
	 *@param name rowOrEachPage 每一页的行数
	 *@return List<Field> 场地实例集合
	 */
	public List<Field> getPageField(int startRow,int rowOfEachPage);
}
