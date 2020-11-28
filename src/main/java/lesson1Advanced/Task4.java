package main.java.lesson1Advanced;

/*
Семантическое версионирование
Реализовать метод который принимает на вход две строки
с версиями программы ("1.0.1.2", "1.1.1.2")
и возвращает версию более ранней
Подсказка - для решения строки надо разбить на массивы
Про семантическое версионирование почитать можно здесь https://semver.org/lang/ru/
*/

public class Task4 {

    public static void main(String[] args) {
        System.out.println(minVersion("1.0.0.1.2", "1.0.0.2.2"));
    }

    public static String minVersion(String v1, String v2) {
        String[] v1Array = v1.split("\\.");
        String[] v2Array = v2.split("\\.");
        if (v1Array.length != v2Array.length){
            return "versions have different length";
        }

        for (int i = 0; i < v1Array.length; i++) {
            int v1Digit = Integer.parseInt(v1Array[i]);
            int v2Digit = Integer.parseInt(v2Array[i]);
            if (v1Digit < v2Digit) {
                return v1;
            } else if (v1Digit > v2Digit) return v2;
        }

        return "versions are equal";
    }
}