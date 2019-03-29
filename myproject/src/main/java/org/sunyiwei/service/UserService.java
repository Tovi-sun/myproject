package org.sunyiwei.service;

import org.sunyiwei.common.ResponseResult;
import org.sunyiwei.entity.User;

import java.util.List;

/**
 * =============================
 *
 * @author:sunyiwei DateTime: 2019/3/20 9:31
 * =============================
 */

public interface UserService {
    ResponseResult<Void> insertUser(User user);
    ResponseResult<List<User>> getUser();
    ResponseResult<Void> delete(int id);
}
