package com.ssm.interceptor;

import com.ssm.po.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserLoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        if(url.contains("/toLogin")||url.contains("/login")||url.contains("/register")||url.contains("/toRegister")){
            return true;
        }
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user_session");
        if(user!=null){
            return true;
        }
        request.setAttribute("msg","请先登录！");
        request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
