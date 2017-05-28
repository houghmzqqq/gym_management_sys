package com.xyz.gym_management_sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.xyz.gym_management_sys.dao.EquTypeDao;
import com.xyz.gym_management_sys.dao.EquipmentDao;
import com.xyz.gym_management_sys.po.EquType;
import com.xyz.gym_management_sys.po.Equipment;
import com.xyz.gym_management_sys.service.EquTypeService;
import com.xyz.gym_management_sys.vo.EquTypeVO;

@Service
public class EquTypeServiceImpl implements EquTypeService {

	@Resource
	private EquTypeDao equTypeDao;
	@Resource
	private EquipmentDao equipmentDao;
	@Resource
	private DozerBeanMapper mapper;
	
	private EquType equType;
	private EquTypeVO equTypeVO;
	private List<EquType> equTypes;
	private List<EquTypeVO> equTypeVOs;
	
	public void addEquType(EquTypeVO equTypeVO) {
		// TODO Auto-generated method stub
		
		equType = mapper.map(equTypeVO, EquType.class);
		equTypeDao.addEquType(equType);
	}

	public void removeEquType(int equTypeId) {
		// TODO Auto-generated method stub

		equType = equTypeDao.getEquTypeById(equTypeId);
		
		//所有与该器材类型匹配的器材，将其器材类型外键设为null
		List<Equipment> equipments = equipmentDao.getEquipmentsByEquType(equType);
		for(Equipment equipment : equipments)
		{
			equipment.setEquType(null);
			equipmentDao.mergeEquipment(equipment);
		}
		
		equTypeDao.deleteEquType(equType);
	}

	public void updateEquType(EquTypeVO equTypeVO) {
		// TODO Auto-generated method stub

		equType = mapper.map(equTypeVO, EquType.class);
		equTypeDao.updateEquType(equType);
	}

	public EquTypeVO findById(int equTypeId) {
		// TODO Auto-generated method stub
		
		equType = equTypeDao.getEquTypeById(equTypeId);
		return mapper.map(equType, EquTypeVO.class);
	}

	public List<EquTypeVO> findAllEquType() {
		// TODO Auto-generated method stub
		
		equTypeVOs = new ArrayList<EquTypeVO>();
		equTypes = equTypeDao.getAllEquType();
		for(EquType  equType :  equTypes)
		{
			equTypeVO = mapper.map(equType, EquTypeVO.class);
			equTypeVOs.add(equTypeVO);
		}
		return equTypeVOs;
	}

}
