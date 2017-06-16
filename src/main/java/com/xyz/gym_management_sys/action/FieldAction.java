package com.xyz.gym_management_sys.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xyz.gym_management_sys.filter.AuthEquVali;
import com.xyz.gym_management_sys.filter.AuthFieldVali;
import com.xyz.gym_management_sys.po.FieldType;
import com.xyz.gym_management_sys.service.FieldService;
import com.xyz.gym_management_sys.service.FieldTypeService;
import com.xyz.gym_management_sys.vo.DividePageVO;
import com.xyz.gym_management_sys.vo.FieldTypeVO;
import com.xyz.gym_management_sys.vo.FieldVO;

@Controller
@RequestMapping(value="/field")
public class FieldAction
{
	@Resource
	private FieldService fieldService;
	@Resource
	private FieldTypeService fieldTypeService;
	
	private FieldVO fieldVO;
	private List<FieldVO> fieldVOs;
	private List<FieldTypeVO> fieldTypeVOs;

	@AuthFieldVali
	@RequestMapping(value="add")
	public String addField(FieldVO fieldVO)
	{
		fieldService.addField(fieldVO);
		return "redirect:/field/findByTypeId?thisPage=1&fieldTypeId=0";
	}

	@AuthFieldVali
	@RequestMapping(value="remove")
	public String removeField(int fieldId)
	{
		fieldService.removeField(fieldId);
		
		return "redirect:/field/findByTypeId?thisPage=1&fieldTypeId=0";
	}

	@AuthFieldVali
	@RequestMapping(value="update")
	public String updateField(FieldVO fieldVO)
	{
		fieldService.updateField(fieldVO);
		return "redirect:/field/findByTypeId?thisPage=1&fieldTypeId=0";
	}

	@AuthFieldVali
	@RequestMapping(value="findById")
	public String findFieldById(@RequestParam(value="fieldId")Integer fieldId,Model model)
	{
		fieldVO = fieldService.findFieldById(fieldId);
		model.addAttribute("fieldVO", fieldVO);
		return null;
	}

	@AuthFieldVali
	@RequestMapping(value="findAll")
	public String findAllField(Model model)
	{
		fieldVOs = fieldService.findAllField();
		model.addAttribute("fieldVOs", fieldVOs);
		return null;
	}

	@AuthFieldVali
	@RequestMapping(value="/findByTypeId")
	public String findEquByTypeId(@RequestParam("fieldTypeId")Integer fieldTypeId,
			@RequestParam(value="thisPage")Integer thisPage,Map<String, Object> model)
	{
		DividePageVO dividePageVO;
		if(fieldTypeId == 0)
		{
			dividePageVO = fieldService.dividePageOfField(thisPage, 5);
			fieldVOs = dividePageVO.getFieldVOs();
		}
		else
		{
			dividePageVO = fieldService.dividePageOfFieldByTypeId(thisPage, 5, fieldTypeId);
			fieldVOs = dividePageVO.getFieldVOs();
		}
		fieldTypeVOs = fieldTypeService.findAllFieldType();
		
		model.put("dividePage",dividePageVO);
		model.put("fieldTypeVOs", fieldTypeVOs);
		model.put("fieldVOs", fieldVOs);
		model.put("fieldTypeId",fieldTypeId);
		return "field_management";
	}

	@AuthFieldVali
	@RequestMapping(value="turnToAdd")
	public String turnToAdd(Model model)
	{
		fieldTypeVOs = fieldTypeService.findAllFieldType();
		model.addAttribute("fieldTypeVOs", fieldTypeVOs);
		
		return "field_add";
	}

	@AuthFieldVali
	@RequestMapping(value="turnToUpdate")
	public String turnToUpdate(Integer fieldId,Model model)
	{
		fieldVO = fieldService.findFieldById(fieldId);
		fieldTypeVOs = fieldTypeService.findAllFieldType();
		model.addAttribute("fieldVO", fieldVO);
		model.addAttribute("fieldTypeVOs", fieldTypeVOs);
		
		return "field_update";
	}
}
