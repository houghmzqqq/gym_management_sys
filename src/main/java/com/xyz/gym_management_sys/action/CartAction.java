package com.xyz.gym_management_sys.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.persistence.NamedNativeQueries;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xyz.gym_management_sys.service.EquOrderService;
import com.xyz.gym_management_sys.service.EquipmentService;
import com.xyz.gym_management_sys.vo.CartVO;
import com.xyz.gym_management_sys.vo.EquCartDetailVO;
import com.xyz.gym_management_sys.vo.EquOrderItemVO;
import com.xyz.gym_management_sys.vo.EquipmentVO;
import com.xyz.gym_management_sys.vo.FieldCartDetailVO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/cart")
public class CartAction 
{
	@Resource
	private CartVO cartVO;
	@Resource
	private EquipmentService equipmentService;
	@Resource
	private EquOrderService equOrderService;

	private EquipmentVO equipmentVO;
	private List<EquipmentVO> equipmentVOs;
	private EquOrderItemVO equOrderItemVO;
	private List<EquOrderItemVO> equOrderItemVOs;
	private CartVO cartVO2;
	private EquCartDetailVO equCartDetailVO;
	private List<EquCartDetailVO> equCartDetailVOs;
	
	@RequestMapping(value="/addToEquCart")
	public String addToEquCart(@CookieValue(value="equCartCookie",required=false)String equCartCookieStr,
			HttpServletResponse response,EquCartDetailVO equCartRecord,Model model)
	{
		equCartDetailVOs = new ArrayList<EquCartDetailVO>();
		UUID UUIDStr = UUID.randomUUID();
		equCartRecord.setCartRecordId(UUIDStr.toString());//生成唯一标识
		
		if(equCartCookieStr == null || equCartCookieStr.equals(""))
		{
			equCartDetailVOs.add(equCartRecord);
		}
		else
		{
			JSONArray jsonArray = JSONArray.fromObject(equCartCookieStr);
			equCartDetailVOs = (List<EquCartDetailVO>) JSONArray.toCollection(jsonArray, EquCartDetailVO.class);
			equCartDetailVOs.add(equCartRecord);
		}
		
		String equCartCookie = JSONArray.fromObject(equCartDetailVOs).toString();
		Cookie cookie = new Cookie("equCartCookie",equCartCookie);
		cookie.setMaxAge(60*60*24*7);
		response.addCookie(cookie);
		
		model.addAttribute("equCartDetailVOs", equCartDetailVOs);
		
		return "redirect:/equ/findForClient?equTypeId=" + 0 + "&thisPage=" + 1;
	}
	
	//TODO http://localhost:8080/gym_management_sys/cart/removeEquFromCart?cartRecordId=ef4acf24-db44-4d92-b1b3-6279df88016c
	@RequestMapping(value="/removeEquFromCart")
	public String removeEquFromCart(@CookieValue(value="equCartCookie",required=false)String equCartCookieStr,
			HttpServletResponse response,@RequestParam(value="cartRecordId")String cartRecordId,Model model)
	{
		equCartDetailVOs = new ArrayList<EquCartDetailVO>();
		JSONArray jsonArray = JSONArray.fromObject(equCartCookieStr);
		equCartDetailVOs = (List<EquCartDetailVO>) JSONArray.toCollection(jsonArray, EquCartDetailVO.class);
		
		EquCartDetailVO equCartVO = new EquCartDetailVO();
		for(EquCartDetailVO equCartDetailVO : equCartDetailVOs)
		{
			if(equCartDetailVO.getCartRecordId().equals(cartRecordId))
			{
				equCartVO = equCartDetailVO;
			}
		}
		equCartDetailVOs.remove(equCartVO);
		
		
		String equCartCookie = JSONArray.fromObject(equCartDetailVOs).toString();
		Cookie cookie = new Cookie("equCartCookie",equCartCookie);
		cookie.setMaxAge(60*60*24*7);
		response.addCookie(cookie);
		
		model.addAttribute("equCartDetailVOs", equCartDetailVOs);
		
		return "redirect:/cart/listEqu";
	}

	@RequestMapping(value="/clearEquCart")
	public String clearEquCart(@CookieValue(value="equCartCookie",required=false)String equCartCookieStr,
			HttpServletResponse response,Model model)
	{
		equCartDetailVOs = new ArrayList<EquCartDetailVO>();
		if(equCartCookieStr != null && !equCartCookieStr.equals(""))
		{
			JSONArray jsonArray = JSONArray.fromObject(equCartCookieStr.toString());
			equCartDetailVOs = (List<EquCartDetailVO>) JSONArray.toCollection(jsonArray, EquCartDetailVO.class);
			
			String equCartCookie = JSONArray.fromObject(equCartDetailVOs).toString();
			Cookie cookie = new Cookie("equCartCookie","");
			cookie.setMaxAge(60*60*24*7);
			response.addCookie(cookie);
		}
		
		return "redirect:/cart/listEqu";
	}
	
	@RequestMapping(value="listEqu")
	public String listEquCart(@CookieValue(value="equCartCookie",required=false)String equCartCookieStr,Model model)
	{
		equOrderItemVOs = new ArrayList<EquOrderItemVO>();
		float allSum = 0 ,allDeposit = 0;
		
		if (equCartCookieStr != null && !equCartCookieStr.equals("")) 
		{
			//获取订单项列表
			equCartDetailVOs = new ArrayList<EquCartDetailVO>();
			JSONArray jsonArray = JSONArray.fromObject(equCartCookieStr);
			equCartDetailVOs = (List<EquCartDetailVO>) JSONArray.toCollection(jsonArray, EquCartDetailVO.class);
			for (EquCartDetailVO equCartDetailVO : equCartDetailVOs) {
				equipmentVO = equipmentService.findEquById(equCartDetailVO.getEquId());
				equOrderItemVO = new EquOrderItemVO();
				equOrderItemVO.setEquId(equipmentVO.getEquId());
				equOrderItemVO.setEquName(equipmentVO.getEquName());
				equOrderItemVO.setEquCount(equCartDetailVO.getEquCount());
				equOrderItemVO.setItemSum(equCartDetailVO.getEquCount() * equipmentVO.getEquBorrowUnitvaluent());
				equOrderItemVO.setItemDeposit(equCartDetailVO.getEquCount() * equipmentVO.getEquDeposit());
				equOrderItemVOs.add(equOrderItemVO);

				allSum += equOrderItemVO.getItemSum();
				allDeposit += equOrderItemVO.getItemDeposit();
			}
			model.addAttribute("equOrderItemVOs", equOrderItemVOs);
			model.addAttribute("equCartDetailVOs", equCartDetailVOs);
			model.addAttribute("allSum", allSum);
			model.addAttribute("allDeposit", allDeposit);
		}
		return "equ_item_list";
	}
	
	@RequestMapping(value="addEquOrder")
	public String addEquOrder(@CookieValue(value="equCartCookie",required=false)String equCartCookieStr,
			HttpServletResponse response)
	{
		
		//获取cookie中的订单项
		equCartDetailVOs = new ArrayList<EquCartDetailVO>();
		System.out.println(equCartCookieStr);
		JSONArray jsonArray = JSONArray.fromObject(equCartCookieStr);
		equCartDetailVOs = (List<EquCartDetailVO>) JSONArray.toCollection(jsonArray, EquCartDetailVO.class);
		
		equOrderService.addEquOrder(equCartDetailVOs);
		
		//清空cookie中的内容
		Cookie cookie = new Cookie("equCartCookie","");
		cookie.setMaxAge(60*60*24*7);
		response.addCookie(cookie);
		
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
