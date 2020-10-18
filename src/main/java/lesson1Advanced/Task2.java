package lesson1Advanced;

/* Мое имя
Вывести на экран любой символ пирамидкой высотой в 10 строк.
*
**
***
****
*****
******
*******
********
*********
System.out.println, System.out.print можно использовать только по одному разу
для этого нужно воспользоваться циклом
*/

public class Task2 {

    public static void main(String[] args) {
        String s = "*";
        for (int i = 0; i < 10; i++) {
            System.out.println(s);
            s += "*";
        }
    }
}