package com.xyz.gym_management_sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xyz.gym_management_sys.vo.AdminVo;
import com.xyz.gym_management_sys.vo.SignUpVo;
import com.xyz.gym_management_sys.vo.UserAllInfoVo;
import com.xyz.gym_management_sys.vo.UserInfoVo;
import com.xyz.gym_management_sys.vo.UserLoginVo;
import com.xyz.gym_management_sys.dao.UserDao;
import com.xyz.gym_management_sys.dao.UserInfoDao;
import com.xyz.gym_management_sys.po.Admin;
import com.xyz.gym_management_sys.po.User;
import com.xyz.gym_management_sys.po.UserInfo;
import com.xyz.gym_management_sys.service.UserService;
import com.xyz.gym_management_sys.vo.LoginVo;
import com.xyz.gym_management_sys.vo.SimpleUserVo;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	@Resource
	private UserInfoDao userInfoDao;
	
	@Resource
	private Mapper mapper;
	
	public SimpleUserVo userLogin(LoginVo loginVo) {
		User user = new User();
		
		user = mapper.map(loginVo,User.class);
		
		
		
		List<User> userResult = userDao.findUserByNotNullProp(user);
		
		System.out.println("结果集的长度:"+userResult.size());
		
		if(userResult.size() == 0){
			//用户名+密码无法获取用户，返回一个空的VO类，说明用户名或密码错误
			return new SimpleUserVo();
		}
		
		SimpleUserVo simpleUserVo = new SimpleUserVo();
		
		UserInfo userInfo = new UserInfo();
		//userInfo.setUser(userResult.get(0));  //使用获取的用户作为模板实体的属性，即查找条件
		
		
		userInfo = userInfoDao.findUserINfoByPropObj(userResult.get(0)).get(0);  //查找获得对应的用户信息，以取出名字
		
		
		simpleUserVo = mapper.map(userResult.get(0), SimpleUserVo.class);  //将结果集中的第一个对象映射为VO实体
		
		simpleUserVo.setName(userInfo.getName());  //设置查找到的用户姓名
		
		return simpleUserVo;  //返回的VO将被存放在Session中
	}

	public boolean userLogout(SimpleUserVo userVo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	public List<SimpleUserVo> buildUserList() {
		List<SimpleUserVo> resultList = new ArrayList();
		
		String name = "";
		
		User user = new User();
		UserInfo userInfo = new UserInfo(); //获取用户详细信息的空模板
		
		List<User> userList = userDao.findUserByNotNullProp(user);  //查找所有的用户
		
		for(int i = 0;i < userList.size(); i++){
			//遍历PO实体结果集，将PO实体映射为VO实体，并且将每个用户对应的名字从UserInfo表中获取到。
			name = userInfoDao.findUserINfoByPropObj(userList.get(i)).get(0).getName();  //找到当前User对应的name，可能为空
			
			SimpleUserVo temp = new SimpleUserVo();  //临时的一个简单用户业务VO实体，接受映射
			temp = mapper.map(userList.get(i), SimpleUserVo.class);
			
			temp.setName(name);
			
			resultList.add(temp);//添加到返回的结果集中
		}
		
		return resultList;
	}

	public String registerNewUser(SignUpVo signUpVo) {
		
		User user = new User();
		
		user.setUserName(signUpVo.getUserName());
		if(userDao.findUserByNotNullProp(user).size()!=0){
			return "已存在相同用户";
		}
		
		if(!signUpVo.getPassword().equals(signUpVo.getComfirmPsw())){
			return "两次输入的密码不同";
		}
		
		UserInfo userInfo = new UserInfo();
		
		user = mapper.map(signUpVo, User.class);  //将注册信息映射为一个User Po实体
		
		user.setUserRole("普通用户");  //手动设置为普通用户
		
		userDao.addUser(user);  //添加此用户到数据库
		
		userInfo = mapper.map(signUpVo, UserInfo.class);  //映射一个详细信息Po实体
		
		userInfo.setUser(user);
		userInfo.setIdType("身份证");  //手动设置为身份证
		
		userInfoDao.addUserInfo(userInfo);
		
		return "注册成功";
	}

	public boolean userInfoChange(UserInfoVo userInfoVo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Transactional
	public UserInfoVo getUserInfoForUserDetail(String userName) {
		
		User user = new User();
		user.setUserName(userName);
		user = userDao.findUserByNotNullProp(user).get(0);  //通过用户名获取用户
		
		UserInfo userInfo = new UserInfo();

		
		userInfo = userInfoDao.findUserINfoByPropObj(user).get(0);  //使用查找到的用户作为UserInfo的查询条件
		
		//映射PO为VO类
		UserInfoVo userInfoVo =  mapper.map(userInfo, UserInfoVo.class);
		
		return userInfoVo;
	}

	public UserAllInfoVo getUserInfoForPersonalUser(String userName) {

		User user = new User();
		user.setUserName(userName);
		user = userDao.findUserByNotNullProp(user).get(0);  //通过用户名获取用户
		
		UserInfo userInfo = new UserInfo();
		
		userInfo = userInfoDao.findUserINfoByPropObj(user).get(0);  //使用查找到的用户作为UserInfo的查询条件
		
		//映射PO为VO类
		UserAllInfoVo userAllInfoVo =  mapper.map(userInfo, UserAllInfoVo.class);
		
		return userAllInfoVo;
	}

}
