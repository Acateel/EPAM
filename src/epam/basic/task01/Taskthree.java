/*
Task 3.
For a positive integer n calculate the result value, which is equal to the sum of the odd numbers of  n.
Example,
n = 1234     result = 4
n = 246      result = 0
 */

package epam.basic.task01;

import java.util.Scanner;

public class Taskthree {
    public static void main(String[] args) {
        int n = getNumberInConsole();
        int sum = searchSum(n);
        showResultInConsole(sum);
    }

    private static void showResultInConsole(int sum) {
        System.out.println("Result = " + sum);
    }

    private static int searchSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit % 2 == 1) {
                sum += digit;
            }
            n /= 10;
        }
        return sum;
    }

    private static int getNumberInConsole() {
        return new Scanner(System.in).nextInt();
    }
}
