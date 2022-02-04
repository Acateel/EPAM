/*
Task 3.
Create  function  MultArithmeticElements,  which  determines  the
multiplication  of  the  first  n  elements  of  arithmetic  progression  of  real
numbers with a given initial element of progression a1 and progression step
t. an is calculated by the formula (an+1 = an + t).
Example,
For a1 = 5, t = 3,  n = 4 multiplication equals to 5*8*11*14 = 6160
 */
package epam.basic.task03;

import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        int a1 = getNumberInConsole();
        int t = getNumberInConsole();
        int n = getNumberInConsole();
        long result = multArithmeticElements(a1,t,n);
        System.out.println(result);
    }

    private static int getNumberInConsole() {
        return new Scanner(System.in).nextInt();
    }

    public static long multArithmeticElements(int a1, int t, int n) {
        if (n == 0) {
            return 1;
        }
        else{
            return a1 * multArithmeticElements(a1+t, t, n-1);
        }
    }
}
