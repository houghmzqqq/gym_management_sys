package com.xyz.gym_management_sys.vo;

/**
 * 这是简单的普通用户相关的业务实体类，用于用户列表展示用
 * @author HIPAA
 */
public class SimpleUserVo {
	
	private int userId;
	private String userName;
	private String name;
	private String userRole;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
}
