package edu.springboot.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.springboot.admin.pojo.Book;
import edu.springboot.admin.service.BookService;
import edu.springboot.admin.mapper.BookMapper;
import org.springframework.stereotype.Service;

/**
* @author Yefl
* @description 针对表【t_book】的数据库操作Service实现
* @createDate 2022-09-07 17:15:30
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
    implements BookService{

}




