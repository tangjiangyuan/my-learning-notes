package com.tjy.exception;

/**
 * @version 1.0
 * @date 2025/8/13 14:24
 */
public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException() {}

    public StudentNotFoundException(String msg) {
        super(msg);
    }

}
