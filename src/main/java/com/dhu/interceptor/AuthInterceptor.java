package com.dhu.interceptor;

import com.dhu.annotation.AuthValidate;
import com.dhu.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle");
        AuthValidate validate=((HandlerMethod)o).getMethodAnnotation(AuthValidate.class);
        if(validate==null) return true;
        User user= (User) httpServletRequest.getSession().getAttribute("user");
        if(user!=null&&validate.value()==user.getAuth_id()) return true;
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.getWriter().write("权限不足");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
