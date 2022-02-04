package epam.basic.task03;

import java.util.Scanner;

public class ArrayFunctionLib {

    public static SortOrder getOrderInConsole() {
        System.out.println("Write sort order: a(ascending) or d(descending)");
        String command = new Scanner(System.in).next();
        if(command.equals("a")){
            return SortOrder.ASCENDING;
        }
        else{
            return SortOrder.DESCENDING;
        }
    }

    public static boolean isSortded(int[] arr, SortOrder order) {
        for (int i = 0; i < arr.length-1; i++) {
            if(order == SortOrder.ASCENDING && arr[i] > arr[i+1]){
                return false;
            }
            else if(order == SortOrder.DESCENDING && arr[i] < arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void transform(int[] arr, SortOrder order) {
        if (ArrayFunctionLib.isSortded(arr, order)) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] += i;
            }
        }
    }

    public static void showNumbersInConsole(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int[] getNumbersInConsole() {
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
