package com.homework_lesson_8_task1;

import com.homework_lesson_8_task1.exception.InvalidCodeFormat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeFormatValidation {
    public static void CheckInputStringFormat(String s) {
        String regEx1 = "([0-9]{4})([-]{1})" +                              // XXXX-
                "([a-zA-z]{3})([-]{1})" +                                   // YYY-
                "([0-9]{4})([-]{1})" +                                      // XXXX-
                "([a-zA-z]{3})([-]{1})" +                                   // YYY-
                "([0-9]{1})([a-zA-z]{1})([0-9]{1})([a-zA-z]{1})";           // XYXY

        //String regExRussianLanguage = "[а-яА-ЯёЁ]";                         // Rus Letters

        Pattern patternFullFormat = Pattern.compile(regEx1);
        Matcher matcher1 = patternFullFormat.matcher(s);

        //Pattern patternRusLetters = Pattern.compile(regEx1);
        //Matcher matcher2 = patternRusLetters.matcher(s);
        if (matcher1.find()){
            System.out.println("yes");
        } else {
            throw new InvalidCodeFormat("NO");
        }
        String regEx2 = "[1]{4}";


    }
}
