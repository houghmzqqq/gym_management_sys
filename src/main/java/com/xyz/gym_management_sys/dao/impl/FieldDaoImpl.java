package com.xyz.gym_management_sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xyz.gym_management_sys.dao.FieldDao;
import com.xyz.gym_management_sys.po.Field;

@Repository
public class FieldDaoImpl implements FieldDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public void addField(Field field) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.save(field);
	}

	public void deleteField(Field field) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.delete(field);
	}

	public void updateField(Field field) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.update(field);
	}

	public Field getFieldById(int fieldId) {
		// TODO Auto-generated method stub
		
		return hibernateTemplate.get(Field.class, fieldId);
	}

	public List<Field> getFieldsByEquTypeId(int fieldTypeId) {
		// TODO Auto-generated method stub
		
		String hql = "from Field fi where fi.fieldType.fieldTypeId=?";
		return (List<Field>) hibernateTemplate.find(hql,fieldTypeId);
	}

	public List<Field> getAllField() {
		// TODO Auto-generated method stub
		
		String hql = "from Field";
		return (List<Field>) hibernateTemplate.find(hql);
	}

	public List<Field> getPageField(int startRow, int rowOfEachPage) {
		// TODO Auto-generated method stub
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Field.class);
		return (List<Field>) hibernateTemplate.findByCriteria(criteria,startRow,rowOfEachPage);
	}

	public void mergeField(Field field) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.merge(field);
	}

}
