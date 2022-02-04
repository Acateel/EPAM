/*
Task 1.
For a given integer n calculate the value which is equal to a:
•  squared number, if its value is strictly positive;
•  modulus of a number, if its value is strictly negative;
•  zero, if the integer n is zero.
Example,
n = 4     result =  16
n = -5    result =  5
n = 0     result = 0
 */
package epam.basic.task01;

import java.util.Scanner;

public class Taskone {
    public static void main(String[] args) {
        int n = getNumberInConsole();
        n = matchResult(n);
        showResultInConsole(n);
    }

    private static int matchResult(int n) {
        if (n > 0) {
            n *= n;
        } else if (n < 0) {
            n = Math.abs(n);
        }
        return n;
    }

    private static void showResultInConsole(int n) {
        System.out.printf("result = %d", n);
    }

    private static int getNumberInConsole() {
        return new Scanner(System.in).nextInt();
    }

}
