package com.homework_lesson_8.exception.invalidformatexception;

import com.homework_lesson_8.exception.InvalidCodeFormatException;

public class WrongStartingNumbersException extends InvalidCodeFormatException {
    public WrongStartingNumbersException(String message) {
        super(message);
    }
}
