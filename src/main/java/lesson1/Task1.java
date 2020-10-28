package lesson1;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task1 {
    /* Минимум трех чисел
    Написать функцию, которая вычисляет минимум из трёх чисел.
    */

    public static int min(int a, int b, int c) {
        return a>b?Math.min(c,b):Math.min(a,c);
    }

    @Test
    public static void testMin(){
        int a = 5;
        int b = 2;
        int c = 3;
        String message = String.format("Min is incorrect for the set: %d,%d,%d", a,b,c);
        assertEquals(2, min(5,2,3), message);
    }
}
