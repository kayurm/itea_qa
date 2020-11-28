package main.java.lesson1Advanced;

/* Мое имя
Вывести на экран любой символ пирамидкой в обратную сторону высотой в 10 строк.
         *
        **
       ***
      ****
     *****
    ******
   *******
  ********
 *********
**********
System.out.println, System.out.print можно использовать только по одному разу
для этого нужно воспользоваться циклом
*/

public class Task3 {

    public static void main(String[] args) {
//        String s = "**********";
//        for (int i = s.length(); i!=0; i--) {
//            System.out.println(s.substring(0,i));
//        }

        //modified, should be correct now
        String asterisk = "*";
        String space = "         ";
        int len = (asterisk + space).length();

        for (int i = 0; i < len; i++) {
            System.out.printf("%1$s%2$s\n", space.substring(i), asterisk);
            asterisk += "*";
        }
    }
}