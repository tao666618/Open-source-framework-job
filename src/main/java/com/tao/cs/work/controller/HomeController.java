package com.tao.cs.work.controller;

import com.tao.cs.work.entity.Student;
import com.tao.cs.work.service.IStudentService;
import com.tao.cs.work.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author tao
 * 2024/6/3 下午9:21
 */
@Slf4j
@Controller
public class HomeController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IUserService userService;

    /*
    * 查看所有学生信息*/
    @GetMapping("/message")
    public ModelAndView message() {
        ModelAndView modelAndView = new ModelAndView();
        log.info("查询所有学生信息");
        List<Student> students = studentService.findAllStudent();
        modelAndView.addObject("students", students);
        modelAndView.setViewName("message");
        log.info("将学生信息：{}展示给message",students);
        return modelAndView;
    }





}
