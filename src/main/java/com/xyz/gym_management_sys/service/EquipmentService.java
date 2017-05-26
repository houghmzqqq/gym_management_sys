package com.xyz.gym_management_sys.service;

import java.util.List;

import com.xyz.gym_management_sys.po.Equipment;

public interface EquipmentService 
{
	/**
	 *查找所有器材
	 */
	public List<Equipment> findAllEqu();
}
