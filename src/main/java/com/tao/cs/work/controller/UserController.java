package com.tao.cs.work.controller;


import com.tao.cs.work.entity.User;
import com.tao.cs.work.service.IStudentService;
import com.tao.cs.work.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.swing.plaf.SeparatorUI;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tao
 * @since 2024-06-03
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IStudentService studentService;





    @PostMapping("save")
    public User save(@RequestBody User user){
        log.info("注册用户信息");
        /*TODO 这个里面视图层传递过来的数据缺少一个username*/

        userService.save(user);
        if(userService.save(user)){
            return user;
        }
        return null;



    }




}
