package org.sunyiwei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sunyiwei.common.ResponseResult;
import org.sunyiwei.dao.UserMapper;
import org.sunyiwei.entity.User;
import org.sunyiwei.entity.UserExample;
import java.util.ArrayList;
import java.util.List;


/**
 * =============================
 *
 * @author:sunyiwei DateTime: 2019/3/20 9:34
 * =============================
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public ResponseResult<Void> insertUser(User user) {

        ResponseResult<Void> result = new ResponseResult<>();
        Long time =System.currentTimeMillis();

        user.setCreateTime(time);
        int insert = userMapper.insert(user);
        if(insert == 1){
            result.setStatus(200);
            result.setMsg("成功");
        }else{
            result.setStatus(400);
            result.setMsg("失败");
        }
        return result;
    }

    @Override
    public ResponseResult<List<User>> getUser() {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdIsNotNull();
        List<User> users = userMapper.selectByExample(example);
        ResponseResult<List<User>> result = new ResponseResult<>();
        if(users == null || users!=null && users.size()==0){
            List<User> list = new ArrayList<>();
            result.setData(list);
        }else {
            result.setData(users);
        }
        return result;
    }

    @Override
    public ResponseResult<Void> delete(int id) {
        ResponseResult<Void> result = new ResponseResult<>();
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(id);
        int i = userMapper.deleteByExample(userExample);
        if(i>0){
            result.setStatus(200);
            result.setMsg("删除成功");
        }else {
            result.setStatus(400);
            result.setMsg("删除失败");
        }
        return result;
    }
}
