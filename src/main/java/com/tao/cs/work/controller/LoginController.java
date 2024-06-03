package com.tao.cs.work.controller;

import com.tao.cs.work.entity.User;
import com.tao.cs.work.service.IStudentService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author tao
 * 2024/6/3 下午9:07
 */
@Controller
@Slf4j
public class LoginController {
    @Autowired
    private IStudentService studentService;




    /*
     * 用户登录，根据userName进行查询*/
    @PostMapping("doLogin")
    public String doLogin(String userName, String password, HttpSession httpSession, Model model) {
        User user = studentService.getByUserName(userName);
        if (user != null && user.getPassword().equals(password)) {
            httpSession.setAttribute("currentuser", user);
            return "home";
        } else {
            model.addAttribute("error", "用户名或密码输入错误，登陆失败");
            return null;
        }
    }


}
