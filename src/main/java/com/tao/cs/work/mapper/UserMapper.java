package com.tao.cs.work.mapper;

import com.tao.cs.work.entity.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tao
 * @since 2024-06-03
 */
@Mapper
public interface UserMapper  {

@Insert("INSERT INTO user (name, username, password) VALUES (#{name}, #{username}, #{password})")
    User save(String name, String username, String password);
}
