package com.xyz.gym_management_sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.xyz.gym_management_sys.dao.EquOrderDao;
import com.xyz.gym_management_sys.dao.EquOrderItemDao;
import com.xyz.gym_management_sys.dao.EquipmentDao;
import com.xyz.gym_management_sys.po.EquOrder;
import com.xyz.gym_management_sys.po.EquOrderItem;
import com.xyz.gym_management_sys.po.Equipment;
import com.xyz.gym_management_sys.service.EquOrderService;
import com.xyz.gym_management_sys.vo.EquCartDetailVO;
import com.xyz.gym_management_sys.vo.EquOrderVO;

@Service
public class EquOrderServiceImpl implements EquOrderService {

	@Resource
	private EquOrderDao equOrderDao;
	@Resource
	private EquOrderItemDao equOrderItemDao;
	@Resource
	private EquipmentDao equipmentDao;
//	@Resource
//	private UserDao userDao;
	@Resource
	private DozerBeanMapper mapper;
	
	
	private EquOrder equOrder;
	private List<EquOrder> equOrders;
	private EquOrderItem equOrderItem;
	private List<EquOrderItem> equOrderItems;
	private EquOrderVO equOrderVO;
	private List<EquOrderVO> equOrderVOs;
	private Equipment equipment;
	
	public void addEquOrder(EquOrderVO equOrderVO, List<EquCartDetailVO> equCartDetailVOs) {
		// TODO Auto-generated method stub
		
		equOrder = mapper.map(equOrderVO, EquOrder.class);
//		equOrder.setUser(userDao.getUserById(equOrderVO.getUserId()));//查找用户，需要UserDao支持
		equOrderDao.addEquOrder(equOrder);
		
		//生成订单项
		for(EquCartDetailVO equCartDetailVO : equCartDetailVOs)
		{
			equipment = equipmentDao.getEquipmentById(equCartDetailVO.getEquId());
			equOrderItem = new EquOrderItem();
			equOrderItem.setEquOrder(equOrder);
			equOrderItem.setEquipment(equipment);
			equOrderItem.setEquBreakCount(0);
			equOrderItem.setEquCount(equCartDetailVO.getEquCount());
			equOrderItem.setEquCompensation(0);
			
			equOrderItemDao.addEquOrderItem(equOrderItem);
		}
		
	}

	public void removeEquOrder(int equOrderId) {
		// TODO Auto-generated method stub
		
		equOrder = equOrderDao.getEquOrderById(equOrderId);
		equOrderItems = equOrderItemDao.getEquOrderItemByEquOrder(equOrder);
		for(EquOrderItem equOrderItem : equOrderItems)
		{
			equOrderItemDao.deleteEquOrderItem(equOrderItem);
		}
		equOrderDao.deleteEquOrder(equOrder);
		/*此处应该有一个修改matchOrderItem中equ_order_id外键的功能，需要matchOrderItemDao支持 */
		
	}

	public void updateEquOrder(EquOrderVO equOrderVO) {
		// TODO Auto-generated method stub
		
		equOrder = mapper.map(equOrderVO, EquOrder.class);
//		equOrder.setUser(userDao.getUserById(equOrderVO.getUserId()));//查找用户，需要UserDao支持
		equOrderDao.updateEquOrder(equOrder);
	}

	public EquOrderVO findEquOrderById(int equOrderId) {
		// TODO Auto-generated method stub
		
		equOrder = equOrderDao.getEquOrderById(equOrderId);
		equOrderVO = mapper.map(equOrder, EquOrderVO.class);
		if(equOrder.getUser() != null)
		{
			equOrderVO.setUserId(equOrder.getUser().getUserId());
			equOrderVO.setUserName(equOrder.getUser().getUserName());
		}
		
		return equOrderVO;
	}

	public List<EquOrderVO> findEquOrderByUserId(int userId) {
		// TODO Auto-generated method stub
		
		equOrderVOs = new ArrayList<EquOrderVO>();
		equOrders = equOrderDao.getEquOrderByUserId(userId);
		for(EquOrder equOrder : equOrders)
		{
			equOrderVO = mapper.map(equOrder, EquOrderVO.class);
			if(equOrder.getUser() != null)
			{
				equOrderVO.setUserId(equOrder.getUser().getUserId());
				equOrderVO.setUserName(equOrder.getUser().getUserName());
			}
			
			equOrderVOs.add(equOrderVO);
		}
		return equOrderVOs;
	}

	public List<EquOrderVO> dividePageOfEquOrder(int nextPage, int rowOfEachPage) {
		// TODO Auto-generated method stub
		
		equOrderVOs = new ArrayList<EquOrderVO>();
		equOrders = equOrderDao.getPageEquOrder((nextPage*rowOfEachPage), rowOfEachPage);
		for(EquOrder equOrder : equOrders)
		{
			equOrderVO = mapper.map(equOrder, EquOrderVO.class);
			if(equOrder.getUser() != null)
			{
				equOrderVO.setUserId(equOrder.getUser().getUserId());
				equOrderVO.setUserName(equOrder.getUser().getUserName());
			}
			
			equOrderVOs.add(equOrderVO);
		}
		
		return equOrderVOs;
	}

}
