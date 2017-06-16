package com.xyz.gym_management_sys.vo;

/**
 * 这是添加一个新的管理员时使用的业务实体类
 * @author HIPAA
 */
public class AddAdminVo {

	private String adminName;
	private String password;
	private String confirmPsw;
	private String relName;
	private String roleName;
	
	
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPsw() {
		return confirmPsw;
	}
	public void setConfirmPsw(String confirmPsw) {
		this.confirmPsw = confirmPsw;
	}
	public String getRelName() {
		return relName;
	}
	public void setRelName(String relName) {
		this.relName = relName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
