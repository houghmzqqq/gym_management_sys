package com.xyz.gym_management_sys.dao.impl;

import java.util.List;

import javax.transaction.Transactional;
import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xyz.gym_management_sys.dao.EquipmentDao;
import com.xyz.gym_management_sys.po.Equipment;

@Repository
public class EquipmentDaoImpl implements EquipmentDao {
	
	@Resource
	private SessionFactory SessionFactory;
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	
	@Transactional
	public void addEquipment(Equipment equipment) {
		// TODO Auto-generated method stub

		hibernateTemplate.save(equipment);
	}


	public void deleteEquipment(int equId) {
		// TODO Auto-generated method stub
		
		Equipment equipment = hibernateTemplate.get(Equipment.class, equId);
		hibernateTemplate.delete(equipment);
	}

	public void updateEquipment(Equipment equipment) {
		// TODO Auto-generated method stub

		hibernateTemplate.update(equipment);
	}

	public Equipment getEquipmentById(int equId) {
		// TODO Auto-generated method stub
		
		Equipment equipment = hibernateTemplate.get(Equipment.class, equId);
		return equipment;
	}

	public List<Equipment> getEquipmentsByEquTypeId(int equTypeId) {
		// TODO Auto-generated method stub
		
		List<Equipment> equipments = (List<Equipment>) hibernateTemplate.find("from Equipment equ where equ.equType.equTypeId=?", equTypeId);
		return equipments;
	}

	public List<Equipment> getAllEquipment() {
		// TODO Auto-generated method stub
		
		List<Equipment> equipments = (List<Equipment>) hibernateTemplate.find("from Equipment");
		return equipments;
	}
	
	public List<Equipment> getPageEquipment(int startRow,int rowOfEachPage){
		// TODO Auto-generated method stub
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Equipment.class);
		return (List<Equipment>) hibernateTemplate.findByCriteria(detachedCriteria, startRow, rowOfEachPage);
	}	
}
