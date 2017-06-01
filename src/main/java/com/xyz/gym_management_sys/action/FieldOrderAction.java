package com.xyz.gym_management_sys.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.spi.ResultSetReturn;
import org.junit.validator.PublicClassValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.xyz.gym_management_sys.service.FieldOrderItemService;
import com.xyz.gym_management_sys.service.FieldOrderService;
import com.xyz.gym_management_sys.vo.CartVO;
import com.xyz.gym_management_sys.vo.FieldCartDetailVO;
import com.xyz.gym_management_sys.vo.FieldOrderItemVO;
import com.xyz.gym_management_sys.vo.FieldOrderVO;
import com.xyz.gym_management_sys.vo.FieldVO;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/fieldOrder")
public class FieldOrderAction 
{
	@Resource
	private FieldOrderService fieldOrderService;
	@Resource
	private FieldOrderItemService fieldOrderItemService;
	@Resource
	private CartVO cartVO;
	
	private FieldOrderVO fieldOrderVO;
	private List<FieldOrderVO> fieldOrderVOs;
	private List<FieldOrderItemVO> fieldOrderItemVOs;

	@RequestMapping(value="add")
	public String addFieldOrder(@CookieValue(value="fieldCartCookie",required=false)String fieldCartCookieStr,
			HttpServletResponse response,FieldOrderVO fieldOrderVO)
	{
		Map<String, Class> classMap = new HashMap<String, Class>();
		
		//获取cookie中的项
		classMap.put("fieldCartDetailVOs", FieldCartDetailVO.class);
		JSONObject jsonObject = JSONObject.fromObject(fieldCartCookieStr);
		cartVO = (CartVO) JSONObject.toBean(jsonObject, CartVO.class,classMap);
		List<FieldCartDetailVO> fieldCartDetailVOs = cartVO.getFieldCartRecordVOS();
		fieldOrderService.addFieldOrder(fieldOrderVO, fieldCartDetailVOs);
		
		//清空cookie中的内容
		Cookie cookie = new Cookie("fieldCartCookie","");
		cookie.setMaxAge(60*60*24*7);
		response.addCookie(cookie);
		
		return null;
	}
	
	@RequestMapping(value="remove")
	public String removeFieldOrder(@RequestParam(value="fieldOrderId")Integer fieldOrderId)
	{
		fieldOrderService.removeFieldOrder(fieldOrderId);
		return null;
	}

	@RequestMapping(value="update")
	public String updateFieldOrder(FieldOrderVO fieldOrderVO)
	{
		fieldOrderService.updateFieldOrder(fieldOrderVO);
		return null;
	}

	@RequestMapping(value="findById")
	public String findById(@RequestParam(value="fieldOrderId")Integer fieldOrderId,Model model)
	{
		fieldOrderVO = fieldOrderService.findFieldOrderById(fieldOrderId);
		model.addAttribute("fieldOrderVO", fieldOrderVO);
		return null;
	}
	
	@RequestMapping(value="findByUserId")
	public String findByUserId(Integer userId,Model model)
	{
		fieldOrderVOs = fieldOrderService.findFieldOrderByUserId(userId);
		model.addAttribute("fieldOrderVOs", fieldOrderVOs);
		return null;
	}

	@RequestMapping(value="findAll")
	public String findAllField(Model model)
	{
		fieldOrderVOs = fieldOrderService.findAllFieldOrder();
		model.addAttribute("fieldOrderVOs", fieldOrderVOs);
		return null;
	}

	@RequestMapping(value="findItem")
	public String findItemByOrderId(Integer fieldOrderId,Model model)
	{
		fieldOrderItemVOs = fieldOrderItemService.findFieldOrderItemByFieldOrderId(fieldOrderId);
		model.addAttribute("fieldOrderItemVOs", fieldOrderItemVOs);
		return null;
	}
	
}
