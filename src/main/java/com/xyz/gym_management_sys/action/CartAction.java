package com.xyz.gym_management_sys.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyz.gym_management_sys.vo.CartVO;
import com.xyz.gym_management_sys.vo.EquCartDetailVO;
import com.xyz.gym_management_sys.vo.FieldCartDetailVO;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/cart")
public class CartAction 
{
	@Resource
	private CartVO cartVO;
	
	@RequestMapping(value="/addToEquCart")
	@ResponseBody
	public String addToEquCart(@CookieValue(value="equCartCookie",required=false)String equCartCookieStr,
			HttpServletResponse response,EquCartDetailVO equCartRecord,Model model)
	{
		UUID UUIDStr = UUID.randomUUID();
		equCartRecord.setCartRecordId(UUIDStr.toString());//生成唯一标识
		
		if(equCartCookieStr == null)
		{
			cartVO.getEquCartDetailVOs().add(equCartRecord);
		}
		else
		{
			JSONObject jsonCart = JSONObject.fromObject(equCartCookieStr);
			cartVO = (CartVO)JSONObject.toBean(jsonCart, CartVO.class);
			cartVO.getEquCartDetailVOs().add(equCartRecord);
		}
		
		String equCartCookie = JSONObject.fromObject(cartVO).toString();
		Cookie cookie = new Cookie("equCartCookie",equCartCookie);
		cookie.setMaxAge(60*60*24*7);
		response.addCookie(cookie);
		
		model.addAttribute("equCart", cartVO);
		
		return "cart="+cartVO.toString();
	}
	
	//TODO http://localhost:8080/gym_management_sys/cart/removeEquFromCart?cartRecordId=ef4acf24-db44-4d92-b1b3-6279df88016c
	@RequestMapping(value="/removeEquFromCart")
	public String removeEquFromCart(@CookieValue(value="equCartCookie",required=false)String equCartCookieStr,
			HttpServletResponse response,@RequestParam(value="cartRecordId")String cartRecordId,Model model)
	{
		Map<String, Class> classMap = new HashMap<String, Class>();
		classMap.put("equCartDetailVOs", EquCartDetailVO.class);
//		classMap.put("fieldCartDetailVOs", FieldCartDetailVO.class);
		JSONObject jsonObject = JSONObject.fromObject(equCartCookieStr);
		cartVO = (CartVO) JSONObject.toBean(jsonObject, CartVO.class,classMap);
		List<EquCartDetailVO> equCartDetailVOs = cartVO.getEquCartDetailVOs();
		
		EquCartDetailVO equCartVO = new EquCartDetailVO();
		for(EquCartDetailVO equCartDetailVO : equCartDetailVOs)
		{
			if(equCartDetailVO.getCartRecordId().equals(cartRecordId))
			{
				equCartVO = equCartDetailVO;
			}
		}
		cartVO.getEquCartDetailVOs().remove(equCartVO);
		
		
		String equCartCookie = JSONObject.fromObject(cartVO).toString();
		Cookie cookie = new Cookie("equCartCookie",equCartCookie);
		cookie.setMaxAge(60*60*24*7);
		response.addCookie(cookie);
		
		model.addAttribute("equCart", cartVO);
		
		return null;
	}
	
	@RequestMapping(value="/addToFieldCart")
	public String addToFieldCart(@CookieValue(value="fieldCartCookie",required=false)String fieldCartCookieStr,
			HttpServletResponse response,FieldCartDetailVO fieldCartRecord,Model model)
	{
		UUID UUIDStr = UUID.randomUUID();
		fieldCartRecord.setCartRecordId(UUIDStr.toString());//生成唯一标识
		
		if(fieldCartCookieStr == null)
		{
			cartVO.getFieldCartRecordVOS().add(fieldCartRecord);
		}
		else
		{
			JSONObject jsonCart = JSONObject.fromObject(fieldCartCookieStr);
			cartVO = (CartVO)JSONObject.toBean(jsonCart, CartVO.class);
			cartVO.getFieldCartRecordVOS().add(fieldCartRecord);
		}
		
		String fieldCartCookie = JSONObject.fromObject(cartVO).toString();
		Cookie cookie = new Cookie("fieldCartCookie",fieldCartCookie);
		cookie.setMaxAge(60*60*24*7);
		response.addCookie(cookie);
		
		model.addAttribute("fieldCart", cartVO);
		
		return "cart="+cartVO.toString();
	}
	
	public String removeFieldFromCart(@CookieValue(value="fieldCartCookie",required=false)String fieldCartCookieStr,
			HttpServletResponse response,String cartRecordId,Model model)
	{
		Map<String, Class> classMap = new HashMap<String, Class>();
//		classMap.put("equCartDetailVOs", EquCartDetailVO.class);
		classMap.put("fieldCartDetailVOs", FieldCartDetailVO.class);
		JSONObject jsonObject = JSONObject.fromObject(fieldCartCookieStr);
		cartVO = (CartVO) JSONObject.toBean(jsonObject, CartVO.class,classMap);
		List<FieldCartDetailVO> fieldCartDetailVOs = cartVO.getFieldCartRecordVOS();
		
		FieldCartDetailVO fieldCartVO = new FieldCartDetailVO();
		for(FieldCartDetailVO fieldCartDetailVO : fieldCartDetailVOs)
		{
			if(fieldCartDetailVO.getCartRecordId().equals(cartRecordId))
			{
				fieldCartVO = fieldCartDetailVO;
			}
		}
		cartVO.getEquCartDetailVOs().remove(fieldCartVO);
		
		
		String fieldCartCookie = JSONObject.fromObject(cartVO).toString();
		Cookie cookie = new Cookie("fieldCartCookie",fieldCartCookie);
		cookie.setMaxAge(60*60*24*7);
		response.addCookie(cookie);
		
		model.addAttribute("fieldCart", cartVO);
		
		return null;
	}
}
