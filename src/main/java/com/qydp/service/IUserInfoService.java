package com.qydp.service;

import com.qydp.dto.Result;
import com.qydp.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-24
 */
public interface IUserInfoService extends IService<UserInfo> {

    Result sendCode(String phone, HttpSession session);

}
