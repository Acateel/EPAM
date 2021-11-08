/*
Task 2. Find the maximum integer, that can be obtained by permutation of
numbers of an arbitrary three-digit positive integer n (100<=n<=999).
Example,
n =165          result =  651
 */

package epam.task01;

import java.util.Scanner;

public class Tasktwo {
    public static void main(String[] args) {
        int n = getNumberInConsole();
        int[] digits = cutNumberInDigits(n);
        searchMaxNumber(digits);
        showResultInConsole(digits);
    }

    private static void searchMaxNumber(int[] digits) {
        for (int j = 0; j < digits.length - 1; j++) {
            for (int i = 0; i < digits.length - 1; i++) {
                if (digits[i] < digits[i + 1]) {
                    int temp = digits[i];
                    digits[i] = digits[i + 1];
                    digits[i + 1] = temp;
                }
            }
        }
    }

    private static int[] cutNumberInDigits(int n) {
        int[] digits = new int[3];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = n % 10;
            n /= 10;
        }
        return digits;
    }

    private static void showResultInConsole(int[] digits) {
        System.out.println("Result = " + digits[0] + digits[1] + digits[2]);
    }

    private static int getNumberInConsole() {
        return new Scanner(System.in).nextInt();
    }
}
