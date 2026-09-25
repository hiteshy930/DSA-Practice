/**
 * Given a sorted array arr[] of positive integers. The task is to find the closest value in the array to the given number k. The array may contain duplicate values.
 *
 * Note: If the difference with k is the same for two values in the array return the greater value.
 *
 * Examples :
 *
 * Input:  arr[] = [1, 3, 6, 7], k = 4
 * Output: 3
 * Explanation: We have array arr={1, 3, 6, 7} and target is 4. If we look at the absolute difference of target with every element of the array we will get { |1-4|, |3-4|, |6-4|, |7-4| }  = {3, 1, 2, 3}. So, the closest number is 3.
 * Input: arr[] = [1, 2, 3, 5, 6, 8, 9], k = 4
 * Output: 5
 * Explanation: The absolute difference of 4 is 1 from both 3 and 5. 
 * According to the question, we have to return greater value, which is 5.
 * Input: arr[] = [6, 8, 8, 8, 9, 11, 13, 13, 15, 18, 19], k = 10
 * Output: 11
 * 
 * Constraints:
 * 1 ≤ arr.size() ≤ 106
 * 1 ≤ k ≤ 109
 * 1 ≤ arr[i] ≤ 109
 */

/**
 * Solution: Using Binary Search to find the closest value in the sorted array.
 * 1. Initialize two pointers, low and high, to the start and end of the array, respectively.
 * 2. While low is less than or equal to high, calculate the mid index.
 * 3. If the element at mid is equal to k, return k.
 * 4. If the element at mid is less than k, move the low pointer to mid + 1.
 * 5. If the element at mid is greater than k, move the high pointer to mid - 1.
 * 6. After the loop, check the values at the low and high pointers to find the closest value to k.
 * 7. If the difference with k is the same for two values, return the greater value.    
 * 
 * Time Complexity: O(log n), where n is the size of the array.
 * Space Complexity: O(1), as we are using constant space.
 */

class ClosedInSortedArray {
    public static int findClosest(int[] arr, int k) {
        int n = arr.length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == k) {
                return k;
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // k is smaller than all elements
        if (high < 0) {
            return arr[low];
        }

        // k is greater than all elements
        if (low >= n) {
            return arr[high];
        }

        int left = arr[high];
        int right = arr[low];

        int leftDiff = k - left;
        int rightDiff = right - k;

        // In case of equal difference, return the greater value
        if (leftDiff < rightDiff) {
            return left;
        } else {
            return right;
        }
    }
}
