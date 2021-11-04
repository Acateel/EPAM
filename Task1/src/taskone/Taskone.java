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
package taskone;

import java.util.Scanner;

public class Taskone {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        if (n > 0) {
            n *= n;
        } else if (n < 0) {
            n = Math.abs(n);
        }
        System.out.printf("result = %d", n);
    }
}
