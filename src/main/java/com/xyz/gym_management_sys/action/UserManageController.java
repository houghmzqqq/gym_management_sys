package com.xyz.gym_management_sys.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xyz.gym_management_sys.filter.AuthEquVali;
import com.xyz.gym_management_sys.filter.AuthPassport;
import com.xyz.gym_management_sys.filter.AuthUserVali;
import com.xyz.gym_management_sys.service.AdminService;
import com.xyz.gym_management_sys.service.RoleService;
import com.xyz.gym_management_sys.service.UserService;
import com.xyz.gym_management_sys.vo.AddAdminVo;
import com.xyz.gym_management_sys.vo.AdminVo;
import com.xyz.gym_management_sys.vo.RoleVo;
import com.xyz.gym_management_sys.vo.SimpleUserVo;
import com.xyz.gym_management_sys.vo.UserInfoVo;

@Controller
@RequestMapping("/userManage")
public class UserManageController {
	@Resource
	private AdminService adminService;
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private UserService userService;
	
	@Autowired
	private HttpServletRequest request;
	
	@AuthUserVali
	@RequestMapping("/index")
	public String GoAdminIndex(Model model){
		
		return "adminIndex";
	}
	
	@AuthUserVali
	@RequestMapping("/adminList")
	public String GetAdminList(Model model){
		
		List<AdminVo> admins = adminService.findAllAdmin();
		
		model.addAttribute("admins", admins);
		
		return "adminList";
	}
	
	@AuthUserVali
	@RequestMapping("/addAdmin")
	public String AddAdminPage(Model model) {
		RoleVo roleVo = new RoleVo();
		List<RoleVo> roleList = roleService.findRoles(roleVo);  //添加管理员时需要选择管理员的身份
		
		for(int i = 0;i<roleList.size();i++){
			//移出查找到的非管理员角色
			if(roleList.get(i).getRoleName().equals("普通用户")){
				roleList.remove(i);
				break;
			}
		}
		
		model.addAttribute("roleList", roleList);
		return "addAdmin";
	}
	
	@AuthUserVali
	@RequestMapping(value="/doAddAdmin", method=RequestMethod.POST)
	public String DoAddAdmin(@ModelAttribute AddAdminVo addAdminVo, Model model){
		//首先是验证部分，暂时忽略，包括非空、两次密码是否相同
		
		//添加一个新的管理员
		String result = adminService.addNewAdmin(addAdminVo);
		if(result != "添加管理员用户成功"){
			//如果返回的字符串不是成功信息，则直接在原页面展示
			model.addAttribute("wrongMsg", result);
			System.out.println(result);
			return "redirect:addAdmin";
		}
		
		return "redirect:adminList";
	}
	
	@AuthUserVali
	@RequestMapping(value="/deleteAdmin/{adminName}",method=RequestMethod.GET)
	public String DoDeleteAdmin(@PathVariable String adminName,Model model){
		
		AdminVo adminVo = new AdminVo();
		adminVo.setAdminName(adminName);
		String result = adminService.deleteAdmin(adminVo);
		
		if(result != "删除用户成功"){
			model.addAttribute("wrongMsg", result);
		}
		return "redirect:/userManage/adminList";
	}
	
	@AuthUserVali
	@RequestMapping(value="/updateAdminPage/{adminName}",method=RequestMethod.GET)
	public String GoUpdateAdminPage(@PathVariable String adminName,Model model){
		
		AdminVo adminVo =new AdminVo();
		adminVo.setAdminName(adminName);
		
		adminVo = adminService.findAdminByAdminName(adminVo);  //获取结果
		
		//查找管理员
		RoleVo roleVo = new RoleVo();
		List<RoleVo> roleList = roleService.findRoles(roleVo);  //添加管理员时需要选择管理员的身份
		
		for(int i = 0;i<roleList.size();i++){
			//移出查找到的非管理员角色
			if(roleList.get(i).getRoleName().equals("普通用户")){
				roleList.remove(i);
				break;
			}
		}
		
		//将对应管理员信息及管理员列表加入model中
		model.addAttribute("roleList", roleList);
		model.addAttribute("admin", adminVo);
		
		return "updateAdmin";
	}
	
	@AuthUserVali
	@RequestMapping(value="/doUpdateAdmin",method=RequestMethod.POST)
	public String doUpdateAdmin(@ModelAttribute AdminVo adminVo, Model model){
		
		String result = adminService.updateAdmin(adminVo);
		
		if(result != "更新用户成功"){
			model.addAttribute("wrongMsg", result);
			return "redirect:adminList";
		}
		
		return "redirect:adminList";
	}
	
	@AuthUserVali
	@RequestMapping(value="/roleList" )
	public String GoRoleListPage(Model model){
		
		RoleVo roleVo = new RoleVo();
		List<RoleVo> roleList = roleService.findRoles(roleVo);
		
		model.addAttribute("roleList", roleList);
		
		return "roleList";
	}
	
	@AuthUserVali
	@RequestMapping(value="/userList" )
	public String GoUserListPage(Model model){
		
		List<SimpleUserVo> userList = userService.buildUserList();
		
		model.addAttribute("userList", userList);
				
		return "userList";
	}
	
	@AuthUserVali
	@RequestMapping(value="/userDetail/{userName}", method=RequestMethod.GET)
	public String GoUserDetailPage(@PathVariable String userName,Model model){
		
		UserInfoVo userInfo = userService.getUserInfoForUserDetail(userName);
		
		model.addAttribute("userInfo", userInfo);
		
		return "userDetail";
	}
}
