package com.mvn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/30 23:26
 */
@DisplayName("测试用户服务")
public class UserServiceTest {
    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    @DisplayName("获取性别 - null值")
    public void testGetGender1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getGender(null));
    }

    @Test
    @DisplayName("获取性别 - 空值")
    public void testGetGender2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getGender(""));
    }

    @Test
    @DisplayName("获取性别 - 非法值小于18位")
    public void testGetGender3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getGender("100"));
    }

    @Test
    @DisplayName("获取性别 - 非法值大于18位")
    public void testGetGender4() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getGender("11000020001001001111"));
    }

    @Test
    @DisplayName("正常获取性别 - 男")
    public void testGetGender5() {
        String gender = userService.getGender("110000200010010011");
        Assertions.assertEquals("男", gender);
    }

    @Test
    @DisplayName("正常获取性别 - 女")
    public void testGetGender6() {
        String gender = userService.getGender("110000200010010021");
        Assertions.assertEquals("女", gender);
    }

    // --------------------------------------------- 测试获取年龄 --------------------

    @Test
    @DisplayName("获取年龄 - null值")
    public void testGetAge1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getAge(null));
    }

    @Test
    @DisplayName("获取年龄 - 空值")
    public void testGetAge2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getAge(""));
    }

    @Test
    @DisplayName("获取年龄 - 位数低于18位")
    public void testGetAge3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getAge("110"));
    }

    @Test
    @DisplayName("获取年龄 - 位数超过18位")
    public void testGetAge4() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getAge("11000020001001001111"));
    }

    @Test
    @DisplayName("正常获取年龄 - 男")
    public void testGetAge5() {
        Integer age = userService.getAge("110000200307200011");
        Assertions.assertEquals(22, age);
    }

    @Test
    @DisplayName("正常获取年龄 - 女")
    public void testGetAge6() {
        Integer age = userService.getAge("110000200307200041");
        Assertions.assertEquals(22, age);
    }
}
