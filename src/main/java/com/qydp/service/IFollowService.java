package com.qydp.service;

import com.qydp.dto.Result;
import com.qydp.entity.Follow;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
public interface IFollowService extends IService<Follow> {

    Result follow(Long followUserId, Boolean isFollw);


    Result isFollow(Long followUserId);

    Result followCommons(Long id);
}
