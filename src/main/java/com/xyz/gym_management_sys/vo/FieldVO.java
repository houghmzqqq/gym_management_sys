package com.xyz.gym_management_sys.vo;

import java.io.Serializable;

import com.xyz.gym_management_sys.po.FieldType;

public class FieldVO implements Serializable
{
	private int fieldId;
	private String fieldName;
	private int fieldTypeId;
	private String fieldTypeName;
	private int fieldStatement;
	private float fieldBorrowUnitvalent;//单价
	
	
	public FieldVO() {
		super();
	}
	public FieldVO(String fieldName, int fieldTypeId, String fieldTypeName, int fieldStatement,
			float fieldBorrowUnitvalent) {
		super();
		this.fieldName = fieldName;
		this.fieldTypeId = fieldTypeId;
		this.fieldTypeName = fieldTypeName;
		this.fieldStatement = fieldStatement;
		this.fieldBorrowUnitvalent = fieldBorrowUnitvalent;
	}
	public int getFieldId() {
		return fieldId;
	}
	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public int getFieldTypeId() {
		return fieldTypeId;
	}
	public void setFieldTypeId(int fieldTypeId) {
		this.fieldTypeId = fieldTypeId;
	}
	public String getFieldTypeName() {
		return fieldTypeName;
	}
	public void setFieldTypeName(String fieldTypeName) {
		this.fieldTypeName = fieldTypeName;
	}
	public int getFieldStatement() {
		return fieldStatement;
	}
	public void setFieldStatement(int fieldStatement) {
		this.fieldStatement = fieldStatement;
	}
	public float getFieldBorrowUnitvalent() {
		return fieldBorrowUnitvalent;
	}
	public void setFieldBorrowUnitvalent(float fieldBorrowUnitvalent) {
		this.fieldBorrowUnitvalent = fieldBorrowUnitvalent;
	}
	@Override
	public String toString() {
		return "FieldVO [fieldId=" + fieldId + ", fieldName=" + fieldName + ", fieldTypeId=" + fieldTypeId
				+ ", fieldTypeName=" + fieldTypeName + ", fieldStatement=" + fieldStatement + ", fieldBorrowUnitvalent="
				+ fieldBorrowUnitvalent + "]";
	}
	
	
}
