package org.example.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {

    private UserInput() {
    }

    public static int inputActionNumber(BufferedReader reader) {
        int result;
        String userInput;
        while (true) {
            try {
                userInput = reader.readLine();
                if (taskNumberValidation(userInput)) {
                    result = Integer.parseInt(userInput);
                    if (result > 0 && result <= 4) {
                        break;
                    } else {
                        printInvalidActionNumber();
                    }
                } else {
                    printInvalidNotNumeric();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static boolean taskNumberValidation(String number) {
        String regNumber = "^(-[1-9][0-9]*|0|[1-9][0-9]*)$";

        Pattern pattern = Pattern.compile(regNumber);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    private static void printInvalidActionNumber() {
        System.out.println("Нет дествия с таким номером");
    }

    private static void printInvalidNotNumeric() {
        System.out.println("Значение должно быть числовым");
    }
}
