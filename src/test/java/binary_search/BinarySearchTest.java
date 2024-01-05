package binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {


    @Test
    void shouldReturnMinusOneIfArrayIsEmpty() {
        var binarySearch = new BinarySearch();

        //Inputs
        var array = new int[]{};
        int target = 1;

        //Results
        int result = binarySearch.search(array, target);
        int expected = -1;

        assertEquals(expected, result);
    }


    @Test
    void shouldReturnMinusOneIfNotFoundInArrayWithOneElement() {
        var binarySearch = new BinarySearch();

        //Inputs
        var array = new int[]{0};
        int target = 1;

        //Results
        int result = binarySearch.search(array, target);
        int expected = -1;

        assertEquals(expected, result);
    }


    @Test
    void shouldReturnMinusOneIfNotFoundInOddArray() {
        var binarySearch = new BinarySearch();

        //Inputs
        var array = new int[]{-10, -5, -1, 0, 8, 10, 12, 14, 16};
        int target = 9;

        //Results
        int result = binarySearch.search(array, target);
        int expected = -1;

        assertEquals(expected, result);
    }


    @Test
    void shouldReturnMinusOneIfNotFoundInEvenArray() {
        var binarySearch = new BinarySearch();

        //Inputs
        var array = new int[]{-20, -12, -2, 0, 3, 7, 10, 14, 16, 18};
        int target = 1;

        //Results
        int result = binarySearch.search(array, target);
        int expected = -1;

        assertEquals(expected, result);
    }


    @Test
    void shouldReturnIndexIfFoundInArrayWithOneElement() {
        var binarySearch = new BinarySearch();

        //Inputs
        var array = new int[]{10};
        int target = 10;

        //Results
        int result = binarySearch.search(array, target);
        int expected = 0;

        assertEquals(expected, result);
    }


    @Test
    void shouldReturnIndexIfFoundInTheMiddle() {
        var binarySearch = new BinarySearch();

        //Inputs
        var array = new int[]{-15, -3, 5, 8, 10, 60, 120};
        int target = 8;

        //Results
        int result = binarySearch.search(array, target);
        int expected = 3;

        assertEquals(expected, result);
    }


    @Test
    void shouldReturnIndexIfFoundAtTheStart() {
        var binarySearch = new BinarySearch();

        //Inputs
        var array = new int[]{3, 4, 6, 7, 10};
        int target = 3;

        //Results
        int result = binarySearch.search(array, target);
        int expected = 0;

        assertEquals(expected, result);
    }


    @Test
    void shouldReturnIndexIfFoundAtTheEnd() {
        var binarySearch = new BinarySearch();

        //Inputs
        var array = new int[]{-10, -2, -1, 0, 3};
        int target = 3;

        //Results
        int result = binarySearch.search(array, target);
        int expected = 4;

        assertEquals(expected, result);
    }
}