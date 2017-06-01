package com.xyz.gym_management_sys.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.expression.spel.ast.ValueRef;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.xyz.gym_management_sys.service.EquOrderItemService;
import com.xyz.gym_management_sys.service.EquOrderService;
import com.xyz.gym_management_sys.vo.CartVO;
import com.xyz.gym_management_sys.vo.EquCartDetailVO;
import com.xyz.gym_management_sys.vo.EquOrderItemVO;
import com.xyz.gym_management_sys.vo.EquOrderVO;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/equOrder")
public class EquOrderAction 
{
	@Resource
	private EquOrderService equOrderService;
	@Resource
	private EquOrderItemService equOrderItemService;
	@Resource
	private CartVO cartVO;
	
	private EquOrderVO equOrderVO;
	private List<EquOrderVO> equOrderVOs;
	private List<EquOrderItemVO> equOrderItemVOs;
	
	@RequestMapping(value="add")
	public String addEquOrder(@CookieValue(value="equCartCookie",required=false)String equCartCookieStr,
			HttpServletResponse response,EquOrderVO equOrderVO)
	{
		List<EquCartDetailVO> equCartDetailVOs = new ArrayList<EquCartDetailVO>();
		Map<String, Class> classMap = new HashMap<String, Class>();
		
		//获取cookie中的订单项
		classMap.put("equCartDetailVOs", EquCartDetailVO.class);
		JSONObject jsonObject = JSONObject.fromObject(equCartCookieStr);
		cartVO = (CartVO) JSONObject.toBean(jsonObject, CartVO.class,classMap);
		equCartDetailVOs = cartVO.getEquCartDetailVOs();
		equOrderService.addEquOrder(equOrderVO,equCartDetailVOs);
		
		//清空cookie中的内容
		Cookie cookie = new Cookie("equCartCookie","");
		cookie.setMaxAge(60*60*24*7);
		response.addCookie(cookie);
		
		return null;
	}
	
	@RequestMapping(value="remove")
	public String removeEquOrder(Integer equOrderId)
	{
		equOrderService.removeEquOrder(equOrderId);
		return null;
	}
	
	@RequestMapping(value="update")
	public String updateEquOrder(EquOrderVO equOrderVO)
	{
		equOrderService.updateEquOrder(equOrderVO);
		return null;
	}
	
	@RequestMapping(value="findById")
	public String findById(Integer equOrderId,Map<String, Object> model)
	{
		equOrderVO = equOrderService.findEquOrderById(equOrderId);
		model.put("equOrderVO", equOrderVO);
		return null;
	}

	@RequestMapping(value="findByUserId")
	public String findByUserId(Integer userId,Map<String, Object> model)
	{
		equOrderVOs = equOrderService.findEquOrderByUserId(userId);
		model.put("equOrderVOs", equOrderVOs);
		return null;
	}

	@RequestMapping(value="findAll")
	public String findAllEquOrder(Map<String, Object> model)
	{
//		equOrderVOs = equOrderService.f
		return null;
	}

	@RequestMapping(value="findItem")
	public String findItemByOrderId(Integer equOrderId,Map<String, Object> model)
	{
		equOrderItemVOs = equOrderItemService.findEquOrderItemByEquOrderId(equOrderId);
		model.put("equOrderItemVOs", equOrderItemVOs);
		return null;
	}
}
