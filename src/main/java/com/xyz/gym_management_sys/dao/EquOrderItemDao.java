package com.xyz.gym_management_sys.dao;

import java.util.List;

import com.xyz.gym_management_sys.po.EquOrderItem;
import com.xyz.gym_management_sys.po.Equipment;

public interface EquOrderItemDao 
{
	/**
	 *增加器材订单项
	 *@param name EquOrderItem 器材订单项实例
	 */
	public void addEquOrderItem(EquOrderItem equOrderItem);
	
	/**
	 *通过器材订单编号查找器材订单想
	 *@param name equOrderId 器材订单编号
	 *@return List<EquOrderItem> 器材订单项实例集合
	 */
	public List<EquOrderItem> getEquOrderItemByEquOrderId(int equOrderId);
	
	/**
	 *通过器材查询器材订单项
	 *@param name Equipment 器材实例
	 *@return List<EquOrderItem> 器材订单项实例集合
	 */
	public List<EquOrderItem> getEquOrderItemByEqu(Equipment equipment);
	
	/**
	 *合并器材订单项
	 *@param name EquOrderItem 器材订单项实例
	 */
	public void mergeEquOrderItem(EquOrderItem equOrderItem);
	
	/**
	 *更新器材订单项
	 *@param name EquOrderItem 器材订单项实例
	 */
	public void updateEquOrderItem(EquOrderItem equOrderItem);
}
