package com.xyz.gym_management_sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xyz.gym_management_sys.dao.FieldOrderDao;
import com.xyz.gym_management_sys.po.FieldOrder;

@Repository
public class FieldOrderDaoImpl implements FieldOrderDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public void addFieldOrder(FieldOrder fieldOrder) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.save(fieldOrder);
	}

	public void deleteFieldOrder(FieldOrder fieldOrder) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.delete(fieldOrder);
	}

	public FieldOrder getFieldOrderById(int fieldOrderId) {
		// TODO Auto-generated method stub
		
		return hibernateTemplate.get(FieldOrder.class, fieldOrderId);
	}

	public List<FieldOrder> getFieldOrderByUserId(int userId) {
		// TODO Auto-generated method stub
		
		String hql = "from FieldOrder fOrder where fOrder.user.userId=?";
		return (List<FieldOrder>) hibernateTemplate.find(hql, userId);
	}

	public List<FieldOrder> getPageFieldOrder(int startRow, int rowCount) {
		// TODO Auto-generated method stub
		
		DetachedCriteria criteria = DetachedCriteria.forClass(FieldOrder.class);
		return (List<FieldOrder>) hibernateTemplate.findByCriteria(criteria, startRow, rowCount);
	}

	public void updateFieldOrder(FieldOrder fieldOrder) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.update(fieldOrder);
	}

	public void mergeFieldOrder(FieldOrder fieldOrder) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.merge(fieldOrder);
	}

	public List<FieldOrder> getAllFieldOrder() {
		// TODO Auto-generated method stub
		
		String hql = "from FieldOrder fOrder";
		return (List<FieldOrder>) hibernateTemplate.find(hql);
	}

}
