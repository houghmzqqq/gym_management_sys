package com.xyz.gym_management_sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.xyz.gym_management_sys.dao.FieldDao;
import com.xyz.gym_management_sys.dao.FieldOrderDao;
import com.xyz.gym_management_sys.dao.FieldOrderItemDao;
import com.xyz.gym_management_sys.po.FieldOrderItem;
import com.xyz.gym_management_sys.service.FieldOrderItemService;
import com.xyz.gym_management_sys.vo.FieldOrderItemVO;

@Service
public class FieldOrderItemServiceImpl implements FieldOrderItemService {

	@Resource
	private FieldOrderDao fieldOrderDao;
	@Resource
	private FieldOrderItemDao fieldOrderItemDao;
	@Resource
	private FieldDao fieldDao;
	@Resource
	private DozerBeanMapper mapper;
	
	private FieldOrderItem fieldOrderItem;
	private List<FieldOrderItem> fieldOrderItems;
	private FieldOrderItemVO fieldOrderItemVO;
	private List<FieldOrderItemVO> fieldOrderItemVOs;
	
	public List<FieldOrderItemVO> findFieldOrderItemByFieldOrderId(int fieldOrderId) {
		// TODO Auto-generated method stub
		
		fieldOrderItemVOs = new ArrayList<FieldOrderItemVO>();
		fieldOrderItems = fieldOrderItemDao.getFieldOrderItemByFieldOrderId(fieldOrderId);
		for(FieldOrderItem fieldOrderItem : fieldOrderItems)
		{
			fieldOrderItemVO = mapper.map(fieldOrderItem, FieldOrderItemVO.class);
			if(fieldOrderItem.getField() != null)
			{
				fieldOrderItemVO.setFieldId(fieldOrderItem.getField().getFieldId());
				fieldOrderItemVO.setFieldName(fieldOrderItem.getField().getFieldName());
				//设置场地订单项的租金
				fieldOrderItemVO.setItemSum(fieldOrderItem.getFieldBorrowTime()*
						fieldOrderItem.getField().getFieldBorrowUnitvalent());
			}
			
			fieldOrderItemVOs.add(fieldOrderItemVO);
		}
		
		return fieldOrderItemVOs;
	}

	public void updateFieldOrderItem(FieldOrderItemVO fieldOrderItemVO) {
		// TODO Auto-generated method stub
		
		fieldOrderItem = mapper.map(fieldOrderItemVO, FieldOrderItem.class);
		fieldOrderItem.setFieldOrder(fieldOrderDao.getFieldOrderById(fieldOrderItemVO.getFieldOrderId()));
		if(fieldOrderItemVO.getFieldId() != 0)
		{
			fieldOrderItem.setField(fieldDao.getFieldById(fieldOrderItemVO.getFieldId()));
		}
		fieldOrderItemDao.updateFieldOrderItem(fieldOrderItem);
	}

}
