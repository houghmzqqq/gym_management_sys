package com.xyz.gym_management_sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xyz.gym_management_sys.dao.FieldOrderItemDao;
import com.xyz.gym_management_sys.po.FieldOrderItem;

@Repository
public class FieldOrderItemDaoImpl implements FieldOrderItemDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public void addFieldOrderItem(FieldOrderItem fieldOrderItem) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.save(fieldOrderItem);
	}

	public List<FieldOrderItem> getFieldOrderItemByFieldOrderId(int fieldOrderId) {
		// TODO Auto-generated method stub
		
		String hql = "from FieldOrderItem fItem where fItem.fieldOrder.fieldOrderId=?";
		return (List<FieldOrderItem>) hibernateTemplate.find(hql, fieldOrderId);
	}

	public void deleteFieldOrderItem(FieldOrderItem fieldOrderItem) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.delete(fieldOrderItem);
	}

	public void updateFieldOrderItem(FieldOrderItem fieldOrderItem) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.update(fieldOrderItem);
	}

	public void mergeFieldOrderItem(FieldOrderItem fieldOrderItem) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.merge(fieldOrderItem);
	}

	public List<FieldOrderItem> getFieldOrderItemByFieldId(int fieldId) {
		// TODO Auto-generated method stub
		
		String hql = "from FieldOrderItem fItem where fItem.field.fieldId=?";
		return (List<FieldOrderItem>) hibernateTemplate.find(hql, fieldId);
	}

}
