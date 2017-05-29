package com.xyz.gym_management_sys.service;

import java.util.List;

import com.xyz.gym_management_sys.po.Field;
import com.xyz.gym_management_sys.vo.FieldVO;

public interface FieldService 
{
	/**
	 *增加场地
	 *@param name FieldVO 场地信息实例
	 */
	public void addField(FieldVO fieldVO);
	
	/**
	 *删除场地
	 *@param name fieldId 场地编号
	 */
	public void removeField(int fieldId);
	
	/**
	 *更新场地
	 *@param name FieldVO 场地信息实例
	 */
	public void updateField(FieldVO fieldVO);
	
	/**
	 *根据场地编号查找场地
	 *@param name fieldId 场地编号
	 *@return FieldVO 场地信息实例
	 */
	public FieldVO findFieldById(int fieldId);
	
	/**
	 *根据场地类型编号查找场地
	 *@param name fieldTypeId 场地类型编号
	 *@return List<FieldVO> 场地信息实例集合
	 */
	public List<FieldVO> findFieldByFieldTypeId(int fieldTypeId);
	
	/**
	 *查找所有场地
	 *@return List<FieldVO> 场地信息实例集合
	 */
	public List<FieldVO> findAllField();
}
