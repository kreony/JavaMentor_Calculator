package com.javamentor.alexmakarov;

import com.javamentor.alexmakarov.AllNewExceptions.*;
import com.javamentor.alexmakarov.ArabRome;

import javax.print.DocFlavor;

public class Calculator {

    /*ПРОВЕРКА НА ДИАПАЗОН ОТ 1 ДО 10 ВКЛЮЧИТЕЛЬ*/
    public static boolean isNotInRange(int n) {
        return (n < 1 || n > 10);
    }
    ////////////////////////////////////////////////////////////////////////

    /*ВСЕ ОПЕРАЦИИ*/
    private static int Addition(int a, int b) {
        return a + b;
    }
    private static int Subtraction(int a, int b) {
        return a - b;
    }
    private static int Division(int a, int b) {
        return a / b;
    }
    private static int Multiplication(int a, int b) {
        return a * b;
    }
    ////////////////////////////////////////////////////////////////////////

    /*КАЛЬКУЛЯТОР ДЛЯ АРАБСКИХ ЧИСЕЛ*/
    public static int calc(int a, int b, String oper) throws OutOfRange {
        if (isNotInRange(a) | (isNotInRange(b))) throw new OutOfRange();

        switch (oper) {
            case ("+"):
                return Addition(a, b);
            case ("-"):
                return Subtraction(a, b);
            case ("/"):
                return Division(a, b);
            default:
                return Multiplication(a, b);
        }
    }
    ////////////////////////////////////////////////////////////////////////

    /*КАЛЬКУЛЯТОР ДЛЯ РИМСКИХ ЧИСЕЛ*/
    public static String calc(String a, String b, String oper) throws OutOfRange {
        int numberOne = ArabRome.romeToArab(a);
        int numberTwo = ArabRome.romeToArab(b);

        if (isNotInRange(numberOne) | (isNotInRange(numberTwo))) throw new OutOfRange();

        int result = calc(numberOne, numberTwo, oper);
        if (result < 1) return "Повторите попытку повторно! Минимальная римская цифра = I (один)!";
        if (result > 3999) return "Повторите попытку повторно! Максимальная римская цифра MMMCMXCIX = 3999";
        String resultDgb = ArabRome.arabToRome(result);
        return resultDgb;
    }
    ////////////////////////////////////////////////////////////////////////
}
