package com.qydp.interceptor;

import com.qydp.dto.UserDTO;
import com.qydp.entity.User;
import com.qydp.utils.UserHolder;
import org.springframework.beans.BeanUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: JavaCode
 * @description:
 * @author: Maple
 * @create: 2023-07-20 16:13
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if(user == null){
            response.setStatus(401);
            return false;
        }
        UserHolder.saveUser((UserDTO) user);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //从thradLocal中移除用户数据
        UserHolder.removeUser();
    }
}
