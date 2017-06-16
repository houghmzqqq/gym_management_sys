package com.xyz.gym_management_sys.service;

import java.util.List;

import com.xyz.gym_management_sys.vo.AddAdminVo;
import com.xyz.gym_management_sys.vo.AdminVo;
import com.xyz.gym_management_sys.vo.LoginVo;

/**
 * 这个接口定义了管理员用户相关的方法，如登陆、添加新管理员等
 * @author HIPAA
 */
public interface AdminService {
	
	/**
	 * 添加一个新的管理员账户的业务方法
	 * @param adminVo
	 * @return String
	 */
	public String addNewAdmin(AddAdminVo addAdminVo);
	
	/**
	 * 删除一个已有的管理员账户的业务方法,传入的VO类中应该包含：用户ID，用户名，用户角色名
	 * @param adminVo
	 * @return String
	 */
	public String deleteAdmin(AdminVo adminVo);
	
	/**
	 * 更新指定的一个管理员用户的信息，仅可更改真实姓名与角色类型
	 * @param adminVo
	 * @return String
	 */
	public String updateAdmin(AdminVo adminVo);
	
	/**
	 * 管理员账户登陆,返回的字符串为各种情况的代码
	 * @param adminVo
	 * @return AdminVo
	 */
	public AdminVo adminLogin(LoginVo loginVo);
	
	/**
	 * 管理员账户登出
	 * @param adminVo
	 * @return boolean
	 */
	public boolean adminLogout(AdminVo adminVo);
	
	/**
	 * 查找所有的管理员账户
	 * @return
	 */
	public List<AdminVo> findAllAdmin();
	
	/**
	 * 通过管理员账户的用户名查找指定的用户
	 * @return AdminVo
	 */
	public AdminVo findAdminByAdminName(AdminVo adminVo);
}
