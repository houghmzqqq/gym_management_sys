package com.xyz.gym_management_sys.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SecurityInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
            AuthPassport authPassport = ((HandlerMethod) handler).getMethodAnnotation(AuthPassport.class);
            
            //没有声明需要权限,或者声明不验证权限
                if(authPassport == null || authPassport.validate() == false)
                return true;
            else{                
                //在这里实现自己的权限验证逻辑
            	HttpSession session = request.getSession();
            	
            	if(session.getAttribute("user") != null && session.getAttribute("role").equals("普通用户")){
        			return true;
        		}	
                else//如果验证失败
                {
                    //返回到登录界面
                	response.sendRedirect(request.getContextPath()+"/login/user");
                	return false;
                }       
            }
        }
		
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
