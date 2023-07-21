package com.qydp.interceptor;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.qydp.dto.UserDTO;
import com.qydp.entity.User;
import com.qydp.utils.RedisConstants;
import com.qydp.utils.UserHolder;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @program: JavaCode
 * @description:
 * @author: Maple
 * @create: 2023-07-20 16:13
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.判断是否需要拦截
        if(UserHolder.getUser() == null){
            //需要拦截
            response.setStatus(401);
            return false;
        }
        //有用户，则放行
        return true;
    }

}
