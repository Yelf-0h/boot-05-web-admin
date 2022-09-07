package edu.springboot.admin.service;

import edu.springboot.admin.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
* @author Yefl
* @description 针对表【t_user】的数据库操作Service
* @createDate 2022-09-05 23:01:06
*/
public interface UserService {
    User getUserById(Integer id);
}
