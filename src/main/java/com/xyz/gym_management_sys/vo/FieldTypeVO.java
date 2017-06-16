package com.xyz.gym_management_sys.vo;

public class FieldTypeVO 
{
	private int fieldTypeId;
	private String fieldTypeName;
	
	
	public FieldTypeVO() {
		super();
	}
	public FieldTypeVO(String fieldTypeName) {
		super();
		this.fieldTypeName = fieldTypeName;
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
	
	
}
