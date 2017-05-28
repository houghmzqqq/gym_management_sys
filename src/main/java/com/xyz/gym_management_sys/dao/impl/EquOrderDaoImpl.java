package com.xyz.gym_management_sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xyz.gym_management_sys.dao.EquOrderDao;
import com.xyz.gym_management_sys.po.EquOrder;
import com.xyz.gym_management_sys.po.User;

@Repository
public class EquOrderDaoImpl implements EquOrderDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public void addEquOrder(EquOrder equOrder) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.save(equOrder);
	}

	public void deleteEquOrder(EquOrder equOrder) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.delete(equOrder);
	}

	public EquOrder getEquOrderById(int equOrderId) {
		// TODO Auto-generated method stub
		
		return hibernateTemplate.get(EquOrder.class, equOrderId);
	}

	public List<EquOrder> getEquOrderByUser(User user) {
		// TODO Auto-generated method stub
		
		String hql = "from EquOrder order where order.user=?";
		return (List<EquOrder>) hibernateTemplate.find(hql, user);
	}

	public List<EquOrder> getPageEquOrder(int startRow, int rowCount) {
		// TODO Auto-generated method stub
		
		DetachedCriteria criteria = DetachedCriteria.forClass(EquOrder.class);
		return (List<EquOrder>) hibernateTemplate.findByCriteria(criteria, startRow, rowCount);
	}

	public void mergeEquOrder(EquOrder equOrder) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.merge(equOrder);
	}

}
