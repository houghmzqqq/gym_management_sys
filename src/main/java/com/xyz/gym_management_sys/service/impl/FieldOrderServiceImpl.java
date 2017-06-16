package com.xyz.gym_management_sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.xyz.gym_management_sys.dao.FieldDao;
import com.xyz.gym_management_sys.dao.FieldOrderDao;
import com.xyz.gym_management_sys.dao.FieldOrderItemDao;
import com.xyz.gym_management_sys.po.FieldOrder;
import com.xyz.gym_management_sys.po.FieldOrderItem;
import com.xyz.gym_management_sys.service.FieldOrderService;
import com.xyz.gym_management_sys.vo.FieldCartDetailVO;
import com.xyz.gym_management_sys.vo.FieldOrderItemVO;
import com.xyz.gym_management_sys.vo.FieldOrderVO;

@Service
public class FieldOrderServiceImpl implements FieldOrderService {

	@Resource
	private DozerBeanMapper mapper;
	@Resource
	private FieldDao fieldDao;
	@Resource
	private FieldOrderDao fieldOrderDao;
	@Resource
	private FieldOrderItemDao fieldOrderItemDao;
	
	private FieldOrder fieldOrder;
	private List<FieldOrder> fieldOrders;
	private FieldOrderVO fieldOrderVO;
	private List<FieldOrderVO> fieldOrderVOs;
	private FieldOrderItem fieldOrderItem;
	private List<FieldOrderItem> fieldOrderItems;
	
	public void addFieldOrder(FieldOrderVO fieldOrderVO, List<FieldCartDetailVO> fieldCartDetailVOs) {
		// TODO Auto-generated method stub

		fieldOrder = mapper.map(fieldOrderVO, FieldOrder.class);
		fieldOrderDao.addFieldOrder(fieldOrder);
		
		//增加订单项
		for(FieldCartDetailVO fieldCartDetailVO : fieldCartDetailVOs)
		{
			fieldOrderItem = mapper.map(fieldCartDetailVO, FieldOrderItem.class);
			fieldOrderItem.setField(fieldDao.getFieldById(fieldCartDetailVO.getFieldId()));
			fieldOrderItem.setFieldBorrowDate(fieldCartDetailVO.getFieldBorrowDate());
			fieldOrderItem.setFieldReturnDate(fieldCartDetailVO.getFieldReturnDate());
			fieldOrderItem.setFieldBorrowTime(fieldCartDetailVO.getFieldBorrowTime());
			fieldOrderItem.setFieldOrder(fieldOrder);
			
			fieldOrderItemDao.addFieldOrderItem(fieldOrderItem);
		}
	}

	public void removeFieldOrder(int fieldOrderId) {
		// TODO Auto-generated method stub

		fieldOrder = fieldOrderDao.getFieldOrderById(fieldOrderId);
		fieldOrderItems = fieldOrderItemDao.getFieldOrderItemByFieldOrderId(fieldOrderId);
		for(FieldOrderItem fieldOrderItem : fieldOrderItems)
		{
			fieldOrderItemDao.deleteFieldOrderItem(fieldOrderItem);
		}
		//fieldOrder.setUser();
		fieldOrderDao.deleteFieldOrder(fieldOrder);
	}

	public void updateFieldOrder(FieldOrderVO fieldOrderVO) {
		// TODO Auto-generated method stub

		fieldOrder = mapper.map(fieldOrderVO, FieldOrder.class);
		fieldOrderDao.updateFieldOrder(fieldOrder);
	}

	public FieldOrderVO findFieldOrderById(int fieldOrderId) {
		// TODO Auto-generated method stub
		
		fieldOrder = fieldOrderDao.getFieldOrderById(fieldOrderId);
		fieldOrderVO = mapper.map(fieldOrder, FieldOrderVO.class);
		if(fieldOrder.getUser() != null)
		{
			fieldOrderVO.setUserId(fieldOrder.getUser().getUserId());
			fieldOrderVO.setUserName(fieldOrder.getUser().getUserName());
		}
		return fieldOrderVO;
	}

	public List<FieldOrderVO> findFieldOrderByUserId(int userId) {
		// TODO Auto-generated method stub
		
		fieldOrderVOs = new ArrayList<FieldOrderVO>();
		fieldOrders = fieldOrderDao.getFieldOrderByUserId(userId);
		for(FieldOrder fieldOrder : fieldOrders)
		{
			fieldOrderVO = mapper.map(fieldOrder, FieldOrderVO.class);
			if(fieldOrder.getUser() != null)
			{
				fieldOrderVO.setUserId(fieldOrder.getUser().getUserId());
				fieldOrderVO.setUserName(fieldOrder.getUser().getUserName());
			}
			
			fieldOrderVOs.add(fieldOrderVO);
		}
		return fieldOrderVOs;
	}

	public List<FieldOrderVO> findAllFieldOrder() {
		// TODO Auto-generated method stub
		
		fieldOrderVOs = new ArrayList<FieldOrderVO>();
		fieldOrders = fieldOrderDao.getAllFieldOrder();
		for(FieldOrder fieldOrder : fieldOrders)
		{
			fieldOrderVO = mapper.map(fieldOrder, FieldOrderVO.class);
			if(fieldOrder.getUser() != null)
			{
				fieldOrderVO.setUserId(fieldOrder.getUser().getUserId());
				fieldOrderVO.setUserName(fieldOrder.getUser().getUserName());
			}
			
			fieldOrderVOs.add(fieldOrderVO);
		}
		return fieldOrderVOs;
	}

}
