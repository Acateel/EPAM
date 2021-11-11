/*
Task 1.
Create function IsSorted, determining whether a given array of integer
values of arbitrary length is sorted in a given order (the order is set up by
enum value SortOrder). Array and sort order are passed by parameters.
Function does not change the array.
 */
package epam.task03;

public class Task01 {
    public static void main(String[] args) {
        int[] arr = ArrayFunctionLib.getNumbersInConsole();
        SortOrder order = ArrayFunctionLib.getOrderInConsole();
        System.out.println(ArrayFunctionLib.isSortded(arr, order));
    }
}
