package com.xyz.gym_management_sys.po;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Admin implements Serializable {
	//自增长的主键
	private int adminId;
	private String adminName;
	private String password;
	private String relName;
	private Role role;
	
	public Admin(String adminName, String password, String relName, Role role) {
		super();
		this.adminName = adminName;
		this.password = password;
		this.relName = relName;
		this.role = role;
	}
	
	public Admin() {
		super();
	}

	@Id @Column(name="admin_id")
	@GeneratedValue(generator="id")
	@GenericGenerator(name="id", strategy="increment")
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	@Column(name="admin_name")
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="admin_rel_name")
	public String getRelName() {
		return relName;
	}
	public void setRelName(String relName) {
		this.relName = relName;
	}
//	public int getRoleId() {
//		return roleId;
//	}
//	public void setRoleId(int roleId) {
//		this.roleId = roleId;
//	}
	@ManyToOne(targetEntity=Role.class)
	@JoinColumn(name="role_id",nullable=false)
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
