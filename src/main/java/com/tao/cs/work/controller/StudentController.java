package com.tao.cs.work.controller;


import com.tao.cs.work.entity.Student;
import com.tao.cs.work.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tao
 * @since 2024-06-03
 */
@Slf4j
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    /*
     * 实现学生注册功能*/
    @ResponseBody //将返回的数据转换为json格式
    @PostMapping("/SignStudentMethod")
    public Student Sregister(@RequestBody Student student) {
        log.info("注册学生信息");
        if (studentService.getByCard(student.getCard()) == null && student.getCard() != null) {
            studentService.saveStudent(student);
            return student;
        }
        return null;
    }

    /*
     * 修改学生信息*/
    @ResponseBody
    @PostMapping("/update")
    public Student Update(@RequestBody Student student) {
        log.info("修改学生信息");
        Student newStudent = studentService.getByStudentCard(student.getCard());
        if (newStudent != null) {
            newStudent.setName(student.getName());
            newStudent.setSex(student.getSex());
            newStudent.setPhone(student.getPhone());
            studentService.saveStudent(newStudent);
            return newStudent;
        }
        return null;
    }

    /*删除学生功能实现*/
    @Transactional
    @GetMapping("/Delete")
    public String Delete(String card) {
        Boolean a = studentService.deleteByCard(card);
        if (a) {
            log.info("删除学生信息成功");
        }
        return "home";
    }

    /*
     * 快捷删除学生信息*/
    @Transactional
    @GetMapping("/Delete/{card}")
    public String delete(@PathVariable("card") String card) {
        log.info("快捷删除学生信息");
        studentService.deleteByCard(card);
        return "redirect:/message";
    }

    /*
     * 搜索学生信息*/
    @PostMapping("/Retrieve")
    public ModelAndView Retrieve(String card) {
        Student student = studentService.getByStudentCard(card);
        ModelAndView modelAndView = new ModelAndView("Aretrieve");
        modelAndView.addObject("student", student);
        return modelAndView;
    }


}
