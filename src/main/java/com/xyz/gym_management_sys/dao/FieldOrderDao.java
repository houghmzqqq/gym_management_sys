package com.xyz.gym_management_sys.dao;

import java.util.List;

import com.xyz.gym_management_sys.po.EquOrder;
import com.xyz.gym_management_sys.po.FieldOrder;

public interface FieldOrderDao 
{
	/**
	 *增加场地订单
	 *@param name FieldOrder 场地订单实例
	 */
	public void addFieldOrder(FieldOrder fieldOrder);
	
	/**
	 *删除场地订单
	 *@param name fieldOrderId 场地订单编号
	 */
	public void deleteFieldOrder(FieldOrder fieldOrder);
	
	/**
	 *跟新场地订单
	 *@param name FieldOrder 场地订单实例
	 */
	public void updateFieldOrder(FieldOrder fieldOrder);
	
	/**
	 *合并场地订单
	 *@param name FieldOrder 场地订单实例
	 */
	public void mergeFieldOrder(FieldOrder fieldOrder);
	
	/**
	 *根据场地订单编号查找场地
	 *@param name fieldOrderId 场地订单编号
	 *@return FieldOrder 场地订单实例
	 */
	public FieldOrder getFieldOrderById(int fieldOrderId);
	
	/**
	 *根据用户编号查找场地订单
	 *@param name userId 用户编号
	 *@return List<FieldOrder> 场地订单实例集合
	 */
	public List<FieldOrder> getFieldOrderByUserId(int userId);
	
	/**
	 *查找所有场地订单
	 *@return List<FieldOrder> 场地订单实例集合
	 */
	public List<FieldOrder> getAllFieldOrder();
	
	/**
	 *获取分页中显示的场地订单
	 *@param name startRow 开始行
	 *@param name rowCount 每一页的行数
	 *@return List<FieldOrder> 场地订单实例集合
	 */
	public List<FieldOrder> getPageFieldOrder(int startRow,int rowOfEachPage);
}
