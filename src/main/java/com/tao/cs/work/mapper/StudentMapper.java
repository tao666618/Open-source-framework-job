package com.tao.cs.work.mapper;


import com.tao.cs.work.entity.Student;
import com.tao.cs.work.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author tao
 * @since 2024-06-03
 */
@Mapper
public interface StudentMapper {
    @Select("select * from user where username = #{userName}")
    User getByUserName(String userName);


    @Select("SELECT * FROM student")
    List<Student> selectAllStudents();

    @Select("SELECT * FROM student WHERE card = #{card}")
    Student getByCard(String card);

    @Insert("INSERT INTO student (card, name, sex, phone) VALUES (#{card}, #{name}, #{sex}, #{phone})")
    void insertStudent(String card, String name, String sex, String phone);

    @Delete("DELETE FROM student WHERE card = #{card}")
    Boolean deleteByCard(String card);

    @Update("UPDATE student SET name = #{name},sex = #{sex} , phone = #{phone} WHERE card = #{card}")
    void insertNewStudent(String card, String name, String sex, String phone);
}
