package com.xyz.gym_management_sys.dao.impl;

import java.util.List;

import javax.transaction.Transactional;
import javax.annotation.Resource;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xyz.gym_management_sys.dao.EquipmentDao;
import com.xyz.gym_management_sys.po.EquType;
import com.xyz.gym_management_sys.po.Equipment;
import com.xyz.gym_management_sys.vo.DividePageVO;
import com.xyz.gym_management_sys.po.DividePage;

@Repository
public class EquipmentDaoImpl implements EquipmentDao {
	
	@Resource
	private SessionFactory SessionFactory;
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Resource
	private DividePage dividePage;
	
	
	@Transactional
	public void addEquipment(Equipment equipment) {
		// TODO Auto-generated method stub

		hibernateTemplate.save(equipment);
	}


	public void deleteEquipment(Equipment equipment) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.delete(equipment, LockMode.UPGRADE);
//		hibernateTemplate.delete(equipment);
	}

	public void updateEquipment(Equipment equipment) {
		// TODO Auto-generated method stub
		
//		hibernateTemplate.update(equipment, LockMode.UPGRADE);
		hibernateTemplate.saveOrUpdate(equipment);
	}

	public Equipment getEquipmentById(int equId) {
		// TODO Auto-generated method stub
		
		Equipment equipment = hibernateTemplate.get(Equipment.class, equId);
		return equipment;
	}

	public List<Equipment> getEquipmentsByEquType(EquType equType) {
		// TODO Auto-generated method stub
		
		List<Equipment> equipments = (List<Equipment>) hibernateTemplate.find("from Equipment equ where equ.equType=?", equType);
		return equipments;
	}

	public List<Equipment> getAllEquipment() {
		// TODO Auto-generated method stub
		
		List<Equipment> equipments = (List<Equipment>) hibernateTemplate.find("from Equipment");
		return equipments;
	}
	
	public DividePage getPageEquipment(int thisPage,int rowOfEachPage){
		// TODO Auto-generated method stub
		
		String hql = "select count(*) from Equipment equ";
		int pageCount = Integer.parseInt(String.valueOf((Long) hibernateTemplate.find(hql).listIterator().next()));
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Equipment.class);
		List<Equipment> equipments = (List<Equipment>) hibernateTemplate.findByCriteria(detachedCriteria,(thisPage-1)*rowOfEachPage,rowOfEachPage);
		
		dividePage.setNextPage(thisPage + 1);
		dividePage.setLastPage((pageCount/5)+1);
		dividePage.setPrePage(thisPage - 1);
		dividePage.setPageCount(pageCount);
		dividePage.setThisPage(thisPage);
		dividePage.setEquipments(equipments);
		System.out.println(dividePage.getLastPage());
		return dividePage;
	}


	public void mergeEquipment(Equipment equipment) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.merge(equipment);
	}


	public DividePage getPageEquipmentByEquTypeId(int thisPage, int rowOfEachPage, int equTypeId) {
		// TODO Auto-generated method stub
		
		String hql = "from Equipment equ where equ.equType.equTypeId=" + equTypeId;
		Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
		query.setFirstResult((thisPage-1)*rowOfEachPage);
		query.setMaxResults(rowOfEachPage);
		List<Equipment> equipments = query.list();
		
		hql = "select count(*) from Equipment equ where equ.equType.equTypeId=?";
		int pageCount = Integer.parseInt(String.valueOf((Long) hibernateTemplate.find(hql,equTypeId).listIterator().next()));
		
		dividePage.setNextPage(thisPage + 1);
		dividePage.setLastPage((pageCount/5)+1);
		dividePage.setPrePage(thisPage - 1);
		dividePage.setPageCount(pageCount);
		dividePage.setThisPage(thisPage);
		dividePage.setEquipments(equipments);
		System.out.println(pageCount);
		System.out.println(dividePage.getLastPage());
		
		return dividePage;
	}	
}
