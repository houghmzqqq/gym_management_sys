package com.xyz.gym_management_sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xyz.gym_management_sys.dao.FieldTypeDao;
import com.xyz.gym_management_sys.po.FieldType;

@Repository
public class FieldTypeDaoImpl implements FieldTypeDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public void addFieldType(FieldType fieldType) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.save(fieldType);
	}

	public void deleteFieldType(FieldType fieldType) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.delete(fieldType);
	}

	public FieldType getFieldTypeById(int fieldTypeId) {
		// TODO Auto-generated method stub
		
		return hibernateTemplate.get(FieldType.class, fieldTypeId);
	}

	public List<FieldType> getAllFieldType() {
		// TODO Auto-generated method stub
		
		String hql = "from FieldType";
		return (List<FieldType>) hibernateTemplate.find(hql);
	}

	public void updateFieldType(FieldType fieldType) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.update(fieldType);
	}

}
