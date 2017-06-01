package com.xyz.gym_management_sys.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CartVO 
{
	private List<EquCartDetailVO> equCartRecordVOs = new ArrayList<EquCartDetailVO>();

	public List<EquCartDetailVO> getEquCartDetailVOs() {
		return equCartRecordVOs;
	}

	public void setEquCartDetailVOs(List<EquCartDetailVO> equCartDetailVOs) {
		this.equCartRecordVOs = equCartDetailVOs;
	}

	@Override
	public String toString() {
		return "CartVO [equCartDetailVOs=" + equCartRecordVOs + "]";
	}
	
}
