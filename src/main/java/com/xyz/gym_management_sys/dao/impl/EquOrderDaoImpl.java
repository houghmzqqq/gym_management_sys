package com.xyz.gym_management_sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xyz.gym_management_sys.dao.EquOrderDao;
import com.xyz.gym_management_sys.po.EquOrder;

@Repository
public class EquOrderDaoImpl implements EquOrderDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public void addEquOrder(EquOrder equOrder) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.save(equOrder);
	}

	public void deleteEquOrder(int equOrderId) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.delete(hibernateTemplate.get(EquOrder.class, equOrderId));
	}

	public EquOrder getEquOrderById(int equOrderId) {
		// TODO Auto-generated method stub
		
		return hibernateTemplate.get(EquOrder.class, equOrderId);
	}

	public List<EquOrder> getEquOrderByUserId(int userId) {
		// TODO Auto-generated method stub
		
		String hql = "from EquOrder order where order.user.userId=?";
		return (List<EquOrder>) hibernateTemplate.find(hql, userId);
	}

}
