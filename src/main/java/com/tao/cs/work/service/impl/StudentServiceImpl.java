package com.tao.cs.work.service.impl;


import com.tao.cs.work.entity.Student;
import com.tao.cs.work.entity.User;
import com.tao.cs.work.mapper.StudentMapper;
import com.tao.cs.work.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tao
 * @since 2024-06-03
 */
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public User getByUserName(String userName) {
     return studentMapper.getByUserName(userName);

    }

    @Override
    public List<Student> findAllStudent() {
        return studentMapper.selectAllStudents();
    }

    @Override
    public Object getByCard(String card) {
        return studentMapper.getByCard(card);
    }

    @Override
    public Student getByStudentCard(String card) {
        return (Student) studentMapper.getByCard(card);
    }

    @Override
    public void saveStudent(Student student) {
        studentMapper.insertStudent(student.getCard(), student.getName(),
                student.getSex(), student.getPhone());
    }

    @Override
    public Boolean deleteByCard(String card) {
        return studentMapper.deleteByCard(card);
    }
}
