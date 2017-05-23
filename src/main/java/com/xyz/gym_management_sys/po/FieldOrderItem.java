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
public class FieldOrderItem implements Serializable {
	private int fieldOrderItemId;
//	private int fieldOrderId;
//	private int fieldId;
	private Boolean fieldIsBroken;
	private float fieldCompensation;
	private Timestamp fieldBorrowDate;
	private Timestamp fieldReturnDate;
	private int fieldBorrowTime;
	private Field field;
	private FieldOrder fieldOrder;
	
	@ManyToOne(targetEntity=Field.class)
	@JoinColumn(name="field_id",nullable=false)
	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
	}
	
	@ManyToOne(targetEntity=FieldOrder.class)
	@JoinColumn(name="field_order_id",nullable=false)
	public FieldOrder getFieldOrder() {
		return fieldOrder;
	}
	public void setFieldOrder(FieldOrder fieldOrder) {
		this.fieldOrder = fieldOrder;
	}
	
	@Id @Column(name="field_orderItem_id")
	@GeneratedValue(generator="id")
	@GenericGenerator(name="id", strategy="increment")
	public int getFieldOrderItemId() {
		return fieldOrderItemId;
	}
	public void setFieldOrderItemId(int fieldOrderItemId) {
		this.fieldOrderItemId = fieldOrderItemId;
	}
//	public int getFieldOrderId() {
//		return fieldOrderId;
//	}
//	public void setFieldOrderId(int fieldOrderId) {
//		this.fieldOrderId = fieldOrderId;
//	}
//	public int getFieldId() {
//		return fieldId;
//	}
//	public void setFieldId(int fieldId) {
//		this.fieldId = fieldId;
//	}
	@Column(name="field_isBroken")
	public Boolean getFieldIsBroken() {
		return fieldIsBroken;
	}
	public void setFieldIsBroken(Boolean fieldIsBroken) {
		this.fieldIsBroken = fieldIsBroken;
	}
	@Column(name="field_compensation")
	public float getFieldCompensation() {
		return fieldCompensation;
	}
	public void setFieldCompensation(float fieldCompensation) {
		this.fieldCompensation = fieldCompensation;
	}
	@Column(name="field_borrow_date")
	public Timestamp getFieldBorrowDate() {
		return fieldBorrowDate;
	}
	public void setFieldBorrowDate(Timestamp fieldBorrowDate) {
		this.fieldBorrowDate = fieldBorrowDate;
	}
	@Column(name="field_return_date")
	public Timestamp getFieldReturnDate() {
		return fieldReturnDate;
	}
	public void setFieldReturnDate(Timestamp fieldReturnDate) {
		this.fieldReturnDate = fieldReturnDate;
	}
	@Column(name="field_borrow_time")
	public int getFieldBorrowTime() {
		return fieldBorrowTime;
	}
	public void setFieldBorrowTime(int fieldBorrowTime) {
		this.fieldBorrowTime = fieldBorrowTime;
	}
}
