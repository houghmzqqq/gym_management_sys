package com.xyz.gym_management_sys.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xyz.gym_management_sys.vo.AdminVo;

public class UserManageInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
            AuthUserVali UserVali = ((HandlerMethod) handler).getMethodAnnotation(AuthUserVali.class);
            
            //没有声明需要权限,或者声明不验证权限
                if(UserVali == null || UserVali.validate() == false)
                return true;
            else{                
                //在这里实现自己的权限验证逻辑
            	HttpSession session = request.getSession();
            	
            	if(session.getAttribute("user") != null){
            		AdminVo admin = (AdminVo) session.getAttribute("user");
            		if(admin.getRoleName().equals("超级管理员")){
            			//身份为超管，可以进入用户管理页面
            			return true;            			
            		}
        		}	
                else//如果验证失败
                {
                    //返回到登录界面
                	response.sendRedirect(request.getContextPath()+"/login/admin");
                	return false;
                }       
            }
        }
		
		//不是器材管理员，重定向到管理员登陆界面
		response.sendRedirect(request.getContextPath()+"/login/admin");
		return false;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
