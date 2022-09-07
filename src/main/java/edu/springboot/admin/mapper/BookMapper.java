package edu.springboot.admin.mapper;

import edu.springboot.admin.pojo.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Yefl
* @description 针对表【t_book】的数据库操作Mapper
* @createDate 2022-09-07 17:15:30
* @Entity edu.springboot.admin.pojo.Book
*/

public interface BookMapper extends BaseMapper<Book> {

}




