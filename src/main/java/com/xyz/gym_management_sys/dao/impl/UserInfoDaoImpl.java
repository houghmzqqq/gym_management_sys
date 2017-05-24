package com.xyz.gym_management_sys.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xyz.gym_management_sys.dao.UserInfoDao;
import com.xyz.gym_management_sys.po.UserInfo;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {

	@Resource
	private HibernateTemplate hibernate;
	
	public void addUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		hibernate.save(userInfo);
	}

	public void updateUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		hibernate.update(userInfo);
	}

	public void deleteUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		hibernate.delete(userInfo);
	}

	public List<UserInfo> findUserInofByNotNullProp(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return hibernate.findByExample(userInfo);
	}

}
