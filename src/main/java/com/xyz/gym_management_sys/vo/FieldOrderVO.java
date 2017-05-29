package com.xyz.gym_management_sys.vo;

import java.sql.Timestamp;

import com.xyz.gym_management_sys.po.User;

public class FieldOrderVO 
{
	private int fieldOrderId;
	private int userId;
	private String userName;
	private Timestamp fieldOrderDate;
	private int fieldOrderStatement;
	private float fieldOrderSum;
	private float fieldTotalCompensation;
	
	
	public FieldOrderVO() {
		super();
	}
	public FieldOrderVO( int userId, String userName, Timestamp fieldOrderDate,
			int fieldOrderStatement, float fieldOrderSum, float fieldTotalCompensation) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.fieldOrderDate = fieldOrderDate;
		this.fieldOrderStatement = fieldOrderStatement;
		this.fieldOrderSum = fieldOrderSum;
		this.fieldTotalCompensation = fieldTotalCompensation;
	}
	public int getFieldOrderId() {
		return fieldOrderId;
	}
	public void setFieldOrderId(int fieldOrderId) {
		this.fieldOrderId = fieldOrderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Timestamp getFieldOrderDate() {
		return fieldOrderDate;
	}
	public void setFieldOrderDate(Timestamp fieldOrderDate) {
		this.fieldOrderDate = fieldOrderDate;
	}
	public int getFieldOrderStatement() {
		return fieldOrderStatement;
	}
	public void setFieldOrderStatement(int fieldOrderStatement) {
		this.fieldOrderStatement = fieldOrderStatement;
	}
	public float getFieldOrderSum() {
		return fieldOrderSum;
	}
	public void setFieldOrderSum(float fieldOrderSum) {
		this.fieldOrderSum = fieldOrderSum;
	}
	public float getFieldTotalCompensation() {
		return fieldTotalCompensation;
	}
	public void setFieldTotalCompensation(float fieldTotalCompensation) {
		this.fieldTotalCompensation = fieldTotalCompensation;
	}
	@Override
	public String toString() {
		return "FieldOrderVO [fieldOrderId=" + fieldOrderId + ", userId=" + userId + ", userName=" + userName
				+ ", fieldOrderDate=" + fieldOrderDate + ", fieldOrderStatement=" + fieldOrderStatement
				+ ", fieldOrderSum=" + fieldOrderSum + ", fieldTotalCompensation=" + fieldTotalCompensation + "]";
	}

	
}
