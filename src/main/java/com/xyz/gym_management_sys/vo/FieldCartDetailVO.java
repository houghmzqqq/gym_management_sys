package com.xyz.gym_management_sys.vo;

import java.sql.Timestamp;

public class FieldCartDetailVO 
{
	private String cartRecordId;
	private int fieldId;
	private Timestamp fieldBorrowDate;
	private Timestamp fieldReturnDate;
	private int fieldBorrowTime;
	
	
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
	public String getCartRecordId() {
		return cartRecordId;
	}
	public void setCartRecordId(String cartRecordId) {
		this.cartRecordId = cartRecordId;
	}
	public int getFieldId() {
		return fieldId;
	}
	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}
	public int getFieldBorrowTime() {
		return fieldBorrowTime;
	}
	public void setFieldBorrowTime(int fieldBorrowTime) {
		this.fieldBorrowTime = fieldBorrowTime;
	}
	
	@Override
	public String toString() {
		return "FieldCartDetailVO [cartRecordId=" + cartRecordId + ", fieldId=" + fieldId + ", fieldBorrowDate="
				+ fieldBorrowDate + ", fieldReturnDate=" + fieldReturnDate + ", fieldBorrowTime=" + fieldBorrowTime
				+ "]";
	}
	
}
