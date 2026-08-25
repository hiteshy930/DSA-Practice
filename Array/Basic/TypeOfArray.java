/**
 * You are given an array arr[] having unique elements. Your task is to return
 * the type of array described below.
 * 
 * Return 1 if the array is in ascending order.
 * Return 2 if the array is in descending order
 * Return 3 if the array is in descending rotated order
 * Return 4 if the array is in ascending rotated order
 * You may assume that the input array is always one of the four types.
 * 
 * Examples:
 * 
 * Input: arr[] = [2, 1, 5, 4, 3]
 * Output: 3
 * Explanation: Descending rotated, rotate 2 times left.
 * Input: arr[] = [3, 4, 5, 1, 2]
 * Output: 4
 * Explanation: Ascending rotated, rotate 2 times right.
 * Constraints:
 * 3 ≤ arr.size() ≤ 105
 * 1 ≤ arr[i] ≤ 106
 * 
 * Expected Complexities
 * 
 */

/**
 * Solution:
 * Understand the problem, problem is to find the type of array. The array can
 * be in one of the four types: ascending, descending, descending rotated, or
 * ascending rotated. We
 * can find the type of array by counting the number of breaks in ascending and
 * descending order. If there are no breaks in ascending order, the array is in
 * ascending order. If there are no breaks in descending order, the array is in
 * descending order. If there is only one break in descending order, the array
 * is in descending rotated order. If there is only one break in ascending
 * order, the array is in ascending rotated order.
 * 
 */

class TypeOfArray {
    int typeOfArr(int arr[]) {

        int n = arr.length;

        int ascendingBreaks = 0;
        int descendingBreaks = 0;

        for (int i = 0; i < n - 1; i++) {

            if (arr[i] > arr[i + 1]) {
                ascendingBreaks++;
            } else {
                descendingBreaks++;
            }
        }

        // Completely ascending
        if (ascendingBreaks == 0) {
            return 1;
        }

        // Completely descending
        if (descendingBreaks == 0) {
            return 2;
        }

        // Descending rotated:
        // only one pair violates descending order
        if (descendingBreaks == 1) {
            return 3;
        }

        // Ascending rotated:
        // only one pair violates ascending order
        return 4;
    }
}