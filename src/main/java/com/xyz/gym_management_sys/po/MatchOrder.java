package com.xyz.gym_management_sys.po;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class MatchOrder implements Serializable {
	private int matchOrderId;
	private String matchName;
	private String matchDescraption;
	private String matchSponsor;
	private Timestamp matchStartDate;
	private Timestamp matchEndDate;
	private float matchEquSum;
	private float matchFieldSum;
	private float matchOrderSum;
	private int matchOrderStatement;
	
	@Id @Column(name="match_order_id")
	@GeneratedValue(generator="id")
	@GenericGenerator(name="id", strategy="increment")
	public int getMatchOrderId() {
		return matchOrderId;
	}
	public void setMatchOrderId(int matchOrderId) {
		this.matchOrderId = matchOrderId;
	}
	@Column(name="match_name")
	public String getMatchName() {
		return matchName;
	}
	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}
	@Column(name="match_descraption")
	public String getMatchDescraption() {
		return matchDescraption;
	}
	public void setMatchDescraption(String matchDescraption) {
		this.matchDescraption = matchDescraption;
	}
	@Column(name="match_sponsor")
	public String getMatchSponsor() {
		return matchSponsor;
	}
	public void setMatchSponsor(String matchSponsor) {
		this.matchSponsor = matchSponsor;
	}
	@Column(name="match_start_date")
	public Timestamp getMatchStartDate() {
		return matchStartDate;
	}
	public void setMatchStartDate(Timestamp matchStartDate) {
		this.matchStartDate = matchStartDate;
	}
	@Column(name="match_end_date")
	public Timestamp getMatchEndDate() {
		return matchEndDate;
	}
	public void setMatchEndDate(Timestamp matchEndDate) {
		this.matchEndDate = matchEndDate;
	}
	@Column(name="match_equ_sum")
	public float getMatchEquSum() {
		return matchEquSum;
	}
	public void setMatchEquSum(float matchEquSum) {
		this.matchEquSum = matchEquSum;
	}
	@Column(name="match_field_sum")
	public float getMatchFieldSum() {
		return matchFieldSum;
	}
	public void setMatchFieldSum(float matchFieldSum) {
		this.matchFieldSum = matchFieldSum;
	}
	@Column(name="match_order_sum")
	public float getMatchOrderSum() {
		return matchOrderSum;
	}
	public void setMatchOrderSum(float matchOrderSum) {
		this.matchOrderSum = matchOrderSum;
	}

	@Column(name="match_order_statement")
	public int getMatchOrderStatement() {
		return matchOrderStatement;
	}
	public void setMatchOrderStatement(int matchOrderStatement) {
		this.matchOrderStatement = matchOrderStatement;
	}
}
