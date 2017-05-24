package com.xyz.gym_management_sys.po;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class FieldOrder implements Serializable {
	private int fieldOrderId;
//	private int userId;
	private Timestamp fieldOrderDate;
	private int fieldOrderStatement;
	private float fieldOrderSum;
	private float fieldTotalCompensation;
	private User user;
	
	public FieldOrder() {
		super();
	}
	public FieldOrder(Timestamp fieldOrderDate, int fieldOrderStatement, float fieldOrderSum,
			float fieldTotalCompensation, User user) {
		super();
		this.fieldOrderDate = fieldOrderDate;
		this.fieldOrderStatement = fieldOrderStatement;
		this.fieldOrderSum = fieldOrderSum;
		this.fieldTotalCompensation = fieldTotalCompensation;
		this.user = user;
	}
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="user_id",nullable=false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Id @Column(name="field_order_id")
	@GeneratedValue(generator="id")
	@GenericGenerator(name="id", strategy="increment")
	public int getFieldOrderId() {
		return fieldOrderId;
	}
	public void setFieldOrderId(int fieldOrderId) {
		this.fieldOrderId = fieldOrderId;
	}
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
	@Column(name="field_order_date")
	public Timestamp getFieldOrderDate() {
		return fieldOrderDate;
	}
	public void setFieldOrderDate(Timestamp fieldOrderDate) {
		this.fieldOrderDate = fieldOrderDate;
	}
	@Column(name="field_order_statement")
	public int getFieldOrderStatement() {
		return fieldOrderStatement;
	}
	public void setFieldOrderStatement(int fieldOrderStatement) {
		this.fieldOrderStatement = fieldOrderStatement;
	}
	@Column(name="field_order_sum")
	public float getFieldOrderSum() {
		return fieldOrderSum;
	}
	public void setFieldOrderSum(float fieldOrderSum) {
		this.fieldOrderSum = fieldOrderSum;
	}
	@Column(name="field_total_compensation")
	public float getFieldTotalCompensation() {
		return fieldTotalCompensation;
	}
	public void setFieldTotalCompensation(float fieldTotalCompensation) {
		this.fieldTotalCompensation = fieldTotalCompensation;
	}
	
}
