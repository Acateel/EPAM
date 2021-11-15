/*
Task 4.
Create function SumGeometricElements, determining the sum of the first
elements of a decreasing geometric progression of real numbers with a
given initial element of a progression a1 and a given progression step t,
while the last element must be greater than a given alim. an is calculated
by the formula (an+1 = an * t), 0<t<1 .
Example,
For a progression, where a1 = 100, and t = 0.5, the sum of the first elements,
grater than alim = 20, equals to 100+50+25 = 175

 */
package epam.task03;

import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        int a1 = getNumberInConsole();
        double t = getDoubleInConsole();
        int alim = getNumberInConsole();
        int result = symGeometricElements(a1, t, alim);
        System.out.println(result);
    }

    private static double getDoubleInConsole() {
        return new Scanner(System.in).nextDouble();
    }

    private static int getNumberInConsole() {
        return new Scanner(System.in).nextInt();
    }

    public static int symGeometricElements(int a1, double t, int alim) {
        if(a1 < alim){
            return 0;
        }
        else{
            return a1 + symGeometricElements((int)Math.round(a1*t),t, alim);
        }
    }

}
