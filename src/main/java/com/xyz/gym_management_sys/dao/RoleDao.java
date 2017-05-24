package com.xyz.gym_management_sys.dao;

import java.util.List;

import com.xyz.gym_management_sys.po.Role;


/**
 * @author HIPAA
 * 这个接口定义了对Role实体进行数据库操作方法
 */
public interface RoleDao {
	
	/**
	 * 这是向数据库添加新角色的方法
	 * @param role
	 */
	public void addRole(Role role);
	
	/**
	 * 这是向数据库更新角色信息的方法
	 * @param role
	 */
	public void updateRole(Role role);
	
	/**
	 * 这是删除数据库某个角色的方法
	 * @param role
	 */
	public void deleteRole(Role role);
	
	/**
	 * 这是从数据库查询角色的方法
	 * 传入一个Role对象，将传入对象中非空的属性作为查询条件
	 * @param role
	 * @return List<Role>
	 */
	public List<Role> findRoleByNotNullProp(Role role);
	
}
