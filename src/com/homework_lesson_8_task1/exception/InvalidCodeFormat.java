package com.homework_lesson_8_task1.exception;

import java.io.IOException;

public class InvalidCodeFormat extends IOException {
    public InvalidCodeFormat(String message) {
        super(message);
    }
}
