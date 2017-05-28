package com.xyz.gym_management_sys.service;

import java.util.List;

import org.hibernate.validator.internal.engine.ValidatorContextImpl;

import com.xyz.gym_management_sys.vo.EquOrderItemVO;
import com.xyz.gym_management_sys.vo.EquOrderVO;

public interface EquOrderItemService 
{
	/**
	 *通过器材订单编号查找器材订单项
	 *@param name equOrderId 器材订单编号
	 *@return List<EquOrderItemVO> 器材订单项信息实例集合
	 */
	public List<EquOrderItemVO> findEquOrderItemByEquOrderId(int equOrderId);
	
	/**
	 *更新器材订单项
	 *@param name EquOrderItemVO 器材订单项实例
	 */
	public void updateEquOrderItem(EquOrderItemVO equOrderItemVO);
}
