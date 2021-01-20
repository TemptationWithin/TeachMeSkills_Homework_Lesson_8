package com.homework_lesson_8.exception;

import java.io.IOException;

public class InvalidCodeFormatException extends IOException {
    public InvalidCodeFormatException(String message) {
        super(message);
    }
}
