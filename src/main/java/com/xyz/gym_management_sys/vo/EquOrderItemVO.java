package com.xyz.gym_management_sys.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.xyz.gym_management_sys.po.Field;
import com.xyz.gym_management_sys.po.FieldOrder;

public class EquOrderItemVO implements Serializable
{
	private int fieldOrderItemId;
	private int fieldOrderId;
	private int fieldId;
	private String fieldName;
	private Boolean fieldIsBroken;
	private float fieldCompensation;
	private Timestamp fieldBorrowDate;
	private Timestamp fieldReturnDate;
	private int fieldBorrowTime;
//	private Field field;
//	private FieldOrder fieldOrder;
	
	
	public int getFieldOrderItemId() {
		return fieldOrderItemId;
	}
	public void setFieldOrderItemId(int fieldOrderItemId) {
		this.fieldOrderItemId = fieldOrderItemId;
	}
	public int getFieldOrderId() {
		return fieldOrderId;
	}
	public void setFieldOrderId(int fieldOrderId) {
		this.fieldOrderId = fieldOrderId;
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
	public Boolean getFieldIsBroken() {
		return fieldIsBroken;
	}
	public void setFieldIsBroken(Boolean fieldIsBroken) {
		this.fieldIsBroken = fieldIsBroken;
	}
	public float getFieldCompensation() {
		return fieldCompensation;
	}
	public void setFieldCompensation(float fieldCompensation) {
		this.fieldCompensation = fieldCompensation;
	}
	public Timestamp getFieldBorrowDate() {
		return fieldBorrowDate;
	}
	public void setFieldBorrowDate(Timestamp fieldBorrowDate) {
		this.fieldBorrowDate = fieldBorrowDate;
	}
	public Timestamp getFieldReturnDate() {
		return fieldReturnDate;
	}
	public void setFieldReturnDate(Timestamp fieldReturnDate) {
		this.fieldReturnDate = fieldReturnDate;
	}
	public int getFieldBorrowTime() {
		return fieldBorrowTime;
	}
	public void setFieldBorrowTime(int fieldBorrowTime) {
		this.fieldBorrowTime = fieldBorrowTime;
	}
	
}
