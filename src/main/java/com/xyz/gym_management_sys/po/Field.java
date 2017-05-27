package com.xyz.gym_management_sys.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Field implements Serializable {
	private int fieldId;
	private String fieldName;
//	private int fieldTypeId;
	private int fieldStatement;
	private float fieldBorrowUnitvalent;//单价
	private FieldType fieldType;
	
	public Field() {
		super();
	}
	public Field(String fieldName, int fieldStatement, float fieldBorrowUnitvalent, FieldType fieldType) {
		super();
		this.fieldName = fieldName;
		this.fieldStatement = fieldStatement;
		this.fieldBorrowUnitvalent = fieldBorrowUnitvalent;
		this.fieldType = fieldType;
	}
	@ManyToOne(targetEntity=FieldType.class)
	@JoinColumn(name="field_type_id",nullable=true)
	public FieldType getFieldType() {
		return fieldType;
	}
	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}
	
	@Id @Column(name="field_id")
	@GeneratedValue(generator="id")
	@GenericGenerator(name="id", strategy="increment")
	public int getFieldId() {
		return fieldId;
	}
	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}
	@Column(name="field_name")
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
//	public int getFieldTypeId() {
//		return fieldTypeId;
//	}
//	public void setFieldTypeId(int fieldTypeId) {
//		this.fieldTypeId = fieldTypeId;
//	}
	@Column(name="field_statement")
	public int getFieldStatement() {
		return fieldStatement;
	}
	public void setFieldStatement(int fieldStatement) {
		this.fieldStatement = fieldStatement;
	}
	@Column(name="field_borrow_unitvalent")
	public float getFieldBorrowUnitvalent() {
		return fieldBorrowUnitvalent;
	}
	public void setFieldBorrowUnitvalent(float fieldBorrowUnitvalent) {
		this.fieldBorrowUnitvalent = fieldBorrowUnitvalent;
	}
	
}
