package com.xyz.gym_management_sys.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xyz.gym_management_sys.filter.AuthPassport;
import com.xyz.gym_management_sys.service.EquTypeService;
import com.xyz.gym_management_sys.service.EquipmentService;
import com.xyz.gym_management_sys.vo.DividePageVO;
import com.xyz.gym_management_sys.vo.EquTypeVO;
import com.xyz.gym_management_sys.vo.EquipmentVO;

@Controller
@RequestMapping(value="equClient")
public class EquClientAction 
{
	@Resource
	private EquipmentService equipmentService;
	@Resource
	private EquTypeService equTypeService;
	
	private EquipmentVO equipmentVO;
	private List<EquipmentVO> equipmentVOs;
	private EquTypeVO equTypeVO;
	private List<EquTypeVO> equTypeVOs;
	
	@AuthPassport
	@RequestMapping(value="/findForClient")
	public String findForClient(Integer thisPage,Integer equTypeId,Map<String, Object> model)
	{
		DividePageVO dividePageVO;
		if(equTypeId == 0)
		{
			dividePageVO = equipmentService.dividePageOfEqu(thisPage, 5);
			equipmentVOs = dividePageVO.getEquipmentVOs();
		}
		else
		{
			dividePageVO = equipmentService.dividePageOfEquByTypeId(thisPage, 5, equTypeId);
			equipmentVOs = dividePageVO.getEquipmentVOs();
		}
		equTypeVOs = equTypeService.findAllEquType();
		
		model.put("dividePage",dividePageVO);
		model.put("equTypeVOs", equTypeVOs);
		model.put("equipmentVOs", equipmentVOs);
		model.put("equTypeId",equTypeId);
		return "equ_query";
	}
}
