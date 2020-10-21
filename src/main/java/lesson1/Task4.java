package lesson1;

/* Мое имя
Вывести на экран свое имя 5 строк по 10 раз (через пробел).
System.out.println, System.out.print можно использовать только по одному разу
для этого нужно воспользоваться циклом do () while
*/

public class Task4 {

    public static void main(String[] args) {
        String s = "Kate";
        int i=0;
        do{
            for (int j = 0; j < 10; j++) {
                System.out.print(s+" ");
                if (j == 9) {
                    System.out.print("\n");
                }
            }
        i++;
        }while(i<5);
    }
}