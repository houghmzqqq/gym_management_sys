package com.xyz.gym_management_sys.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xyz.gym_management_sys.service.EquipmentService;

@Controller
@RequestMapping(value="/equ")
public class EquFindAction 
{
	@Resource
	private EquipmentService equipmentService;
	
	@RequestMapping(value="/findById")
	public String findEquById()
	{
		
		return null;
	}
	
	@RequestMapping(value="findAll")
	public String findAllEqu()
	{
		equipmentService.findAllEqu();
		System.out.println("SUCCESS!!!");
		return "#";
	}
}
