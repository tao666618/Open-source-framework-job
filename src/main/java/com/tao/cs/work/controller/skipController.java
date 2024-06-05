package com.tao.cs.work.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author tao
 * 2024/6/3 下午9:30
 */
@Slf4j
@Controller
public class skipController {
    /*
     * 跳转到登录界面 */
    @GetMapping("/")
    public String Login() {
        log.info("跳转到登录界面");
        return "login";
    }

    /*
     * 跳转到管理员注册界面*/
    @GetMapping("register")
    public String register() {
        log.info("跳转到注册界面");
        return "register";
    }

    /*
     * 跳转到主界面*/
    @GetMapping("home")
    public String notifications() {
        log.info("跳转到主界面");
        return "home";
    }


    /*
     * 跳转到修改学生信息界面*/
    @GetMapping("/update")
    public String update() {
        log.info("跳转到修改学生信息界面");
        return "update";
    }

    /*
     * 跳转到删除界面*/
    @GetMapping("/Delete")
    public String delete() {
        log.info("跳转到删除界面");
        return "delete";
    }

    /*
     * 跳转到学生搜索界面*/
    @GetMapping("/retrieve")
    public String retrieve() {
        log.info("跳转到学生搜索界面");
        return "retrieve";
    }

    /*
     * 学生注册*/
    @GetMapping("/studentSign")
    public String studentSign() {
        log.info("跳转到学生注册界面");
        return  "studentSign";
    }
}
