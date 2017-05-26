package com.xyz.gym_management_sys.vo;

/**
 * 这是角色对应的VO类，用于前台传递数据
 * @author HIPAA
 */
public class RoleVo {
	
	private int roleId;
	private String roleName;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
