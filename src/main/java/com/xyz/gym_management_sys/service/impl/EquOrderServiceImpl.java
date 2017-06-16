package com.xyz.gym_management_sys.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.xyz.gym_management_sys.dao.EquOrderDao;
import com.xyz.gym_management_sys.dao.EquOrderItemDao;
import com.xyz.gym_management_sys.dao.EquipmentDao;
import com.xyz.gym_management_sys.dao.UserDao;
import com.xyz.gym_management_sys.po.DividePage;
import com.xyz.gym_management_sys.po.EquOrder;
import com.xyz.gym_management_sys.po.EquOrderItem;
import com.xyz.gym_management_sys.po.Equipment;
import com.xyz.gym_management_sys.service.EquOrderService;
import com.xyz.gym_management_sys.vo.DividePageVO;
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
	@Resource
	private UserDao userDao;
	@Resource
	private DozerBeanMapper mapper;
	
	
	private EquOrder equOrder;
	private List<EquOrder> equOrders;
	private EquOrderItem equOrderItem;
	private List<EquOrderItem> equOrderItems;
	private EquOrderVO equOrderVO;
	private List<EquOrderVO> equOrderVOs;
	private Equipment equipment;
	private DividePage dividePage;
	private DividePageVO dividePageVO;
	
	public void addEquOrder(List<EquCartDetailVO> equCartDetailVOs,int userId) {
		// TODO Auto-generated method stub
		
		equOrderItems = new ArrayList<EquOrderItem>();
		float allSum = 0, allDeposit = 0;
		equOrder = new EquOrder();
		
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
			equOrderItems.add(equOrderItem);
			
			allSum += equipment.getEquBorrowUnitvaluent() * equCartDetailVO.getEquCount();
			allDeposit += equipment.getEquDeposit() * equCartDetailVO.getEquCount();
			
		}
		
		//生成订单
		equOrder.setUser(userDao.findUserById(userId));
		System.out.println(equOrder.getUser());
		equOrder.setEquOrderDate(new Timestamp(System.currentTimeMillis()));
		equOrder.setEquOrderStatement(0);
		equOrder.setEquOrderSum(allSum);
		equOrder.setEquTotalDeposit(allDeposit);
		equOrderDao.addEquOrder(equOrder);
		
		//保存订单项
		for(EquOrderItem equOrderItem : equOrderItems)
		{
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
		if(equOrder.getEquOrderStatement() == 2)
		{
			equOrder.setEquBorrowDate(new Timestamp(System.currentTimeMillis()));
		}
		else if(equOrder.getEquOrderStatement() == 3)
		{
			equOrder.setEquReturnDate(new Timestamp(System.currentTimeMillis()));
		}
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

	public DividePageVO dividePageOfEquOrder(int thisPage, int rowOfEachPage) {
		// TODO Auto-generated method stub
		
		DividePage dividePage = equOrderDao.getPageEquOrder(thisPage, rowOfEachPage);
		equOrders = dividePage.getEquOrders();
		DividePageVO dividePageVO = mapper.map(dividePage, DividePageVO.class);
		
		for(EquOrder equOrder : equOrders)
		{
			float compensation = 0, sum = 0, deposit = 0;
			equOrderVO = mapper.map(equOrder, EquOrderVO.class);
			if(equOrder.getUser() != null)
			{
				equOrderVO.setUserId(equOrder.getUser().getUserId());
				equOrderVO.setUserName(equOrder.getUser().getUserName());
			}
			
			equOrderItems = equOrderItemDao.getEquOrderItemByEquOrderId(equOrder.getEquOrderId());
			for(EquOrderItem equOrderItem : equOrderItems)
			{
				compensation += equOrderItem.getEquCompensation();
				sum += equOrderItem.getEquipment().getEquBorrowUnitvaluent()*equOrderItem.getEquCount();
				deposit += equOrderItem.getEquipment().getEquDeposit()*equOrderItem.getEquCount();
			}
			equOrderVO.setEquTotalCompensation(compensation);
			equOrderVO.setEquOrderSum(sum);
			equOrderVO.setEquTotalDeposit(deposit);
			
			dividePageVO.getEquOrderVOs().add(equOrderVO);
		}
		return dividePageVO;
	}

	public void mergeEquOrder(EquOrderVO equOrderVO) {
		// TODO Auto-generated method stub
		
		equOrder = mapper.map(equOrderVO, EquOrder.class);
//		equOrder.setUser(userDao.getUserById());
		equOrderDao.mergeEquOrder(equOrder);
	}

}
