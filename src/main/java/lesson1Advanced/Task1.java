package main.java.lesson1Advanced;

public class Task1 {
    /* Минимум n чисел
    Написать функцию, которая вычисляет минимум из массива чисел.
    */
    public static void main(String[] args) {
        System.out.println(min(new int[]{2,4,6}));
        System.out.println(min(new int[]{2,4,6,1,90,2,0}));
    }

    public static int min(int[] a) {
        int minDigit = a[0];
        for (int i=1;i<a.length;i++){
            if (a[i]<minDigit){
                minDigit=a[i];
            }
        }
        return minDigit;
    }
}
