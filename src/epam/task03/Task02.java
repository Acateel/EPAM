/*
Task 2.
Create  function  Transform,  replacing  the  value  of  each  element  of  an
integer array with the sum of this element value and its index, only if the
given array is sorted in the given order (the order is set up by enum value
SortOrder). Array and sort order are passed by parameters. To check, if
the array is sorted, the function IsSorted from the Task 1 is called.
Example,
For {5, 17, 24, 88, 33, 2} and “ascending” sort order values in the array do
not change;
For  {15,  10,  3}  and  “ascending”  sort  order  values  in  the  array  do  not
change;
For {15, 10, 3} and “descending” sort order the values in the array are
changing to {15, 11, 5}
 */
package epam.task03;

public class Task02 {
    public static void main(String[] args) {
        int[] arr = ArrayFunctionLib.getNumbersInConsole();
        SortOrder order = ArrayFunctionLib.getOrderInConsole();
        ArrayFunctionLib.transform(arr, order);
        ArrayFunctionLib.showNumbersInConsole(arr);
    }
}
