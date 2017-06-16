package com.xyz.gym_management_sys.service;

import java.util.List;

import com.xyz.gym_management_sys.vo.LoginVo;
import com.xyz.gym_management_sys.vo.SignUpVo;
import com.xyz.gym_management_sys.vo.SimpleUserVo;
import com.xyz.gym_management_sys.vo.UserAllInfoVo;
import com.xyz.gym_management_sys.vo.UserInfoVo;
import com.xyz.gym_management_sys.vo.UserLoginVo;

/**
 * 这个接口定义了用户相关的业务方法，包括登陆、登出、更改用户信息等
 * @author HIPAA
 */
public interface UserService {

	/**
	 * 注册用户的业务方法,返回的字符串是执行状态代码
	 * @param userVo
	 * @return String
	 */
	public String registerNewUser(SignUpVo signUpVo);
	
	/**
	 * 普通用户登录的业务方法，返回的字符串是执行状态代码
	 * @param userVo
	 * @return SimpleUserVo
	 */
	public SimpleUserVo userLogin(LoginVo loginVo);
	
	/**
	 * 普通用户登出的业务方法
	 * @param userVo
	 * @return
	 */
	public boolean userLogout(SimpleUserVo userVo);
	
	/**
	 * 普通用户修改用户信息的业务方法
	 * @param userInfoVo
	 * @return boolean
	 */
	public boolean userInfoChange(UserInfoVo userInfoVo);
	
	/**
	 * 建立用户列表的方法，查找数据库中所有的用户
	 * @return
	 */
	public List<SimpleUserVo> buildUserList();
	
	/**
	 * 通过传入用户名，查找该用户对应的详细信息
	 * @param userName
	 * @return UserInfoVo
	 */
	public UserInfoVo getUserInfoForUserDetail(String userName);
	
	/**
	 * 使用用户名，查询该用户对应的所有详细信息，用于个人查看自己的信息
	 * @param userName
	 * @return
	 */
	public UserAllInfoVo getUserInfoForPersonalUser(String userName);
}
