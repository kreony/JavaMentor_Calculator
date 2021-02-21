package com.javamentor.alexmakarov;

import java.util.Scanner;

import static com.javamentor.alexmakarov.AllNewExceptions.*;
import static com.javamentor.alexmakarov.ArabRome.*;
import static com.javamentor.alexmakarov.Calculator.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Введите выражение | Маска : ЦИФРА_ЗНАК_ЦИФРА: ");
                String inputMath = scanner.nextLine();
                String[] words = inputMath.split(" ");
                String numberOne = words[0].toUpperCase();
                String mathOperation = words[1];
                String numberTwo = words[2].toUpperCase();

                /*            ПРОВЕРКА НА ЗНАК ОПЕРАЦИИ*/
                if (!mathOperation.matches("[+-/*]?+")) {
                    throw new IncorrectMathOperation();
                }
                ////////////////////////////////////////////////////////////////////////

                /*ВЫЧИСЛЕНИЯ АРАБСКИХ ЦИФР(ВЫРАЖЕНИЕ -!(НЕ)РИМСКИЕ) \ && - И */
                if (!isRoman(numberOne) && !isRoman(numberTwo)) {
                    System.out.println(calc(Integer.parseInt(numberOne), Integer.parseInt(numberTwo), mathOperation));
                ////////////////////////////////////////////////////////////////////////

                /*ВЫЧИСЛЕНИЯ РИМСКИХ ЦИФР(ВЫРАЖЕНИЕ -РИМСКИЕ ЛИ) \ && - И */
                } else if (isRoman(numberOne) && isRoman(numberTwo)) {
                    System.out.println(calc(numberOne, numberTwo, mathOperation));
                ////////////////////////////////////////////////////////////////////////
                } else {
                    throw new ArabicAndRomeAtSameTime();
                }
            }
        } catch(IncorrectMathOperation | OutOfRange | ArabicAndRomeAtSameTime e){
                e.printStackTrace();
        }
    }
}
