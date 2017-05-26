package com.xyz.gym_management_sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xyz.gym_management_sys.dao.EquipmentDao;
import com.xyz.gym_management_sys.po.Equipment;
import com.xyz.gym_management_sys.service.EquipmentService;

@Service
public class EquipmentServiceImpl implements EquipmentService {

	@Resource
	private EquipmentDao equipmentDao;
	
	public List<Equipment> findAllEqu() {
		// TODO Auto-generated method stub
		List<Equipment> equipments = equipmentDao.getAllEquipment();
		for(Equipment equipment : equipments)
		{
			System.out.println(equipment.getEquName()+" : " + equipment.getEquValue()+"元");
		}
		return null;
	}

}
