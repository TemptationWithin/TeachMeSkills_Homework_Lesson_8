package com.homework_lesson_8;

import com.homework_lesson_8.exception.InvalidCodeFormatException;
import com.homework_lesson_8.exception.invalidformatexception.WrongFormatException;
import com.homework_lesson_8.exception.invalidformatexception.WrongStartingNumbersException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeFormatValidation {
    public static void CheckInputStringFormat(String s) throws InvalidCodeFormatException {
        String regEx1 = "^([0-9]{4})([-]{1})" +                              // XXXX-
                "([a-zA-z]{3})([-]{1})" +                                   // YYY-
                "([0-9]{4})([-]{1})" +                                      // XXXX-
                "([a-zA-z]{3})([-]{1})" +                                   // YYY-
                "([0-9]{1})([a-zA-z]{1})([0-9]{1})([a-zA-z]{1})";           // XYXY

        String regExRussianLanguage = "^[а-яА-ЯёЁ]";                         // Rus Letters

        String regEx_1111_atTheBegin = "^[1]{4}";                           // "1111" at the begin


        Pattern patternFullFormat = Pattern.compile(regEx1);
        Matcher matcher1 = patternFullFormat.matcher(s);

        Pattern patternRusLetters = Pattern.compile(regExRussianLanguage);
        Matcher matcher2 = patternRusLetters.matcher(s);

        Pattern pattern_1111_atTheBegin = Pattern.compile(regEx_1111_atTheBegin);
        Matcher matcher3 = pattern_1111_atTheBegin.matcher(s);

        boolean isFormatValid = matcher1.find() && !matcher2.find();
        boolean isStartingNumbersValid = !matcher3.find();


        if (!isFormatValid){

                throw new WrongFormatException("Invalid Format of Input Code" +
                        "(Please, check that your code has format " +
                        "XXXX-YYY-XXXX-YYY-XYXY " +
                        "where X - numbers and Y - letters)," +
                        "and you used only english letters!" +
                        "Please, try again.");
        }

        if (!isStartingNumbersValid){
            throw new WrongStartingNumbersException("Invalid Format of Input Code " +
                    "('1111' can't be at the begin of code)!" +
                    " Please, try again.");
        }

    }
}

