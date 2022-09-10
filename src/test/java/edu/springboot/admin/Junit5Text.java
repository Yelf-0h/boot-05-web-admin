package edu.springboot.admin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Yelf
 * @create 2022-09-09-21:59
 */
@SpringBootTest
@DisplayName("junit5测试练习")
public class Junit5Text {
    @Test
    @DisplayName("第一次测试")
    public void firstTest() {
        System.out.println("hello world");
    }

    @Test
    @DisplayName("simple assertion（简单断言）")
    public void simple() {
        assertEquals(3, 1 + 2, "simple math");
        assertNotEquals(3, 1 + 1);

        assertNotSame(new Object(), new Object());
        Object obj = new Object();
        assertSame(obj, obj);

        assertFalse(1 > 2);
        assertTrue(1 < 2);

        assertNull(null,"不为空");
        assertNotNull(new Object());
    }

    @Test
    @DisplayName("array assertion（数组断言）")
    public void array() {
        assertArrayEquals(new int[]{1, 2}, new int[]{1, 2});
    }

    @Test
    @DisplayName("assert all（组合断言）")
    public void all() {
        assertAll("Math",
                () -> assertEquals(2, 1 + 1),
                () -> assertTrue(1 > 0),
                () -> assertArrayEquals(new int[]{2, 2}, new int[]{1, 2})
        );
    }


    @Test
    @DisplayName("异常测试,异常断言")
    public void exceptionTest() {
        assertThrows(ArithmeticException.class,()->System.out.println(1/0));
//      上下两种写法都可以
        ArithmeticException exception = Assertions.assertThrows(
                //扔出断言异常
                ArithmeticException.class, () -> System.out.println(1 % 0));

    }

    @Test
    @DisplayName("超时测试,超时断言")
    public void timeoutTest() {
        assertTimeout(Duration.ofMillis(1000),()->Thread.sleep(500),"超时");
        //上下两种方式都可以，，如果测试方法时间超过1s将会异常
        Assertions.assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(500));
    }

    @Test
    @DisplayName("fail，快速失败")
    public void shouldFail() {
        fail("This should fail");
    }

    @ParameterizedTest
    @ValueSource(strings = {"one", "two", "three"})
    @DisplayName("参数化测试1")
    public void parameterizedTest1(String string) {
        System.out.println(string);
        Assertions.assertTrue(StringUtils.isNotBlank(string));
    }


    @ParameterizedTest
    @MethodSource("method")    //指定方法名
    @DisplayName("方法来源参数")
    public void testWithExplicitLocalMethodSource(String name) {
        System.out.println(name);
        Assertions.assertNotNull(name);
    }

    static Stream<String> method() {
        return Stream.of("apple", "banana");
    }



}
