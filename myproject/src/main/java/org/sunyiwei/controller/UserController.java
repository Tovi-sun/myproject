package org.sunyiwei.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
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
    @Autowired
    private  RestTemplate restTemplate;
//    private String checkReg(){
//        String forObject = restTemplate.getForObject("http://localhost:8096/monitor/counters", String.class);
//        return forObject;
//    }
    public static final String HTTP_TOTAL = "http_total";
    public static final String TOTAL = "total";
    @RequestMapping(value = "/insert" ,method = RequestMethod.POST)
    public ResponseResult<Void> insert(@RequestBody User user){
        String jsonResult = restTemplate.postForObject("http://localhost:8096/monitor/gauge/inc/name/" + TOTAL + "/amt/1", null, String.class);
        System.out.println(jsonResult);

        ResponseResult<Void> result = userService.insertUser(user);
        return result;
    }
    @RequestMapping(value = "/get" ,method = RequestMethod.GET)
    public ResponseResult<List<User>> get(){

        ResponseResult<List<User>> user = userService.getUser();
        return user;
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ResponseResult<Void> delete(@PathVariable("id") int id){
        String s = restTemplate.postForObject("http://localhost:8096/monitor/gauge/dec/name/"+TOTAL+"/amt/1", null, String.class);
        System.out.println(s);
        ResponseResult<Void> delete = userService.delete(id);
        return delete;
    }
}
