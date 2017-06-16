package com.xyz.gym_management_sys.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xyz.gym_management_sys.filter.AuthPassport;
import com.xyz.gym_management_sys.service.FieldService;
import com.xyz.gym_management_sys.service.FieldTypeService;
import com.xyz.gym_management_sys.vo.DividePageVO;
import com.xyz.gym_management_sys.vo.FieldTypeVO;
import com.xyz.gym_management_sys.vo.FieldVO;

@Controller
@RequestMapping(value="/fieldClient")
public class FieldClientAction 
{
	@Resource
	private FieldService fieldService;
	@Resource
	private FieldTypeService fieldTypeService;
	
	private FieldVO fieldVO;
	private List<FieldVO> fieldVOs;
	private List<FieldTypeVO> fieldTypeVOs;

	@AuthPassport
	@RequestMapping(value="/findForClient")
	public String findForClient(Integer thisPage,Integer fieldTypeId,Map<String, Object> model)
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
		return "field_query";
	}
}
