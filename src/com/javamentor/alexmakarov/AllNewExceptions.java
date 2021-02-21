package com.javamentor.alexmakarov;

public class AllNewExceptions extends NewException {
    public static class IncorrectMathOperation extends Throwable {
        @Override
        public String toString() {
            return "Неверный арифметический знак!";
        }
    }
    public static class OutOfRange extends  Throwable {
        @Override
        public  String toString() {
            return "Значение не в диапазоне от 1 до 10 включительно!";
        }
    }
    public static class ArabicAndRomeAtSameTime extends Throwable {
        @Override
        public String toString() {
            return "Скорее всего Вы ввели арабские и римские цифры одновременно, либо другая ошибка!";
        }
    }
}
