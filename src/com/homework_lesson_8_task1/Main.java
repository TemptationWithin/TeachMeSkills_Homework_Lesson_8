package com.homework_lesson_8_task1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Написать программу.
 * На вход передать строку(будем считать, что это номер документа).
 * Номер документа имеет формат xxxx-yyy-xxxx-yyy-xyxy
 * где x - это число, а y - это буква.
 *
 * Вывести на экран в одну строку два первых блока по 4 цифры
 * (это сделайте с помощью использования Pattern и Matcher)
 *
 * В программе для работы со строками из прошлого задания добавьте работу с исключениями.
 * А именно, создайте два своих собственных исключения. И нужно 'бросать' их в случаях когда
 * 1) входная строка с номером документа невалидного формата(например, большей или меньшей длинны) ,
 * 2) если входная строка начинается с последовательности 1111, тоже 'бросить' исключение
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);                   // scanner opened
        System.out.println("Enter the code in the following format:");
        System.out.println("xxxx-yyy-xxxx-yyy-xyxy");
        System.out.println("where x - numbers, y - letters");
        String s = scanner.nextLine();
        scanner.close();                                            // scanner closed
        String s1 = "5579-AsB-9085-LkP-7J1f";
        System.out.println(s1);

        String regEx = "\\d{4}";                                    // regular expression

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(s1);

        StringBuffer sb = new StringBuffer();

        while (matcher.find()){
           sb.append(matcher.group());
        }

        System.out.println(sb);                                     // output XXXXXXXX

    /**
         * Вывести на экран номер документа, но блоки из трех букв заменить на *
     **/

         String regExp2 = "[a-zA-Z]{3}";
         System.out.println(s1.replaceAll(regExp2, "***"));

    /**
        * Вывести на экран только одни буквы из номера документа в формате yyy/yyy/y/y
       */

        String regExp3 = "\\D{1,}";
        String s2 = s1.replaceAll("[-]", "");

        StringBuffer sb2 = new StringBuffer();

        pattern = Pattern.compile(regExp3);
        matcher = pattern.matcher(s2);

        while (matcher.find()){
            sb2.append(matcher.group() + "/");
        }

        sb2.replace(sb2.length()-1,sb2.length(),"");      // deleting the last symbol "/"

        System.out.println(sb2);
        CodeFormatValidation.CheckInputStringFormat(s1);
        }
    }
