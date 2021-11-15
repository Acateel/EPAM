package epam.task03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayFunctionLibTest {

    @Test
    void testIsSortdedAscendingTrue() {
        int[] arr = {1, 2, 5, 5, 7, 8, 8, 9};
        boolean result = ArrayFunctionLib.isSortded(arr, SortOrder.ASCENDING);
        assertTrue(result);
    }

    @Test
    void testIsSortdedAscendingFalse() {
        int[] arr = {1, 2, 5, 5, 7, 8, 8, 0};
        boolean result = ArrayFunctionLib.isSortded(arr, SortOrder.ASCENDING);
        assertFalse(result);
    }

    @Test
    void testIsSortdedDescendingTrue() {
        int[] arr = {98, 98, 55, 41, 25, 25, 25, 1, 0};
        boolean result = ArrayFunctionLib.isSortded(arr, SortOrder.DESCENDING);
        assertTrue(result);
    }

    @Test
    void testIsSortdedDescendingFalse() {
        int[] arr = {97, 98, 55, 41, 25, 25, 25, 1, 0};
        boolean result = ArrayFunctionLib.isSortded(arr, SortOrder.DESCENDING);
        assertFalse(result);
    }

    @Test
    void testTransformAscendingTrue() {
        int[] arr = {1, 2, 5, 5, 7, 8, 8, 9};
        ArrayFunctionLib.transform(arr, SortOrder.ASCENDING);
        assertArrayEquals(new int[]{1, 3, 7, 8, 11, 13, 14, 16}, arr);
    }

    @Test
    void testTransformAscendingFalse() {
        int[] arr = {1, 2, 5, 5, 7, 8, 8, 0};
        ArrayFunctionLib.transform(arr, SortOrder.ASCENDING);
        assertArrayEquals(new int[]{1, 2, 5, 5, 7, 8, 8, 0}, arr);
    }

    @Test
    void testTransformDescendingTrue() {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        ArrayFunctionLib.transform(arr, SortOrder.DESCENDING);
        assertArrayEquals(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, arr);
    }

    @Test
    void testTransformDescendingFalse() {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 2};
        ArrayFunctionLib.transform(arr, SortOrder.DESCENDING);
        assertArrayEquals(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 2}, arr);
    }
}