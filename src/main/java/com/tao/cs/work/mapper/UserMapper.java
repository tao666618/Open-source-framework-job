package com.tao.cs.work.mapper;

import com.tao.cs.work.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author tao
 * @since 2024-06-03
 */
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user (name, username, password) VALUES (#{name}, #{username}, #{password})")
    Boolean save(String name, String username, String password);

    @Select("SELECT * FROM user WHERE username = #{username}")
    User getByUsername(String username);
}
