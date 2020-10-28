package lesson1;

/* Мое имя
Вывести на экран свое имя 5 строк по 10 раз (через пробел).
System.out.println, System.out.print можно использовать только по одному разу
для этого нужно воспользоваться циклом for
*/

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Task2 {

    public String printName(String name, int columnsQty, int rowsQty) {
        String res = "";
        for (int i = 0; i < rowsQty; i++) {
            for (int j = 0; j < columnsQty; j++) {
                res += name + " ";
                if (j == (columnsQty - 1)) {
                    res += "\n";
                }
            }
        }
        return res;
    }

    @Test(dataProvider = "provider")
    public void verifyNameRepetitions(String name, int columnsQty, int rowsQty) {
        int expectedResult = columnsQty * rowsQty;
        List<String> arList = Arrays.asList(printName(name, columnsQty, rowsQty).split("\n"));
        int actualResult = arList.stream().mapToInt(row -> (int) Arrays.stream(row.split(" ")).count()).sum();
        Assert.assertEquals(expectedResult, actualResult, "Quantity of names printed is incorrect");

    }

    @DataProvider(name = "provider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"Kate", 10, 5},
                {"Gregory", 2, 9},
                {"Gearoid", 1, 1}
        };
    }
}