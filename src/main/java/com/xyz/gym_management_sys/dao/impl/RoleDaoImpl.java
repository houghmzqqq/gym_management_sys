package com.xyz.gym_management_sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xyz.gym_management_sys.dao.RoleDao;
import com.xyz.gym_management_sys.po.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Resource
	private HibernateTemplate hibernate;
	
	public void addRole(Role role) {
		hibernate.save(role);
	}

	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		hibernate.update(role);

	}

	public void deleteRole(Role role) {
		// TODO Auto-generated method stub
		hibernate.delete(role);
	}

	public List<Role> findRoleByNotNullProp(Role role) {
		// TODO Auto-generated method stub
		return hibernate.findByExample(role);
	}

}
