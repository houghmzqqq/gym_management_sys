package com.xyz.gym_management_sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xyz.gym_management_sys.dao.EquOrderItemDao;
import com.xyz.gym_management_sys.po.EquOrderItem;
import com.xyz.gym_management_sys.po.Equipment;

@Repository
public class EquOrderItemDaoImpl implements EquOrderItemDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public void addEquOrderItem(EquOrderItem equOrderItem) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.save(equOrderItem);
	}

	public List<EquOrderItem> getEquOrderItemByEquOrderId(int equOrderId) {
		// TODO Auto-generated method stub
		
		String hql = "from EquOrderItem item where item.equOrder.equOrderId=?";
		return (List<EquOrderItem>) hibernateTemplate.find(hql, equOrderId);
	}

	public List<EquOrderItem> getEquOrderItemByEqu(Equipment equipment) {
		// TODO Auto-generated method stub
		String hql = "from EquOrderItem item where item.equipment=?";
		return (List<EquOrderItem>) hibernateTemplate.find(hql, equipment);
	}

	public void mergeEquOrderItem(EquOrderItem equOrderItem) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.merge(equOrderItem);
	}

	public void updateEquOrderItem(EquOrderItem equOrderItem) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.saveOrUpdate(equOrderItem);
	}

}
