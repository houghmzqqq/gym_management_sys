package com.xyz.gym_management_sys.dao;

import java.util.List;

import com.xyz.gym_management_sys.po.User;
import com.xyz.gym_management_sys.po.UserInfo;

/**
 * 这个接口定义了UserInfo实体相应的数据库操作方法
 * @author HIPAA
 */
public interface UserInfoDao {
	/**
	 * 向数据库中添加一条新的用户详细信息记录
	 * @param userInfo
	 */
	public void addUserInfo(UserInfo userInfo);
	
	/**
	 * 更新数据库中指定的一条用户详细信息记录，传入的UserInfo对象中主键对应的属性不可为空
	 * @param userInfo
	 */
	public void updateUserInfo(UserInfo userInfo);
	
	/**
	 * 删除数据库中一条指定的用户详细信息记录，传入的UserInfo对象中主键对应的属性不可为空
	 * @param userInfo
	 */
	public void deleteUserInfo(UserInfo userInfo);
	
	/**
	 * 通过传入的UserInfo对象中不为空的属性（非主键属性）作为查询条件，查找多条用户详细信息记录
	 * @param userInfo
	 * @return List<UserInfo>
	 */
	public List<UserInfo> findUserInofByNotNullProp(UserInfo userInfo);
	
	/**
	 * 通过传入关联对象查找用户详细信息记录
	 * @param user
	 * @return
	 */
	public List<UserInfo> findUserINfoByPropObj(User user);
	
}
