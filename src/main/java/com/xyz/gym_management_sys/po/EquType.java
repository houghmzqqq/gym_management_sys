package com.xyz.gym_management_sys.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class EquType implements Serializable {
	private int equTypeId;
	private String equTypeName;
	
	public EquType() {
		super();
	}
	public EquType(String equTypeName) {
		super();
		this.equTypeName = equTypeName;
	}
	@Id @Column(name="equ_type_id")
	@GeneratedValue(generator="id")
	@GenericGenerator(name="id", strategy="increment")
	public int getEquTypeId() {
		return equTypeId;
	}
	public void setEquTypeId(int equTypeId) {
		this.equTypeId = equTypeId;
	}
	@Column(name="equ_type_name")
	public String getEquTypeName() {
		return equTypeName;
	}
	public void setEquTypeName(String equTypeName) {
		this.equTypeName = equTypeName;
	}
	
}
