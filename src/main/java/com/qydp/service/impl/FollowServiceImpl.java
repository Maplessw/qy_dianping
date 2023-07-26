package com.qydp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qydp.dto.Result;
import com.qydp.entity.Follow;
import com.qydp.mapper.FollowMapper;
import com.qydp.service.IFollowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qydp.utils.UserHolder;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements IFollowService {

    @Override
    public Result follow(Long followUserId, Boolean isFollw) {
        //1.获取登录用户
        Long userId = UserHolder.getUser().getId();

        //2.判断是关注还是取关
        if(isFollw){
            //2.1关注，新增
            Follow follow = new Follow();
            follow.setUserId(userId);
            follow.setFollowUserId(followUserId);
            save(follow);
        }
        else{
            //2.2取关，删除
            remove(new LambdaQueryWrapper<Follow>()
                    .eq(Follow::getUserId,userId)
                    .eq(Follow::getFollowUserId,followUserId));
        }
        return Result.ok();
    }

    @Override
    public Result isFollow(Long followUserId) {
        //1.查询登录用户
        Long userId = UserHolder.getUser().getId();
        //2.查询是否关注
        Integer count = query().eq("user_id", userId).eq("follow_user_id", followUserId).count();
        //3.判断
        return Result.ok(count > 0);
    }
}
