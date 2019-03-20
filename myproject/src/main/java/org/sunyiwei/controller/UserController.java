package org.sunyiwei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.sunyiwei.common.ResponseResult;
import org.sunyiwei.entity.User;
import org.sunyiwei.service.UserService;

import java.util.List;

/**
 * =============================
 *
 * @author:sunyiwei DateTime: 2019/3/20 9:56
 * =============================
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/insert" ,method = RequestMethod.POST)
    public ResponseResult<Void> insert(@RequestBody User user){
        ResponseResult<Void> result = userService.insertUser(user);
        return result;
    }
    @RequestMapping(value = "/get" ,method = RequestMethod.GET)
    public ResponseResult<List<User>> get(){
        ResponseResult<List<User>> user = userService.getUser();
        return user;
    }
}
