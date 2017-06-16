package com.xyz.gym_management_sys.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CartVO 
{
	private List<EquCartDetailVO> equCartRecordVOs = new ArrayList<EquCartDetailVO>();
	private List<FieldCartDetailVO> fieldCartRecordVOS = new ArrayList<FieldCartDetailVO>();

	public List<EquCartDetailVO> getEquCartRecordVOs() {
		return equCartRecordVOs;
	}

	public void setEquCartRecordVOs(List<EquCartDetailVO> equCartRecordVOs) {
		this.equCartRecordVOs = equCartRecordVOs;
	}

	public List<FieldCartDetailVO> getFieldCartRecordVOS() {
		return fieldCartRecordVOS;
	}

	public void setFieldCartRecordVOS(List<FieldCartDetailVO> fieldCartRecordVOS) {
		this.fieldCartRecordVOS = fieldCartRecordVOS;
	}

	public List<EquCartDetailVO> getEquCartDetailVOs() {
		return equCartRecordVOs;
	}

	public void setEquCartDetailVOs(List<EquCartDetailVO> equCartDetailVOs) {
		this.equCartRecordVOs = equCartDetailVOs;
	}

	@Override
	public String toString() {
		return "CartVO [equCartRecordVOs=" + equCartRecordVOs + ", fieldCartRecordVOS=" + fieldCartRecordVOS + "]";
	}
	
}
