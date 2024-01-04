package binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {


    @Test
    void shouldReturnMinusOneIfArrayIsEmpty() {
        var binarySearch = new BinarySearch();

        //Inputs
        var array = new int[]{};
        var target = 1;

        //Results
        var result = binarySearch.search(array, target);
        var expected = -1;

        assertEquals(expected, result);
    }


    @Test
    void shouldReturnMinusOneIfNotFoundInArrayWithOneElement() {
        var binarySearch = new BinarySearch();

        //Inputs
        var array = new int[]{0};
        var target = 1;

        //Results
        var result = binarySearch.search(array, target);
        var expected = -1;

        assertEquals(expected, result);
    }


    @Test
    void shouldReturnMinusOneIfNotFoundInOddArray() {
        var binarySearch = new BinarySearch();

        //Inputs
        var array = new int[]{-10, -5, -1, 0, 8, 10, 12, 14, 16};
        var target = 9;

        //Results
        var result = binarySearch.search(array, target);
        var expected = -1;

        assertEquals(expected, result);
    }


    @Test
    void shouldReturnMinusOneIfNotFoundInEvenArray() {
        var binarySearch = new BinarySearch();

        //Inputs
        var array = new int[]{-20, -12, -2, 0, 3, 7, 10, 14, 16, 18};
        var target = 1;

        //Results
        var result = binarySearch.search(array, target);
        var expected = -1;

        assertEquals(expected, result);
    }


    @Test
    void shouldReturnIndexIfFoundInArrayWithOneElement() {
        var binarySearch = new BinarySearch();

        //Inputs
        var array = new int[]{10};
        var target = 10;

        //Results
        var result = binarySearch.search(array, target);
        var expected = 0;

        assertEquals(expected, result);
    }


    @Test
    void shouldReturnIndexIfFoundInTheMiddle() {
        var binarySearch = new BinarySearch();

        //Inputs
        var array = new int[]{-15, -3, 5, 8, 10, 60, 120};
        var target = 8;

        //Results
        var result = binarySearch.search(array, target);
        var expected = 3;

        assertEquals(expected, result);
    }


    @Test
    void shouldReturnIndexIfFoundAtTheStart() {
        var binarySearch = new BinarySearch();

        //Inputs
        var array = new int[]{3, 4, 6, 7, 10};
        var target = 3;

        //Results
        var result = binarySearch.search(array, target);
        var expected = 0;

        assertEquals(expected, result);
    }


    @Test
    void shouldReturnIndexIfFoundAtTheEnd() {
        var binarySearch = new BinarySearch();

        //Inputs
        var array = new int[]{-10, -2, -1, 0, 3};
        var target = 3;

        //Results
        var result = binarySearch.search(array, target);
        var expected = 4;

        assertEquals(expected, result);
    }
}