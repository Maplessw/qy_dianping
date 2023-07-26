package com.qydp.service;

import com.qydp.dto.Result;
import com.qydp.entity.Blog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
public interface IBlogService extends IService<Blog> {

    Result queryHotBlog(Integer current);

    Result queryById(Long id);

    Result likeBlog(Long id);

    Result queryBlogLikes(Long id);
}
