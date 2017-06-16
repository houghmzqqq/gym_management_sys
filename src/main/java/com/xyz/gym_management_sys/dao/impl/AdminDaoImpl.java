package com.xyz.gym_management_sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xyz.gym_management_sys.dao.AdminDao;
import com.xyz.gym_management_sys.po.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {
	
	@Resource
	private HibernateTemplate hibernate;

	public void addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		hibernate.save(admin);
	}

	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		hibernate.update(admin);
	}

	public void deleteAdmin(Admin admin) {
		// TODO Auto-generated method stub
		hibernate.delete(admin);
	}

	public List<Admin> findAdminByNotNullProp(Admin admin) {
		// TODO Auto-generated method stub
		return hibernate.findByExample(admin);
	}

}
