package edu.springboot.admin.interceptor;


/**
 * redis拦截器计算uri的次数
 * 由于没有redis所以注释掉
 * @author Yelf
 * @create 2022-09-08-0:42
 */

//@Component
//@Deprecated
//public class RedisUriCountInterceptor implements HandlerInterceptor {
//
//    @Autowired
//    StringRedisTemplate redisTemplate;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String requestURI = request.getRequestURI();
//        Long increment = redisTemplate.opsForValue().increment(requestURI);
//        return true;
//    }
//}
