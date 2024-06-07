package com.tao.cs.work.service;


import com.tao.cs.work.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tao
 * @since 2024-06-03
 */
public interface IUserService {

    Boolean save(User user);

    User getByUsername(String username);
}
