package com.xyz.gym_management_sys.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xyz.gym_management_sys.service.AdminService;
import com.xyz.gym_management_sys.service.UserService;
import com.xyz.gym_management_sys.vo.AdminVo;
import com.xyz.gym_management_sys.vo.LoginVo;
import com.xyz.gym_management_sys.vo.SimpleUserVo;



@Controller
@RequestMapping("/login")
public class LoginController {

	@Resource
	private AdminService adminService;
	
	@Resource
	private UserService userService;
	
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping("/admin")
	public String Login(){
		return "adminLogin";
	}
	
	@RequestMapping("/user")
	public String UserLogin(){
		
		return "userLogin";
	}
	
	@RequestMapping(value = "/adminLogin" ,method=RequestMethod.POST)
	public String DoLogin(@ModelAttribute LoginVo loginVo,Model model){
		AdminVo currUser = new AdminVo();
		
		if(request.getSession().getAttribute("user")!=null){
			//如果session中已经存在一个管理员账户，移除它
			request.getSession().removeAttribute("user");
		}

		try {
			currUser=adminService.adminLogin(loginVo);  //登陆
			
			if(currUser.getAdminName() == null){
				//为空，则表示用户名或密码错误，返回管理员登录页
				String wrongMsg = "用户名或密码错误";
				model.addAttribute("wrongMsg", wrongMsg);
				
				return "adminLogin";
			}
		} catch (Exception e) {
			e.printStackTrace();			
			//出现异常，登陆失败，返回登录页
			return "adminLogin";
		}
		
		//登陆成功
		request.getSession().setAttribute("user", currUser);
		request.getSession().setAttribute("role", currUser.getRoleName());
		model.addAttribute("user", currUser);
		
		if(currUser.getRoleName().equals("超级管理员"))
		{
			return "redirect:/userManage/index";
		}
		else if(currUser.getRoleName().equals("器材管理员"))
		{
			return "redirect:/equ/findByTypeId?thisPage=1&equTypeId=0";
		}
		else if(currUser.getRoleName().equals("场地管理员"))
		{
			return "redirect:/field/findByTypeId?thisPage=1&fieldTypeId=0";
		}
		return "adminLogin";
	}
	
	@RequestMapping(value = "/userLogin" ,method=RequestMethod.POST)
	public String DoLoginForUser(@ModelAttribute LoginVo loginVo, Model model){
		SimpleUserVo currUser = new SimpleUserVo();
		
		if(request.getSession().getAttribute("user")!=null){
			//如果session中已经存在一个账户，移除它
			request.getSession().removeAttribute("user");
		}
		
		try {
			currUser=userService.userLogin(loginVo);  //登陆
			
			System.out.println("前面的currUser是："+loginVo.getUserName());
			
			if(currUser.getUserName() == null){
				//为空，则表示用户名或密码错误，返回管理员登录页
				String wrongMsg = "用户名或密码错误";
				model.addAttribute("wrongMsg", wrongMsg);
				
				return "userLogin";
			}
			
			//登陆成功
			request.getSession().setAttribute("user", currUser);
			request.getSession().setAttribute("role", currUser.getUserRole());
			model.addAttribute("user", currUser);
			
			System.out.println("currUser是："+currUser.getName());
			System.out.println("登陆成功");
			
			return "../../index";
		} catch (Exception e) {
			e.printStackTrace();			
			//出现异常，登陆失败，返回登录页
			return "userLogin";
		}
	}
	
	@RequestMapping("/logout")
	public String Logout(){
		//将session中的user对象删除
		if(request.getSession().getAttribute("user")!=null){
			
			String role = (String) request.getSession().getAttribute("role");
			if(role.equals("普通用户")){
				request.getSession().removeAttribute("user");
				return "redirect:user";
			}
			request.getSession().removeAttribute("user");
		}
		//返回登陆页面
		return "redirect:admin";
	}

}
