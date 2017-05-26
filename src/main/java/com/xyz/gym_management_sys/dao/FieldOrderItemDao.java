package com.xyz.gym_management_sys.dao;

import java.util.List;

import com.xyz.gym_management_sys.po.FieldOrderItem;

public interface FieldOrderItemDao 
{
	/**
	 *增加场地订单项
	 *@param name FieldOrderItem 场地订单项实例
	 */
	public void addFieldOrderItem(FieldOrderItem fieldOrderItem);
	
	/**
	 *通过场地订单编号查找场地订单想
	 *@param name fieldOrderId 场地订单编号
	 *@return List<FieldOrderItem> 场地订单项实例集合
	 */
	public List<FieldOrderItem> getFieldOrderItemByFieldOrderId(int fieldOrderId);
}
