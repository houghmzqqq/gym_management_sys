package com.xyz.gym_management_sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Service;

import com.xyz.gym_management_sys.dao.FieldDao;
import com.xyz.gym_management_sys.dao.FieldOrderItemDao;
import com.xyz.gym_management_sys.dao.FieldTypeDao;
import com.xyz.gym_management_sys.po.Field;
import com.xyz.gym_management_sys.po.FieldOrderItem;
import com.xyz.gym_management_sys.service.FieldService;
import com.xyz.gym_management_sys.vo.FieldVO;

@Service
public class FieldServiceImpl implements FieldService {

	@Resource
	private FieldTypeDao fieldTypeDao;
	@Resource
	private FieldDao fieldDao;
	@Resource
	private FieldOrderItemDao fieldOrderItemDao;
	@Resource
	private DozerBeanMapper mapper;
	
	private Field field;
	private List<Field> fields;
	private FieldVO fieldVO;
	private List<FieldVO> fieldVOs;
	
	public void addField(FieldVO fieldVO) {
		// TODO Auto-generated method stub

		field = mapper.map(fieldVO, Field.class);
		field.setFieldType(fieldTypeDao.getFieldTypeById(fieldVO.getFieldTypeId()));
		fieldDao.addField(field);
	}

	public void removeField(int fieldId) {
		// TODO Auto-generated method stub

		field = fieldDao.getFieldById(fieldId);
		List<FieldOrderItem> fieldOrderItems = fieldOrderItemDao.getFieldOrderItemByFieldId(fieldId);
		//将所有与该  场地  关联的  场地订单项  的  fieldId 属性设置为null
		for(FieldOrderItem fieldOrderItem : fieldOrderItems)
		{
			fieldOrderItem.setField(null);
			fieldOrderItemDao.mergeFieldOrderItem(fieldOrderItem);
		}
		
		fieldDao.deleteField(field);
	}

	public void updateField(FieldVO fieldVO) {
		// TODO Auto-generated method stub

		field = mapper.map(fieldVO, Field.class);
		field.setFieldType(fieldTypeDao.getFieldTypeById(fieldVO.getFieldTypeId()));
		fieldDao.updateField(field);
	}

	public FieldVO findFieldById(int fieldId) {
		// TODO Auto-generated method stub
		
		field = fieldDao.getFieldById(fieldId);
		fieldVO = mapper.map(field, FieldVO.class);
		if(field.getFieldType() != null)
		{
			fieldVO.setFieldTypeName(field.getFieldType().getFieldTypeName());
			fieldVO.setFieldTypeId(field.getFieldType().getFieldTypeId());
		}
		return fieldVO;
	}

	public List<FieldVO> findFieldByFieldTypeId(int fieldTypeId) {
		// TODO Auto-generated method stub
		
		fieldVOs = new ArrayList<FieldVO>();
		fields = fieldDao.getFieldsByEquTypeId(fieldTypeId);
		for(Field field : fields)
		{
			fieldVO = mapper.map(field, FieldVO.class);	
			if(field.getFieldType() != null)
			{
				fieldVO.setFieldTypeName(field.getFieldType().getFieldTypeName());
				fieldVO.setFieldTypeId(field.getFieldType().getFieldTypeId());
			}
			
			fieldVOs.add(fieldVO);
		}
		return fieldVOs;
	}

	public List<FieldVO> findAllField() {
		// TODO Auto-generated method stub
		
		fieldVOs = new ArrayList<FieldVO>();
		fields = fieldDao.getAllField();
		for(Field field : fields)
		{
			fieldVO = mapper.map(field, FieldVO.class);	
			if(field.getFieldType() != null)
			{
				fieldVO.setFieldTypeName(field.getFieldType().getFieldTypeName());
				fieldVO.setFieldTypeId(field.getFieldType().getFieldTypeId());
			}
			
			fieldVOs.add(fieldVO);
		}
		return fieldVOs;
	}

}
