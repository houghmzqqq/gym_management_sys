package com.xyz.gym_management_sys.service;

import java.util.List;

import com.xyz.gym_management_sys.vo.FieldOrderItemVO;
import com.xyz.gym_management_sys.vo.FieldOrderVO;

public interface FieldOrderService
{
	/**
	 *增加场地订单
	 *@param name fieldOrderVO 场地订单信息实例
	 *@param name List<FieldOrderItemVO> 场地订单项信息实例
	 */
	public void addFieldOrder(FieldOrderVO fieldOrderVO, List<FieldOrderItemVO> fieldOrderItemVOs);
	
	/**
	 *删除场地订单
	 *@param name fieldOrderId 场地订单编号
	 */
	public void removeFieldOrder(int fieldOrderId);
	
	/**
	 *更新场地订单
	 *@param name FieldOrderVO 场地订单信息实例
	 */
	public void updateFieldOrder(FieldOrderVO fieldOrderVO);
	
	/**
	 *根据场地订单编号查找场地订单
	 *@param name fieldOrderId 场地订单编号
	 *@return FieldOrderVO 场地订单信息实例
	 */
	public FieldOrderVO findFieldOrderById(int fieldOrderId);
	
	/**
	 *根据用户编号查找场地订单
	 *@param name userId 用户编号
	 *@return List<FieldOrderVO> 场地订单信息实例集合
	 */
	public List<FieldOrderVO> findFieldOrderByUserId(int userId);
	
	/**
	 *查找所有场地订单
	 *@return List<FieldOrderVO> 场地订单信息实例集合
	 */
	public List<FieldOrderVO> findAllFieldOrder();
}
