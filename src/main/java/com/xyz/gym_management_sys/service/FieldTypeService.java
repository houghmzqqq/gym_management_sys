package com.xyz.gym_management_sys.service;

import java.util.List;

import org.springframework.web.servlet.config.VelocityConfigurerBeanDefinitionParser;

import com.xyz.gym_management_sys.vo.FieldTypeVO;

public interface FieldTypeService 
{
	/**
	 *增加场地类型
	 *@param name FieldTypeVO 场地类型信息实例
	 */
	public void addFieldType(FieldTypeVO fieldTypeVO);
	
	/**
	 *删除场地类型
	 *@param name fieldTypeId 场地类型编号
	 */
	public void removeFieldType(int fieldTypeId);
	
	/**
	 *更新场地类型
	 *@param name FieldTypeVO 场地类型信息实例
	 */
	public void updateFieldType(FieldTypeVO fieldTypeVO);
	
	/**
	 *根据场地类型编号查找场地类型
	 *@param name fieldTypeId 场地类型编号
	 *@return FieldTypeVO 场地类型信息实例
	 */
	public FieldTypeVO findFieldTypeById(int fieldTypeId);
	
	/**
	 *查找所有场地类型
	 *@return List<FieldTypeVO> 场地类型信息实例集合
	 */
	public List<FieldTypeVO> findAllFieldType();
}
