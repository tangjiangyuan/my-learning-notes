package com.mvn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/31 0:16
 */
@DisplayName("测试用户服务 - 获取性别")
public class UserServiceAITest {
    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    // ----------------------------- 异常情况测试 -----------------------------

    @Test
    @DisplayName("获取性别 - null值")
    public void testGetGenderWithNull() {
        // 当传入null时，应该抛出 IllegalArgumentException
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getGender(null));
    }

    @Test
    @DisplayName("获取性别 - 空字符串")
    public void testGetGenderWithEmptyString() {
        // 当传入空字符串时，应该抛出 IllegalArgumentException
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getGender(""));
    }

    @Test
    @DisplayName("获取性别 - 长度小于18位")
    public void testGetGenderWithShortIdCard() {
        // 当传入长度小于18的身份证号时，应该抛出 IllegalArgumentException
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getGender("123456"));
    }

    @Test
    @DisplayName("获取性别 - 长度大于18位")
    public void testGetGenderWithLongIdCard() {
        // 当传入长度大于18的身份证号时，应该抛出 IllegalArgumentException
        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.getGender("11000020001001001111"));
    }

    // ----------------------------- 正常情况测试 -----------------------------

    @Test
    @DisplayName("获取性别 - 第17位为奇数，应返回男")
    public void testGetGenderMaleOdd() {
        // 第17位是1（奇数），期望返回“男”
        String gender = userService.getGender("110000200010010011");
        Assertions.assertEquals("男", gender);
    }

    @Test
    @DisplayName("获取性别 - 第17位为偶数，应返回女")
    public void testGetGenderFemaleEven() {
        // 第17位是2（偶数），期望返回“女”
        String gender = userService.getGender("110000200010010021");
        Assertions.assertEquals("女", gender);
    }

    @Test
    @DisplayName("获取性别 - 第17位为3（奇数）")
    public void testGetGenderMaleOddThree() {
        // 第17位是3（奇数），期望返回“男”
        String gender = userService.getGender("110000200010010031");
        Assertions.assertEquals("男", gender);
    }

    @Test
    @DisplayName("获取性别 - 第17位为4（偶数）")
    public void testGetGenderFemaleEvenFour() {
        // 第17位是4（偶数），期望返回“女”
        String gender = userService.getGender("110000200010010041");
        Assertions.assertEquals("女", gender);
    }
}
