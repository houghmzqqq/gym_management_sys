package com.xyz.gym_management_sys.dao;

import java.util.List;

import com.xyz.gym_management_sys.po.EquType;
import com.xyz.gym_management_sys.po.FieldType;

public interface FieldTypeDao 
{
	/**
	 *增加场地类型
	 *@param name FieldType 场地类型实例
	 */
	public void addFieldType(FieldType fieldType);
	
	/**
	 *删除场地类型
	 *@param name fieldTypeId 场地类型编号
	 */
	public void deleteFieldType(int fieldTypeId);
	
	/**
	 *通过场地类型编号查找场地类型
	 *@param name fieldTypeId 场地类型编号
	 *@return FieldType 场地类型实例
	 */
	public FieldType getFieldTypeById(int fieldTypeId);
	
	/**
	 *查找所有场地类型
	 */
	public List<FieldType> getAllFieldType();
}
