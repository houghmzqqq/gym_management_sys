package com.xyz.gym_management_sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.springframework.messaging.simp.user.UserDestinationMessageHandler;
import org.springframework.stereotype.Service;

import com.xyz.gym_management_sys.dao.EquOrderDao;
import com.xyz.gym_management_sys.dao.EquOrderItemDao;
import com.xyz.gym_management_sys.po.EquOrder;
import com.xyz.gym_management_sys.po.EquOrderItem;
import com.xyz.gym_management_sys.service.EquOrderItemService;
import com.xyz.gym_management_sys.vo.EquOrderItemVO;
import com.xyz.gym_management_sys.vo.EquOrderVO;

@Service 
public class EquOrderItemServiceImpl implements EquOrderItemService {

	@Resource
	private EquOrderItemDao equOrderItemDao;
	@Resource
	private EquOrderDao equOrderDao;
	@Resource
	private DozerBeanMapper mapper;
	
	private EquOrderItem equOrderItem;
	private List<EquOrderItem> equOrderItems;
	private EquOrderItemVO equOrderItemVO;
	private List<EquOrderItemVO> equOrderItemVOs;
	
	public List<EquOrderItemVO> findEquOrderItemByEquOrderId(int equOrderId) {
		// TODO Auto-generated method stub
		
		equOrderItemVOs = new ArrayList<EquOrderItemVO>();
		EquOrder equOrder = equOrderDao.getEquOrderById(equOrderId);
		equOrderItems = equOrderItemDao.getEquOrderItemByEquOrder(equOrder);
		
		for(EquOrderItem equOrderItem : equOrderItems)
		{
			equOrderItemVO = mapper.map(equOrderItem, EquOrderItemVO.class);
			equOrderItemVO.setEquOrderId(equOrderItem.getEquOrder().getEquOrderId());
			if(equOrderItem.getEquipment() != null)
			{
				equOrderItemVO.setEquId(equOrderItem.getEquipment().getEquId());
				equOrderItemVO.setEquName(equOrderItem.getEquipment().getEquName());
			}
			
			equOrderItemVOs.add(equOrderItemVO);
		}
		
		return equOrderItemVOs;
	}

	public void updateEquOrderItem(EquOrderItemVO equOrderItemVO) {
		// TODO Auto-generated method stub
		
		equOrderItem = mapper.map(equOrderItemVO, EquOrderItem.class);
		equOrderItemDao.updateEquOrderItem(equOrderItem);
	}

}
