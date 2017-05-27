package com.xyz.gym_management_sys.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class EquOrderItem implements Serializable {
	private int equOrderItemId;
//	private int equOrderId;
//	private int equId;
	private int equBreakCount;
	private int equCount;
	private float equCompensation;
	private Equipment equipment;
	private EquOrder equOrder;
	
	public EquOrderItem() {
		super();
	}
	public EquOrderItem(int equBreakCount, int equCount, float equCompensation, Equipment equipment,
			EquOrder equOrder) {
		super();
		this.equBreakCount = equBreakCount;
		this.equCount = equCount;
		this.equCompensation = equCompensation;
		this.equipment = equipment;
		this.equOrder = equOrder;
	}
	@ManyToOne(targetEntity=Equipment.class)
	@JoinColumn(name="equ_id",nullable=true)
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	@ManyToOne(targetEntity=EquOrder.class)
	@JoinColumn(name="equ_order_id",nullable=false)
	public EquOrder getEquOrder() {
		return equOrder;
	}
	public void setEquOrder(EquOrder equOrder) {
		this.equOrder = equOrder;
	}
	@Id @Column(name="equ_orderItem_id")
	@GeneratedValue(generator="id")
	@GenericGenerator(name="id", strategy="increment")
	public int getEquOrderItemId() {
		return equOrderItemId;
	}
	public void setEquOrderItemId(int equOrderItemId) {
		this.equOrderItemId = equOrderItemId;
	}
//	public int getEquOrderId() {
//		return equOrderId;
//	}
//	public void setEquOrderId(int equOrderId) {
//		this.equOrderId = equOrderId;
//	}
//	public int getEquId() {
//		return equId;
//	}
//	public void setEquId(int equId) {
//		this.equId = equId;
//	}
	@Column(name="equ_break_count")
	public int getEquBreakCount() {
		return equBreakCount;
	}
	public void setEquBreakCount(int equBreakCount) {
		this.equBreakCount = equBreakCount;
	}
	@Column(name="equ_count")
	public int getEquCount() {
		return equCount;
	}
	public void setEquCount(int equCount) {
		this.equCount = equCount;
	}
	@Column(name="equ_compensation")
	public float getEquCompensation() {
		return equCompensation;
	}
	public void setEquCompensation(float equCompensation) {
		this.equCompensation = equCompensation;
	}
}
