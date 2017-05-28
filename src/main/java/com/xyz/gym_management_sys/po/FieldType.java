package com.xyz.gym_management_sys.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class FieldType implements Serializable {
	private int fieldTypeId;
	private String fieldTypeName;
	
	
	public FieldType() {
		super();
	}
	public FieldType(String fieldTypeName) {
		super();
		this.fieldTypeName = fieldTypeName;
	}
	@Id @Column(name="field_type_id")
	@GeneratedValue(generator="id")
	@GenericGenerator(name="id", strategy="increment")
	public int getFieldTypeId() {
		return fieldTypeId;
	}
	public void setFieldTypeId(int fieldTypeId) {
		this.fieldTypeId = fieldTypeId;
	}
	@Column(name="field_type_name")
	public String getFieldTypeName() {
		return fieldTypeName;
	}
	public void setFieldTypeName(String fieldTypeName) {
		this.fieldTypeName = fieldTypeName;
	}
}
