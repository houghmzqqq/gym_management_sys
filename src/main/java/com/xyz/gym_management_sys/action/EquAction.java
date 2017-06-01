package com.xyz.gym_management_sys.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyz.gym_management_sys.service.EquipmentService;
import com.xyz.gym_management_sys.vo.EquipmentVO;

@Controller
@RequestMapping(value="/equ")
public class EquAction 
{
	@Resource
	private EquipmentService equipmentService;
	@Resource
	private SessionFactory sessionFactory;
	
	private EquipmentVO equipmentVO;
	private List<EquipmentVO> equipmentVOs;
	
	@RequestMapping(value="/add")
	public String addEqu(EquipmentVO equipmentVO,Map<String, Object> model)
	{
		equipmentService.addEqu(equipmentVO);
		return null;
	}

	@RequestMapping(value="/remove")
	public String removeEqu(Integer equId)
	{
		equipmentService.removeEqu(equId);
		return null;
	}
	
	@RequestMapping(value="/update")
	public String updateEqu(EquipmentVO equipmentVO)
	{
		equipmentService.updateEqu(equipmentVO);
		return null;
	}
	
	@RequestMapping(value="/findByTypeId")
	public String findEquByTypeId(@RequestParam("equTypeId")Integer equTypeId,Map<String, Object> model)
	{
		equipmentVOs = equipmentService.findEquByEquTypeId(equTypeId);
		for(EquipmentVO equipmentVO : equipmentVOs)
		{
			System.out.println(equipmentVO);
		}
		model.put("equipmentVOs", equipmentVOs);
		return "listEqu";
	}
	
	
	@RequestMapping(value="/findAll")
	public String findAllEqu(Map<String, Object> model)
	{
		equipmentVOs = equipmentService.findAllEqu();
		model.put("equipmentVOs", equipmentVOs);
		return "listEqu";
	}
	
	@RequestMapping(value="/findById")
	public String findEquById(Integer equId,Map<String, Object> model)
	{
		equipmentVO = equipmentService.findEquById(equId);
		model.put("equipmentVO", equipmentVO);
		return null;
	}
}
