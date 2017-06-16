package com.xyz.gym_management_sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xyz.gym_management_sys.dao.EquOrderDao;
import com.xyz.gym_management_sys.po.DividePage;
import com.xyz.gym_management_sys.po.EquOrder;
import com.xyz.gym_management_sys.po.Equipment;
import com.xyz.gym_management_sys.po.User;

@Repository
public class EquOrderDaoImpl implements EquOrderDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	@Resource
	private DividePage dividePage;
	
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

	public List<EquOrder> getEquOrderByUserId(int userId) {
		// TODO Auto-generated method stub
		
		String hql = "from EquOrder order where order.user.userId=?";
		return (List<EquOrder>) hibernateTemplate.find(hql, userId);
	}

	public DividePage getPageEquOrder(int thisPage, int rowOfEachPage) {
		// TODO Auto-generated method stub
		
		String hql = "select count(*) from EquOrder order";
		int pageCount = Integer.parseInt(String.valueOf((Long) hibernateTemplate.find(hql).listIterator().next()));
		DetachedCriteria criteria = DetachedCriteria.forClass(EquOrder.class);
		List<EquOrder> equOrders = (List<EquOrder>) hibernateTemplate.findByCriteria(criteria,(thisPage-1)*rowOfEachPage,rowOfEachPage);
		
		if((pageCount%5) != 0)
		{
			dividePage.setLastPage((pageCount/5)+1);
		}
		else
		{
			dividePage.setLastPage((pageCount/5));
		}
		
		if(thisPage >= dividePage.getLastPage())
		{
			dividePage.setNextPage(thisPage);
		}
		else
		{
			dividePage.setNextPage(thisPage + 1);
		}
		dividePage.setPrePage(thisPage - 1);
		dividePage.setPageCount(pageCount);
		dividePage.setThisPage(thisPage);
		dividePage.setEquOrders(equOrders);
		System.out.println(dividePage.getLastPage());
		return dividePage;
	}

	public void mergeEquOrder(EquOrder equOrder) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.merge(equOrder);
	}

	public void updateEquOrder(EquOrder equOrder) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.update(equOrder);
	}

}
