package com.xyz.gym_management_sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xyz.gym_management_sys.dao.EquTypeDao;
import com.xyz.gym_management_sys.po.EquType;

@Repository
public class EquTypeDaoImpl implements EquTypeDao {
	
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	
	public void addEquType(EquType equType) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.save(equType);
	}

	public void deleteEquType(EquType equType) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.delete(equType);
	}

	public EquType getEquTypeById(int equTypeId) {
		// TODO Auto-generated method stub
		
		EquType equType = hibernateTemplate.get(EquType.class, equTypeId);
		return equType;
	}

	public List<EquType> getAllEquType() {
		// TODO Auto-generated method stub
		
		List<EquType> equTypes = (List<EquType>) hibernateTemplate.find("from EquType");
		
		return equTypes;
		
	}

	public void updateEquType(EquType equType) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.saveOrUpdate(equType);
	}

}
