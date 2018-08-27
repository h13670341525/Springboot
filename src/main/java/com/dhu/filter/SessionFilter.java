package com.dhu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(filterName = "SessionFilter",urlPatterns = {"*.do"})
public class SessionFilter implements Filter {
    private String NO_LOGIN="您还未登陆";
    private String[] includeUrls={"login.do","register.do"};
    public void destroy() {}
    public void init(FilterConfig config) throws ServletException {}
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        String requestUrl=request.getRequestURI();
        if(isNeedFilter(requestUrl)){
             if(request.getSession().getAttribute("user")==null){
                 resp.setCharacterEncoding("UTF-8");
                 resp.getWriter().write(NO_LOGIN);
             }
             else{
                 chain.doFilter(req, resp);
             }
        }
        else{
            chain.doFilter(req, resp);
        }
    }
    private boolean isNeedFilter(String requestUrl){
         for(String includeUrl:includeUrls){
             if(requestUrl.endsWith(includeUrl)) return false;
         }
         return true;
    }
}
