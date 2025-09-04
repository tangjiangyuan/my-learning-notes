package com.tjy.exception;

/**
 * @version 1.0
 * @date 2025/8/12 19:55
 */
public class DoNotDeleteException extends RuntimeException {

    public DoNotDeleteException() {}

    public DoNotDeleteException(String msg) {
        System.out.println(msg);
    }
}
