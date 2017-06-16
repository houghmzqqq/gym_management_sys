package com.xyz.gym_management_sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xyz.gym_management_sys.dao.UserDao;
import com.xyz.gym_management_sys.po.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Resource
	private HibernateTemplate hibernate;
	
	public void addUser(User user) {
		// TODO Auto-generated method stub
		hibernate.save(user);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		hibernate.update(user);
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		hibernate.delete(user);
	}

	public List<User> findUserByNotNullProp(User user) {
		// TODO Auto-generated method stub
		return hibernate.findByExample(user);
	}

	public User findUserById(int userId) {
		// TODO Auto-generated method stub
		
		
		return hibernate.get(User.class, userId);
	}

}
