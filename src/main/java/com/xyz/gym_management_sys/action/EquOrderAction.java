package com.xyz.gym_management_sys.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.xyz.gym_management_sys.po.EquOrderItem;
import com.xyz.gym_management_sys.po.Equipment;
import com.xyz.gym_management_sys.service.EquOrderItemService;
import com.xyz.gym_management_sys.service.EquOrderService;
import com.xyz.gym_management_sys.service.EquipmentService;
import com.xyz.gym_management_sys.vo.CartVO;
import com.xyz.gym_management_sys.vo.DividePageVO;
import com.xyz.gym_management_sys.vo.EquCartDetailVO;
import com.xyz.gym_management_sys.vo.EquOrderItemVO;
import com.xyz.gym_management_sys.vo.EquOrderVO;
import com.xyz.gym_management_sys.vo.EquipmentVO;


@Controller
@RequestMapping(value="/equOrder")
public class EquOrderAction 
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
	
	
	@RequestMapping(value="remove")
	public String removeEquOrder(Integer equOrderId)
	{
		equOrderService.removeEquOrder(equOrderId);
		return "redirect:/equOrder/findAll?thisPage=" + 1;
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateEquOrder(EquOrderVO equOrderVO,String borrowDate,String returnDate)
	{
		if(borrowDate != null && !borrowDate.equals(""))
		{
			equOrderVO.setEquBorrowDate(null);
		}
		if (returnDate != null && !returnDate.equals("")) 
		{
			equOrderVO.setEquReturnDate(null);
		}
		equOrderService.updateEquOrder(equOrderVO);
		return "redirect:/equOrder/findAll?thisPage=" + 1;
	}
	
	@RequestMapping(value="updateItem")
	public String updateEquOrderItem(EquOrderItemVO equOrderItemVO)
	{
		//更新订单项中的信息
		EquipmentVO equipmentVO = equipmentService.findEquById(equOrderItemVO.getEquId());
		equOrderItemVO.setEquCompensation(equipmentVO.getEquValue()*equOrderItemVO.getEquBreakCount());
		equOrderItemService.updateEquOrderItem(equOrderItemVO);
		//更新订单中的信息

		float compensation = 0, sum = 0, deposit = 0;
		equOrderVO = equOrderService.findEquOrderById(equOrderItemVO.getEquOrderId());
		equOrderItemVOs = equOrderItemService.findEquOrderItemByEquOrderId(equOrderItemVO.getEquOrderId());
		for(EquOrderItemVO equOrderItem : equOrderItemVOs)
		{
			compensation += equOrderItem.getEquCompensation();
			sum += equOrderItem.getItemSum();
			deposit += equOrderItem.getItemDeposit();
		}
		equOrderVO.setEquTotalCompensation(compensation);
		equOrderVO.setEquOrderSum(sum);
		equOrderVO.setEquTotalDeposit(deposit);
		equOrderService.updateEquOrder(equOrderVO);
		
		return "redirect:/equOrder/turnToItem?equOrderId=" + equOrderItemVO.getEquOrderId();
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
	public String findAllEquOrder(Integer thisPage,Map<String, Object> model)
	{
		dividePageVO = equOrderService.dividePageOfEquOrder(thisPage, 5);
		equOrderVOs = dividePageVO.getEquOrderVOs();
		
		model.put("dividePage", dividePageVO);
		model.put("equOrderVOs", equOrderVOs);
		
		return "equ_order_management";
	}

	@RequestMapping(value="findItem")
	public String findItemByOrderId(Integer equOrderId,Map<String, Object> model)
	{
		equOrderItemVOs = equOrderItemService.findEquOrderItemByEquOrderId(equOrderId);
		model.put("equOrderItemVOs", equOrderItemVOs);
		return null;
	}
	
	@RequestMapping(value="turnToUpdate")
	public String turnToUpdate(Integer equOrderId,Model model)
	{
		equOrderVO = equOrderService.findEquOrderById(equOrderId);
		model.addAttribute("equOrderVO", equOrderVO);
		
		return "equ_order_update";
	}
	
	@RequestMapping(value="turnToItem")
	public String turnToOrderItem(Integer equOrderId,Model model)
	{
		equOrderItemVOs = equOrderItemService.findEquOrderItemByEquOrderId(equOrderId);
		model.addAttribute("equOrderItemVOs", equOrderItemVOs);
		
		return "equ_item_management";
	}
	
	@RequestMapping(value="turnToItemUpdate")
	public String turnToItemUpdate(Integer equOrderItemId,Model model)
	{
		EquOrderItemVO equOrderItemVO = equOrderItemService.findEquOrderItemById(equOrderItemId);
		model.addAttribute("equOrderItemVO", equOrderItemVO);
		
		return "equ_item_update";
	}
}
