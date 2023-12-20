package binary_search;

public class BinarySearch {

    /* This method receives an array and an element to search for inside the array.
     * It returns the index of the element in the array if it could be found, if not return -1
     *
     * The array should be ordered in non-decreasing order
     */
    public int search(int[] array, int target) {
        var start = 0; // The index of the first element in the search space
        var end = array.length - 1; // The index of the last element in the search space

        /* If the target is greater than the pivot check the half with the bigger numbers,
         * if the target is less than the pivot check the half with the smaller numbers,
         * if the target is equal to the pivot return the pivot's index.
         *
         * If you exhausted the search space then return -1 to indicate you couldn't find the target.
         */
        while(end >= start) {
            var pivot = start + (end - start)/2;

            if(array[pivot] < target)
                start = pivot + 1;
            else if(array[pivot] > target)
                end = pivot - 1;
            else
                return pivot;
        }

        return -1;
    }
}
