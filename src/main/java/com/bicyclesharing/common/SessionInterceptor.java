package com.bicyclesharing.common;

import com.bicyclesharing.admin.entity.Admin;
import com.bicyclesharing.user.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Tomecs on 2017/10/21.
 */
public class SessionInterceptor implements HandlerInterceptor {
    /**
     * 进行登陆拦截
     * 这里我们先实现用户登陆,之后实现管理员
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String uri = httpServletRequest.getRequestURI();
        if ((uri.indexOf("login") >= 0) || (uri.indexOf("error") >= 0)) {
            return true;
        }
        Admin admin = (Admin) httpServletRequest.getSession().getAttribute("admin");
        if (admin != null) {
            return true;
        }
        httpServletRequest.getRequestDispatcher("/index/admin-index-login-show").forward(httpServletRequest, httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
