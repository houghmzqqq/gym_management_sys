package com.xyz.gym_management_sys.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xyz.gym_management_sys.filter.AuthEquVali;
import com.xyz.gym_management_sys.service.EquTypeService;
import com.xyz.gym_management_sys.service.EquipmentService;
import com.xyz.gym_management_sys.vo.DividePageVO;
import com.xyz.gym_management_sys.vo.EquTypeVO;
import com.xyz.gym_management_sys.vo.EquipmentVO;

@Controller
@RequestMapping(value="/equ")
public class EquAction 
{
	@Resource
	private EquipmentService equipmentService;
	@Resource
	private EquTypeService equTypeService;
	
	private EquipmentVO equipmentVO;
	private List<EquipmentVO> equipmentVOs;
	private EquTypeVO equTypeVO;
	private List<EquTypeVO> equTypeVOs;

	@AuthEquVali
	@RequestMapping(value="/add")
	public String addEqu(EquipmentVO equipmentVO,Map<String, Object> model)
	{
		equipmentService.addEqu(equipmentVO);
		return "redirect:/equ/findByTypeId?equTypeId=" + 0 + "&thisPage=" + 1;
	}

	@AuthEquVali
	@RequestMapping(value="/remove")
	public String removeEqu(Integer equId,RedirectAttributes attr)
	{
		equipmentService.removeEqu(equId);
		return "redirect:/equ/findByTypeId?equTypeId=" + 0 + "&thisPage=" + 1;
	}

	@AuthEquVali
	@RequestMapping(value="/update")
	public String updateEqu(EquipmentVO equipmentVO)
	{
		equipmentService.updateEqu(equipmentVO);
		return "redirect:/equ/findByTypeId?equTypeId=" + 0 + "&thisPage=" + 1;
	}

	@AuthEquVali
	@RequestMapping(value="/findByTypeId")
	public String findEquByTypeId(@RequestParam("equTypeId")Integer equTypeId,
			@RequestParam(value="thisPage")Integer thisPage,Map<String, Object> model)
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
		return "equ_management";
	}

	@AuthEquVali
	@RequestMapping(value="/turnToUpdate")
	public String turnToUpdatePage(Integer equId,Map<String, Object> model)
	{
		equipmentVO = equipmentService.findEquById(equId);
		equTypeVOs = equTypeService.findAllEquType();
		model.put("equipmentVO", equipmentVO);
		model.put("equTypeVOs", equTypeVOs);
		return "equ_update";
	}

	@AuthEquVali
	@RequestMapping(value="turnToAdd")
	public String turnToAddPage(Model model)
	{
		equTypeVOs = equTypeService.findAllEquType();
		model.addAttribute("equTypeVOs", equTypeVOs);
		return "equ_add";
	}
	
}
