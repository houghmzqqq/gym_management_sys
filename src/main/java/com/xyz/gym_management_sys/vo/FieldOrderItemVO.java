package com.xyz.gym_management_sys.vo;

import java.sql.Timestamp;

import com.xyz.gym_management_sys.po.Field;
import com.xyz.gym_management_sys.po.FieldOrder;

public class FieldOrderItemVO {

	private int fieldOrderItemId;
	private int fieldOrderId;
	private int fieldId;
	private String FieldName;
	private Boolean fieldIsBroken;
	private float fieldCompensation;
	private Timestamp fieldBorrowDate;
	private Timestamp fieldReturnDate;
	private int fieldBorrowTime;
	private float itemSum;//场地订单项收取的租金
	
	
	public FieldOrderItemVO() {
		super();
	}
	public FieldOrderItemVO(int fieldOrderId, int fieldId, String fieldName, Boolean fieldIsBroken,
			float fieldCompensation, Timestamp fieldBorrowDate, Timestamp fieldReturnDate, int fieldBorrowTime,
			float itemSum) {
		super();
		this.fieldOrderId = fieldOrderId;
		this.fieldId = fieldId;
		FieldName = fieldName;
		this.fieldIsBroken = fieldIsBroken;
		this.fieldCompensation = fieldCompensation;
		this.fieldBorrowDate = fieldBorrowDate;
		this.fieldReturnDate = fieldReturnDate;
		this.fieldBorrowTime = fieldBorrowTime;
		this.itemSum = itemSum;
	}
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
		return FieldName;
	}
	public void setFieldName(String fieldName) {
		FieldName = fieldName;
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
	public float getItemSum() {
		return itemSum;
	}
	public void setItemSum(float itemSum) {
		this.itemSum = itemSum;
	}
	@Override
	public String toString() {
		return "FieldOrderItemVO [fieldOrderItemId=" + fieldOrderItemId + ", fieldOrderId=" + fieldOrderId
				+ ", fieldId=" + fieldId + ", FieldName=" + FieldName + ", fieldIsBroken=" + fieldIsBroken
				+ ", fieldCompensation=" + fieldCompensation + ", fieldBorrowDate=" + fieldBorrowDate
				+ ", fieldReturnDate=" + fieldReturnDate + ", fieldBorrowTime=" + fieldBorrowTime + ", itemSum="
				+ itemSum + "]";
	}
	
}
