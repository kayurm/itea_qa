package lesson1;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Реализовать функцию, которая принимает строку и возвращает ее же в обратном виде
 * например "Hello world!!!" -> "!!!dlrow olleH"
 */
public class Task5 {

    public static String reverse(String str) {
        StringBuffer buf = new StringBuffer(str);
        return buf.reverse().toString();
    }

    @Parameters({stringIn}) //<- this doesn't work for me
    @Test
    public static void testReverse(String stringIn){
        char firstLetter = stringIn.charAt(0);
        char lastLetter = stringIn.charAt(stringIn.length()-1);
        String reversed = reverse(stringIn);
        Assert.assertEquals(reversed.charAt(0),lastLetter);
        Assert.assertEquals(reversed.charAt(reversed.length()-1),firstLetter);
    }
}
