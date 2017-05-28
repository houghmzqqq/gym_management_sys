package com.xyz.gym_management_sys.dao;

import java.util.List;

import com.xyz.gym_management_sys.po.EquOrder;

public interface EquOrderDao 
{
	/**
	 *增加器材订单
	 *@param name EquOrder 器材订单实例
	 */
	public void addEquOrder(EquOrder equOrder);
	
	/**
	 *删除器材订单
	 *@param name equOrderId 器材订单编号
	 */
	public void deleteEquOrder(int equOrderId);
	
	/**
	 *根据器材订单编号查找器材
	 *@param name equOrderId 器材订单编号
	 *@return EquOrder 器材订单实例
	 */
	public EquOrder getEquOrderById(int equOrderId);
	
	/**
	 *根据用户编号查找器材订单
	 *@param name userId 用户编号
	 *@return List<EquOrder> 器材订单实例集合
	 */
	public List<EquOrder> getEquOrderByUserId(int userId);
	
	/**
	 *获取分页中显示的器材订单
	 *@param name startRow 开始行
	 *@param name rowCount 每一页的行数
	 *@return List<EquOrder> 器材订单实例集合
	 */
	public List<EquOrder> getPageEquOrder(int startRow,int rowCount);
	
}
