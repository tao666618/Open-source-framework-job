package com.tao.cs.work.service.impl;


import com.tao.cs.work.entity.User;
import com.tao.cs.work.mapper.UserMapper;
import com.tao.cs.work.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tao
 * @since 2024-06-03
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User save(User user) {
        return userMapper.save(user.getName(), user.getUsername(), user.getPassword());
    }
}
