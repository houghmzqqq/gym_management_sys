package com.xyz.gym_management_sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.xyz.gym_management_sys.dao.EquOrderItemDao;
import com.xyz.gym_management_sys.dao.EquTypeDao;
import com.xyz.gym_management_sys.dao.EquipmentDao;
import com.xyz.gym_management_sys.po.EquOrderItem;
import com.xyz.gym_management_sys.po.EquType;
import com.xyz.gym_management_sys.po.Equipment;
import com.xyz.gym_management_sys.service.EquipmentService;
import com.xyz.gym_management_sys.vo.EquipmentVO;

@Service
public class EquipmentServiceImpl implements EquipmentService {

	@Resource
	private DozerBeanMapper mapper;
	@Resource
	private EquipmentDao equipmentDao;
	@Resource
	private EquTypeDao equTypeDao;
	@Resource
	private EquOrderItemDao equOrderItemDao;
	
	List<EquipmentVO> equipmentVOs;
	EquipmentVO equipmentVO;
	
	public List<EquipmentVO> findAllEqu() {
		// TODO Auto-generated method stub
		
		equipmentVOs = new ArrayList<EquipmentVO>();
		List<Equipment> equipments = equipmentDao.getAllEquipment();
		
		for(Equipment equipment : equipments)
		{
			equipmentVO = mapper.map(equipment, EquipmentVO.class);
			setOtherProperty(equipment);
			
			equipmentVOs.add(equipmentVO);
			
		}
		return equipmentVOs;
	}

	public List<EquipmentVO> dividePageOfEqu(int nextPage, int rowOfEachPage) {
		// TODO Auto-generated method stub

		equipmentVOs = new ArrayList<EquipmentVO>();
		List<Equipment> equipments = equipmentDao.getPageEquipment((nextPage*rowOfEachPage), rowOfEachPage);
		
		for(Equipment equipment : equipments)
		{
			equipmentVO = mapper.map(equipment, EquipmentVO.class);
			setOtherProperty(equipment);
			
			equipmentVOs.add(equipmentVO);
		}
		return equipmentVOs;
	}

	public List<EquipmentVO> findEquByEquTypeId(int equTypeId) {
		// TODO Auto-generated method stub

		equipmentVOs = new ArrayList<EquipmentVO>();
		EquType equType = equTypeDao.getEquTypeById(equTypeId);
		List<Equipment> equipments = equipmentDao.getEquipmentsByEquType(equType);
		
		for(Equipment equipment : equipments)
		{
			equipmentVO = mapper.map(equipment, EquipmentVO.class);
			setOtherProperty(equipment);
			
			equipmentVOs.add(equipmentVO);
		}
		return equipmentVOs;
	}

	public EquipmentVO findEquById(int equId) {
		// TODO Auto-generated method stub
		
		Equipment equipment = equipmentDao.getEquipmentById(equId);
		equipmentVO = mapper.map(equipment, EquipmentVO.class);
		setOtherProperty(equipment);
		return equipmentVO;
	}

	public void addEqu(EquipmentVO equipmentVO) {
		// TODO Auto-generated method stub
		
		Equipment equipment = mapper.map(equipmentVO, Equipment.class);
		EquType equType = equTypeDao.getEquTypeById(equipmentVO.getEquTypeId());
		equipment.setEquType(equType);
		equipmentDao.addEquipment(equipment);
	}

	public void removeEqu(int equId) {
		// TODO Auto-generated method stub
		
		Equipment equipment = equipmentDao.getEquipmentById(equId);

		//所有与该器材匹配的器材订单项，将其器材外键设为null
		List<EquOrderItem> equOrderItems = equOrderItemDao.getEquOrderItemByEqu(equipment);
		for(EquOrderItem equOrderItem : equOrderItems)
		{
			equOrderItem.setEquipment(null);
			equOrderItemDao.mergeEquOrderItem(equOrderItem);
		}
		
		equipmentDao.deleteEquipment(equipment);
	}

	public void updateEqu(EquipmentVO equipmentVO) {
		// TODO Auto-generated method stub
		
		Equipment equipment = mapper.map(equipmentVO, Equipment.class);
		EquType equType = equTypeDao.getEquTypeById(equipmentVO.getEquTypeId());
		equipment.setEquType(equType);
		equipmentDao.updateEquipment(equipment);
	}
	
	public void setOtherProperty(Equipment equipment)
	{
		int equTotalCount;
		
		equipmentVO.setEquTypeId(equipment.getEquType().getEquTypeId());
		equipmentVO.setEquTypeName(equipment.getEquType().getEquTypeName());
		
		equTotalCount = equipment.getEquNormalCount() + equipment.getEquReserveCount() +
				equipment.getEquBorrowCount() + equipment.getEquRepairCount() +
				equipment.getEquBrokenCount() + equipment.getEquDiscardCount();
		equipmentVO.setEquTotalCount(equTotalCount);
	}

}
