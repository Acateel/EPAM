/*
Task 2. Find the maximum integer, that can be obtained by permutation of
numbers of an arbitrary three-digit positive integer n (100<=n<=999).
Example,
n =165          result =  651
 */

package task01;

import java.util.Scanner;

public class Tasktwo {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        int[] digits = new int[3];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = n % 10;
            n /= 10;
        }

        for (int j = 0; j < digits.length - 1; j++) {
            for (int i = 0; i < digits.length - 1; i++) {
                if (digits[i] < digits[i + 1]) {
                    int temp = digits[i];
                    digits[i] = digits[i + 1];
                    digits[i + 1] = temp;
                }
            }
        }
        System.out.println("Result = " + digits[0] + digits[1] + digits[2]);
    }
}
