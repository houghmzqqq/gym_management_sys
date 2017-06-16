package com.xyz.gym_management_sys.dao;

import java.util.List;

import com.xyz.gym_management_sys.po.User;

/**
 * 这个接口定义了User实体对应的数据库操作方法
 * @author HIPAA
 */
public interface UserDao {
	/**
	 * 向数据库中添加一条新的用户基本信息记录
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * 更新数据库中指定的一条用户基本信息记录，传入的User对象中主键对应的属性不可为空
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * 删除数据库中指定的一条用户基本信息记录，传入的User对象中主键对应的属性不可为空
	 * @param user
	 */
	public void deleteUser(User user);
	
	/**
	 * 通过传入的User对象中不为空的属性作为查询条件查询多条用户基本信息记录
	 * @param user
	 * @return List<User>
	 */
	public List<User> findUserByNotNullProp(User user);
	
	/**
	 * 根据用户编号查找用户
	 * @param userId 用户编号
	 * @return User
	 */
	public User findUserById(int userId);
}
