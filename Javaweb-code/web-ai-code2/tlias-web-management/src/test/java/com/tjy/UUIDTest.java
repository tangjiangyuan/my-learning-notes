package com.tjy;

import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * @version 1.0
 * @date 2025/8/10 11:33
 */
public class UUIDTest {

    @Test
    public void UUidTest() {
        for (int i = 1; i < 100; i++) {
            System.out.println(UUID.randomUUID().toString());
        }
    }
}
