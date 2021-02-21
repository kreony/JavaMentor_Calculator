package com.javamentor.alexmakarov;


import java.util.*;

public class ArabRome {

    /*ПРОВЕРКА НА РИМСКИЕ ЦИФРЫ*/
    public static boolean isRoman(String s) {
        return s.matches("[IVXLCDM]+");
    }
    ////////////////////////////////////////////////////////////////////////

    /*ДЕРЕВО С ДЕФОЛТНЫМИ ЗНАЧЕНИЯМИ РИМСКИХ ЧИСЕЛ*/
    private final static LinkedHashMap<String, Integer> arab2Rome = new LinkedHashMap<>();
    static {
        arab2Rome.put("M", 1000);
        arab2Rome.put("CM", 900);
        arab2Rome.put("D", 500);
        arab2Rome.put("CD", 400);
        arab2Rome.put("C", 100);
        arab2Rome.put("XC", 90);
        arab2Rome.put("L", 50);
        arab2Rome.put("XL", 40);
        arab2Rome.put("X", 10);
        arab2Rome.put("IX", 9);
        arab2Rome.put("V", 5);
        arab2Rome.put("IV", 4);
        arab2Rome.put("I", 1);
    }
    ////////////////////////////////////////////////////////////////////////

    /*ПЕРЕВОД ЧИСЕЛ ИЗ РИМСКИХ В АРАБСКОЕ ПРЕДСТАВЛЕНИЕ*/
    public final static Integer romeToArab(String roman) {
        for (String key : arab2Rome.keySet()) {
            if (roman.startsWith(key)) {
                if (roman.equals(key)) {
                    return arab2Rome.get(key);
                }
                return arab2Rome.get(key) + romeToArab(roman.substring(key.length()));
            }
        }
        return 0;
    }
    ////////////////////////////////////////////////////////////////////////

    public static String arabToRome(int arab) {
        String result= "";
        while (arab >= 1000) {
            result += "M";
            arab -= 1000;        }
        while (arab >= 900) {
            result += "CM";
            arab -= 900;
        }
        while (arab >= 500) {
            result += "D";
            arab -= 500;
        }
        while (arab >= 400) {
            result += "CD";
            arab -= 400;
        }
        while (arab >= 100) {
            result += "C";
            arab -= 100;
        }
        while (arab >= 90) {
            result += "XC";
            arab -= 90;
        }
        while (arab >= 50) {
            result += "L";
            arab -= 50;
        }
        while (arab >= 40) {
            result += "XL";
            arab -= 40;
        }
        while (arab >= 10) {
            result += "X";
            arab -= 10;
        }
        while (arab >= 9) {
            result += "IX";
            arab -= 9;
        }
        while (arab >= 5) {
            result += "V";
            arab -= 5;
        }
        while (arab >= 4) {
            result += "IV";
            arab -= 4;
        }
        while (arab >= 1) {
            result += "I";
            arab -= 1;
        }
        return result;
        }
    }
