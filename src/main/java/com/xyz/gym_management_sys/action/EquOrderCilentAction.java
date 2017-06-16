package com.xyz.gym_management_sys.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xyz.gym_management_sys.filter.AuthPassport;
import com.xyz.gym_management_sys.po.User;
import com.xyz.gym_management_sys.service.EquOrderItemService;
import com.xyz.gym_management_sys.service.EquOrderService;
import com.xyz.gym_management_sys.service.EquipmentService;
import com.xyz.gym_management_sys.vo.CartVO;
import com.xyz.gym_management_sys.vo.DividePageVO;
import com.xyz.gym_management_sys.vo.EquCartDetailVO;
import com.xyz.gym_management_sys.vo.EquOrderItemVO;
import com.xyz.gym_management_sys.vo.EquOrderVO;
import com.xyz.gym_management_sys.vo.SimpleUserVo;

@Controller
@RequestMapping(value="/equOrderClient")
public class EquOrderCilentAction 
{
	@Resource
	private EquipmentService equipmentService;
	@Resource
	private EquOrderService equOrderService;
	@Resource
	private EquOrderItemService equOrderItemService;
	@Resource
	private CartVO cartVO;
	
	private EquOrderVO equOrderVO;
	private List<EquOrderVO> equOrderVOs;
	private List<EquOrderItemVO> equOrderItemVOs;
	private List<EquCartDetailVO> equCartDetailVOs;
	private DividePageVO dividePageVO;

	@AuthPassport
	@RequestMapping(value="findByUserId")
	public String findByUserId(Integer userId,Map<String, Object> model)
	{
		userId = 1;
		equOrderVOs = equOrderService.findEquOrderByUserId(userId);
		model.put("equOrderVOs", equOrderVOs);
		
		return "equ_order_query";
	}

	@AuthPassport
	@RequestMapping(value="pay")
	public String payForOrder(Integer equOrderId,HttpSession session)
	{
		equOrderVO = equOrderService.findEquOrderById(equOrderId);
		equOrderVO.setEquOrderStatement(1);
		equOrderService.mergeEquOrder(equOrderVO);
		User user = (User) session.getAttribute("user");
		return "redirect:/equOrder/findByUserId?user=1";//+user.getUserId();
	}

	@AuthPassport
	@RequestMapping(value="remove")
	public String removeEquOrder(Integer equOrderId,@ModelAttribute("user")SimpleUserVo user)
	{
		equOrderService.removeEquOrder(equOrderId);
		
		return "redirect:/equOrderClient/findByUserId?userId=" + user.getUserId();
	}
}
