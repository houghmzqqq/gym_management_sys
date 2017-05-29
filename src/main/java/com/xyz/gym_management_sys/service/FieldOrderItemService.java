package com.xyz.gym_management_sys.service;

import java.util.List;

import com.xyz.gym_management_sys.vo.FieldOrderItemVO;

public interface FieldOrderItemService 
{
	/**
	 *根据场地订单编号查找场地订单项
	 *@param name fieldOrderId 场地订单编号
	 *@return FieldOrderItemVO 场地订单项信息实例
	 */
	public List<FieldOrderItemVO> findFieldOrderItemByFieldOrderId(int fieldOrderId);
	
	/**
	 *更新场地订单项
	 *@param name fieldOrderItemVO 场地订单项信息实例
	 */
	public void updateFieldOrderItem(FieldOrderItemVO fieldOrderItemVO);
}
