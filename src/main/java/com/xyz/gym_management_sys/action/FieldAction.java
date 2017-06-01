package com.xyz.gym_management_sys.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xyz.gym_management_sys.service.FieldService;
import com.xyz.gym_management_sys.vo.FieldVO;

@Controller
@RequestMapping(value="/field")
public class FieldAction
{
	@Resource
	private FieldService fieldService;
	
	private FieldVO fieldVO;
	private List<FieldVO> fieldVOs;
	
	@RequestMapping(value="add")
	public String addField(FieldVO fieldVO)
	{
		fieldService.addField(fieldVO);
		return null;
	}

	@RequestMapping(value="remove")
	public String removeField(int fieldId)
	{
		fieldService.removeField(fieldId);
		return null;
	}

	@RequestMapping(value="update")
	public String updateField(FieldVO fieldVO)
	{
		fieldService.updateField(fieldVO);
		return null;
	}

	@RequestMapping(value="findById")
	public String findFieldById(@RequestParam(value="fieldId")Integer fieldId,Model model)
	{
		fieldVO = fieldService.findFieldById(fieldId);
		model.addAttribute("fieldVO", fieldVO);
		return null;
	}

	@RequestMapping(value="findByTypeId")
	public String findByTypeId(@RequestParam(value="fieldTypeId")Integer fieldTypeId,Model model)
	{
		fieldVOs = fieldService.findFieldByFieldTypeId(fieldTypeId);
		model.addAttribute("fieldVOs", fieldVOs);
		return null;
	}
	
	@RequestMapping(value="findAll")
	public String findAllField(Model model)
	{
		fieldVOs = fieldService.findAllField();
		model.addAttribute("fieldVOs", fieldVOs);
		return null;
	}
}
