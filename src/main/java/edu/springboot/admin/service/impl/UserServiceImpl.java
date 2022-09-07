package edu.springboot.admin.service.impl;

import edu.springboot.admin.pojo.User;
import edu.springboot.admin.service.UserService;
import edu.springboot.admin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Yefl
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-09-05 23:01:06
*/
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;
    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }
}
