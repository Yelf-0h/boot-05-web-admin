package edu.springboot.admin.mapper;


import edu.springboot.admin.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author Yefl
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-09-05 23:01:06
* @Entity edu.springboot.admin.pojo.User
*/
@Mapper
public interface UserMapper {

    User getUserById(@Param("id") Integer id);

}
