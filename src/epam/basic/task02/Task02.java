/*
Task 2.
In a given array of integers nums calculate integer result value, that is
equal to the distance between the first and the last entry of the maximum
value in the array.
Example,
{4, 100, 3, 4} result = 0
{5, 50, 50, 4, 5} result = 1
{5, 350, 350, 4, 350} result = 3
{10, 10, 10, 10, 10} result = 4
 */
package epam.basic.task02;

import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        int[] nums = getNumbersInConsole();

        int result = getResult(nums);

        showResultInConsole(result);
    }

    private static void showResultInConsole(int result) {
        System.out.println("Result:" + result);
    }

    private static int getResult(int[] nums) {
        int max = nums[0];
        int index = 0;
        int result = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
                index = i;
                result = 0;
            }
            if(nums[i] == max){
                result = i - index;
            }
        }
        return result;
    }

    private static int[] getNumbersInConsole() {
        int[] arr = new int[0];
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int number = in.nextInt();
            int[] temp = new int[arr.length + 1];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            temp[temp.length - 1] = number;
            arr = temp;
        }
        return arr;
    }
}
