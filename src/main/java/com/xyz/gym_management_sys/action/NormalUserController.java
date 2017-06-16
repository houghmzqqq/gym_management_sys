package com.xyz.gym_management_sys.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xyz.gym_management_sys.filter.AuthPassport;
import com.xyz.gym_management_sys.service.RoleService;
import com.xyz.gym_management_sys.service.UserService;
import com.xyz.gym_management_sys.vo.AddAdminVo;
import com.xyz.gym_management_sys.vo.SignUpVo;
import com.xyz.gym_management_sys.vo.SimpleUserVo;
import com.xyz.gym_management_sys.vo.UserAllInfoVo;
import com.xyz.gym_management_sys.vo.UserInfoVo;


@Controller
@RequestMapping("/user")
public class NormalUserController {
	
	@Resource
	private UserService userService;
	
	@Resource
	private RoleService roleService;
	
	@Autowired
	private HttpServletRequest request;
	
	@AuthPassport
	@RequestMapping("/index")
	public String GoUserIndex(Model model){
		
		
		model.addAttribute("user", (SimpleUserVo)request.getSession().getAttribute("user"));
		
		return "../../index";
	}
	
	@AuthPassport
	@RequestMapping("/personalDeatil")
	public String GoPersonalDetail(Model model){
		
		if(request.getSession().getAttribute("role").equals("普通用户")){
			SimpleUserVo simpleUser = (SimpleUserVo) request.getSession().getAttribute("user");
			
			UserAllInfoVo userInfo = userService.getUserInfoForPersonalUser(simpleUser.getUserName());
			
			
			model.addAttribute("userInfo", userInfo);
			
			return "personalDetail";
		}
		
		return "redirect:/login/user";
	}
	
	@RequestMapping("/signUp")
	public String GoSignUpPage(Model model){
		
		
		return "signUp";
	}
	
	@RequestMapping(value="/doSignUp" , method=RequestMethod.POST)
	public String DoSignUp(@ModelAttribute SignUpVo signUpInfo , Model model){
		

		System.out.println(signUpInfo.getComfirmPsw()+"---"+signUpInfo.getPassword());
		
		String result = userService.registerNewUser(signUpInfo);
		if(!"注册成功".equals(result)){
			
			model.addAttribute("wrongMsg", result);
			return "redirect:signUp";
		}
		
		return "redirect:/login/user";
	}
}
