package com.tao.cs.work.service;


import com.tao.cs.work.entity.Student;
import com.tao.cs.work.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tao
 * @since 2024-06-03
 */
public interface IStudentService  {

    User getByUserName(String userName);

    List<Student> findAllStudent();

    Object getByCard(String card);

    Student getByStudentCard(String card);

    void saveStudent(Student student);

    Boolean deleteByCard(String card);
}
