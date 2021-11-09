/*
Task 1.
In a given array of integers nums swap values of the first and the last array
elements, the second and the penultimate etc., if the two exchanged values
are even.
Example,
{10, 5, 3, 4} =>  {4, 5, 3, 10}
{100, 2, 3, 4, 5} => {100, 4, 3, 2, 5}
{100, 2, 3, 45, 33, 8, 4, 54} => {54, 4, 3, 45, 33, 8, 2, 100}
 */
package epam.task02;

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        int[] nums = getNumbersInConsole();

        swapArraysEven(nums);

        showNumsInConsole(nums);
    }

    private static void swapArraysEven(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            if (nums[i] % 2 == 0 && nums[nums.length - i - 1] % 2 == 0) {
                int temp = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = temp;
            }
        }
    }

    private static void showNumsInConsole(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
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
