package edu.springboot.admin;

import edu.springboot.admin.mapper.BookMapper;
import edu.springboot.admin.pojo.Book;
import edu.springboot.admin.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;


@SpringBootTest

class Boot05WebAdminApplicationTests {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    BookService bookService;

    @Autowired
    StringRedisTemplate redisTemplate;

//    @Test
    void contextLoads() {
//        Long result = jdbcTemplate.queryForObject("select count(*) from t_book", Long.class);
//        log.info("数量是：{}",result);
//        log.info("数据源用的是：{}",dataSource.getClass());
        Book book = bookMapper.selectById(1);
        long count = bookService.count();
        System.out.println(count);
        System.out.println(book);

    }

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Test
    void testRedis(){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set("hello","world");
        operations.set("hello2","world2");
        String hello = operations.get("hello");
        System.out.println(hello);
        System.out.println(redisConnectionFactory.getClass());
    }

}



