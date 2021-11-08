/*
Task 4.
For a positive integer n calculate the result value, which is equal to the amount of the “1” in the binary
representation of n.
Example,
n = 14 (10) = 1110 (2)              result =  3
n = 128 (10) = 1000 0000 (2)        result  =  1
 */
package task01;

import java.util.Scanner;

public class Taskfour {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int result = 0;
        while (n > 0) {
            result += n % 2;
            n /= 2;
        }
        System.out.println("Result = " + result);
    }
}
