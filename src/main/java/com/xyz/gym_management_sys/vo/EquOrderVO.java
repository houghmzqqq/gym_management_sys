package com.xyz.gym_management_sys.vo;

import java.sql.Timestamp;

import com.xyz.gym_management_sys.po.User;

public class EquOrderVO 
{
	private int equOrderId;
	private int userId;
	private String userName;
	private Timestamp equOrderDate;
	private Timestamp equBorrowDate;
	private Timestamp equReturnDate;
	private int equBorrowTime;
	private int equOrderStatement;
	private float equTotalDeposit;
	private float equOrderSum;
	private float equTotalCompensation;
//	private User user;
	
	public int getEquOrderId() {
		return equOrderId;
	}
	public EquOrderVO() {
	super();
}
	public EquOrderVO(int userId, String userName, Timestamp equOrderDate, Timestamp equBorrowDate, Timestamp equReturnDate,
		int equBorrowTime, int equOrderStatement, float equTotalDeposit, float equOrderSum,
		float equTotalCompensation) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.equOrderDate = equOrderDate;
	this.equBorrowDate = equBorrowDate;
	this.equReturnDate = equReturnDate;
	this.equBorrowTime = equBorrowTime;
	this.equOrderStatement = equOrderStatement;
	this.equTotalDeposit = equTotalDeposit;
	this.equOrderSum = equOrderSum;
	this.equTotalCompensation = equTotalCompensation;
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
	public void setEquOrderId(int equOrderId) {
		this.equOrderId = equOrderId;
	}
	public Timestamp getEquOrderDate() {
		return equOrderDate;
	}
	public void setEquOrderDate(Timestamp equOrderDate) {
		this.equOrderDate = equOrderDate;
	}
	public Timestamp getEquBorrowDate() {
		return equBorrowDate;
	}
	public void setEquBorrowDate(Timestamp equBorrowDate) {
		this.equBorrowDate = equBorrowDate;
	}
	public Timestamp getEquReturnDate() {
		return equReturnDate;
	}
	public void setEquReturnDate(Timestamp equReturnDate) {
		this.equReturnDate = equReturnDate;
	}
	public int getEquBorrowTime() {
		return equBorrowTime;
	}
	public void setEquBorrowTime(int equBorrowTime) {
		this.equBorrowTime = equBorrowTime;
	}
	public int getEquOrderStatement() {
		return equOrderStatement;
	}
	public void setEquOrderStatement(int equOrderStatement) {
		this.equOrderStatement = equOrderStatement;
	}
	public float getEquTotalDeposit() {
		return equTotalDeposit;
	}
	public void setEquTotalDeposit(float equTotalDeposit) {
		this.equTotalDeposit = equTotalDeposit;
	}
	public float getEquOrderSum() {
		return equOrderSum;
	}
	public void setEquOrderSum(float equOrderSum) {
		this.equOrderSum = equOrderSum;
	}
	public float getEquTotalCompensation() {
		return equTotalCompensation;
	}
	public void setEquTotalCompensation(float equTotalCompensation) {
		this.equTotalCompensation = equTotalCompensation;
	}
	@Override
	public String toString() {
		return "EquOrderVO [equOrderId=" + equOrderId + ", userId=" + userId + ", userName=" + userName
				+ ", equOrderDate=" + equOrderDate + ", equBorrowDate=" + equBorrowDate + ", equReturnDate="
				+ equReturnDate + ", equBorrowTime=" + equBorrowTime + ", equOrderStatement=" + equOrderStatement
				+ ", equTotalDeposit=" + equTotalDeposit + ", equOrderSum=" + equOrderSum + ", equTotalCompensation="
				+ equTotalCompensation + "]";
	}
	
}
