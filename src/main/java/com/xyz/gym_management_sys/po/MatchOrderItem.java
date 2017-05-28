package com.xyz.gym_management_sys.po;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class MatchOrderItem implements Serializable {
	private int matchOrderItemId;
	private Timestamp matchItemStartTime;
	private Timestamp matchItemEndTime;
	private MatchOrder matchOrder;
	private EquOrder equOrder;
	private FieldOrder fieldOrder;
	
	@ManyToOne(targetEntity=MatchOrder.class)
	@JoinColumn(name="match_order_id",nullable=false)
	public MatchOrder getMatchOrder() {
		return matchOrder;
	}
	public void setMatchOrder(MatchOrder matchOrder) {
		this.matchOrder = matchOrder;
	}

	@OneToOne(targetEntity=EquOrder.class)
	@JoinColumn(name="equ_order_id",nullable=true)
	public EquOrder getEquOrder() {
		return equOrder;
	}
	public void setEquOrder(EquOrder equOrder) {
		this.equOrder = equOrder;
	}

	@OneToOne(targetEntity=FieldOrder.class)
	@JoinColumn(name="field_order_id",nullable=true)
	public FieldOrder getFieldOrder() {
		return fieldOrder;
	}
	public void setFieldOrder(FieldOrder fieldOrder) {
		this.fieldOrder = fieldOrder;
	}
	
	@Id @Column(name="match_orderItem_id")
	@GeneratedValue(generator="id")
	@GenericGenerator(name="id", strategy="increment")
	public int getMatchOrderItemId() {
		return matchOrderItemId;
	}
	public void setMatchOrderItemId(int matchOrderItemId) {
		this.matchOrderItemId = matchOrderItemId;
	}
	@Column(name="match_item_start_time")
	public Timestamp getMatchItemStartTime() {
		return matchItemStartTime;
	}
	public void setMatchItemStartTime(Timestamp matchItemStartTime) {
		this.matchItemStartTime = matchItemStartTime;
	}
	@Column(name="match_item_end_time")
	public Timestamp getMatchItemEndTime() {
		return matchItemEndTime;
	}
	public void setMatchItemEndTime(Timestamp matchItemEndTime) {
		this.matchItemEndTime = matchItemEndTime;
	}
}
