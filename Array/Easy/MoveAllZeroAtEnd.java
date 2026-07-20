/**
 * You are given an array arr[] of non-negative integers. You have to move all
 * the zeros in the array to the right end while maintaining the relative order
 * of the non-zero elements. The operation must be performed in place, meaning
 * you should not use extra space for another array.
 * 
 * Examples:
 * 
 * Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
 * Output: [1, 2, 4, 3, 5, 0, 0, 0]
 * Explanation: There are three 0s that are moved to the end.
 * Input: arr[] = [10, 20, 30]
 * Output: [10, 20, 30]
 * Explanation: No change in array as there are no 0s.
 * Input: arr[] = [0, 0]
 * Output: [0, 0]
 * Explanation: No change in array as there are all 0s.
 * Constraints:
 * 1 ≤ arr.size() ≤ 105
 * 0 ≤ arr[i] ≤ 105
 */

/**
 * Solution:
 * 1. Brute Force: use temporary array to store non-zero elements and then fill
 * the rest with zeros. This uses extra space.
 * 2. Optimal: Use TWO traversals of the array. In the first traversal, count
 * the number of non-zero elements and store them in their original order. In
 * the second traversal, fill the rest of the array with zeros.
 * 3. Most Optimal: Use a single traversal of the array with two pointers. +
 * SWAP the non-zero elements with the zeros. This maintains the relative order
 * of non-zero elements and moves all zeros to the end in place.
 */
class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
        // Aim is to find non-integer and swap with count index element
        int count = 0;

        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] > 0) {
                swap(arr, i, count);
                count++;
            }
        }
    }

    void swap(int[] arr, int i, int count) {
        int temp = arr[i];
        arr[i] = arr[count];
        arr[count] = temp;
    }
}
