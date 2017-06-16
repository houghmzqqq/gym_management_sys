package com.xyz.gym_management_sys.po;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class EquOrder implements Serializable {
	private int equOrderId;
//	private int userId;
	private Timestamp equOrderDate;
	private Timestamp equBorrowDate;
	private Timestamp equReturnDate;
	private int equBorrowTime;
	private int equOrderStatement;
	private float equTotalDeposit;
	private float equOrderSum;
	private float equTotalCompensation;
	private User user;
	
	public EquOrder() {
		super();
	}
	public EquOrder(Timestamp equOrderDate, Timestamp equBorrowDate, Timestamp equReturnDate, int equBorrowTime,
			int equOrderStatement, float equTotalDeposit, float equOrderSum, float equTotalCompensation, User user) {
		super();
		this.equOrderDate = equOrderDate;
		this.equBorrowDate = equBorrowDate;
		this.equReturnDate = equReturnDate;
		this.equBorrowTime = equBorrowTime;
		this.equOrderStatement = equOrderStatement;
		this.equTotalDeposit = equTotalDeposit;
		this.equOrderSum = equOrderSum;
		this.equTotalCompensation = equTotalCompensation;
		this.user = user;
	}
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="user_id",nullable=true)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Id @Column(name="equ_order_id")
	@GeneratedValue(generator="id")
	@GenericGenerator(name="id", strategy="increment")
	public int getEquOrderId() {
		return equOrderId;
	}
	public void setEquOrderId(int equOrderId) {
		this.equOrderId = equOrderId;
	}
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
	@Column(name="equ_order_date")
	public Timestamp getEquOrderDate() {
		return equOrderDate;
	}
	public void setEquOrderDate(Timestamp equOrderDate) {
		this.equOrderDate = equOrderDate;
	}
	@Column(name="equ_borrow_date")
	public Timestamp getEquBorrowDate() {
		return equBorrowDate;
	}
	public void setEquBorrowDate(Timestamp equBorrowDate) {
		this.equBorrowDate = equBorrowDate;
	}
	@Column(name="equ_return_date")
	public Timestamp getEquReturnDate() {
		return equReturnDate;
	}
	public void setEquReturnDate(Timestamp equReturnDate) {
		this.equReturnDate = equReturnDate;
	}
	@Column(name="equ_borrow_time")
	public int getEquBorrowTime() {
		return equBorrowTime;
	}
	public void setEquBorrowTime(int equBorrowTime) {
		this.equBorrowTime = equBorrowTime;
	}
	@Column(name="equ_order_statement")
	public int getEquOrderStatement() {
		return equOrderStatement;
	}
	public void setEquOrderStatement(int equOrderStatement) {
		this.equOrderStatement = equOrderStatement;
	}
	@Column(name="equ_total_deposit")
	public float getEquTotalDeposit() {
		return equTotalDeposit;
	}
	public void setEquTotalDeposit(float equTotalDeposit) {
		this.equTotalDeposit = equTotalDeposit;
	}
	@Column(name="equ_order_sum")
	public float getEquOrderSum() {
		return equOrderSum;
	}
	public void setEquOrderSum(float equOrderSum) {
		this.equOrderSum = equOrderSum;
	}
	@Column(name="equ_total_compensation")
	public float getEquTotalCompensation() {
		return equTotalCompensation;
	}
	public void setEquTotalCompensation(float equTotalCompensation) {
		this.equTotalCompensation = equTotalCompensation;
	}
	@Override
	public String toString() {
		return "EquOrder [equOrderId=" + equOrderId + ", equOrderDate=" + equOrderDate + ", equBorrowDate="
				+ equBorrowDate + ", equReturnDate=" + equReturnDate + ", equBorrowTime=" + equBorrowTime
				+ ", equOrderStatement=" + equOrderStatement + ", equTotalDeposit=" + equTotalDeposit + ", equOrderSum="
				+ equOrderSum + ", equTotalCompensation=" + equTotalCompensation + ", user=" + user + "]";
	}
	
}
