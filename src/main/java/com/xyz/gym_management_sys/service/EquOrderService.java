package com.xyz.gym_management_sys.service;

import java.util.List;

import org.springframework.web.servlet.config.VelocityConfigurerBeanDefinitionParser;

import com.xyz.gym_management_sys.vo.EquOrderVO;

public interface EquOrderService 
{
	/**
	 *增加订单
	 *@param name EquOrderVO 器材订单信息实例
	 *@param name equIds 器材编号集合
	 *@param name equCounts 器材数量集合
	 */
	public void addEquOrder(EquOrderVO equOrderVO,List<Integer> equIds,List<Integer> equCounts);
	
	/**
	 *删除器材订单
	 *@param name equOrderId 器材订单编号
	 */
	public void removeEquOrder(int equOrderId);
	
	/**
	 *更新器材订单
	 *@param name EquOrderVO 器材订单信息实例
	 */
	public void updateEquOrder(EquOrderVO equOrderVO);
	
	/**
	 *根据订单编号查找器材订单
	 *@param name equOrderId 器材订单编号
	 *@return EquOrderVO 器材订单信息实例
	 */
	public EquOrderVO findEquOrderById(int equOrderId);
	
	/**
	 *根据用户编号查找器材订单
	 *@param name userId 用户编号
	 *@return List<EquOrderVO> 器材订单信息实例集合
	 */
	public List<EquOrderVO> findEquOrderByUserId(int userId);
	
	/**
	 *分页查询器材订单信息
	 *@param name thisPage 当前页
	 *@param name rowOfEachPage 每一页行数
	 *@return List<EquipmentVO> 器材订单信息实例集合
	 */
	public List<EquOrderVO> dividePageOfEquOrder(int nextPage,int rowOfEachPage);
}
