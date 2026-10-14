
/**
 * Given an integer array arr[] and an integer k, perform exactly k operations on the array. In one operation, you can select any element and change its sign: Replace arr[i] with -arr[i].
 *
 * The same element can be selected multiple times. Return the maximum possible sum of the array after exactly k operations.
 *
 * Examples:
 *
 * Input: arr[] = [1, 2, -3, 4, 5], k = 1
 * Output: 15
 * Explanation: Change -3 to 3. The resulting array is [1, 2, 3, 4, 5], whose sum is 15.
 * Input: arr[] = [5, -2, 5, -4, 5, -12, 5, 5, 5, 20], k = 5
 * Output: 68
 * Explanation: Change -12, -4, and -2 to positive values using three operations. The remaining two operations can be performed on the same element, changing its sign twice. Therefore, the maximum sum remains 68.
 * Constraints:
 * 1 ≤ k ≤ 105
 * 1 ≤ arr.size() ≤ 105
 * -104 ≤ arr[i] ≤ 104
 *
 * The element range ensures that the maximum possible array sum fits within a 32-bit signed integer.
 */

/**
 * Solution:
 * 1. Sort the array in ascending order.
 * 2. Iterate through the array and flip the sign of negative elements until either
 * all negative elements are flipped or k operations are exhausted.
 * 3. If there are remaining operations (k > 0), check if k is
 * odd. If it is, flip the sign of the smallest element in the array to maximize the sum.
 * 4. Calculate the sum of the modified array and return it.
 *
 * Time Complexity: O(n log n) due to sorting the array, where n is the length of the array.
 * Space Complexity: O(1) as we are modifying the array in place and using a constant amount
 *  of extra space.
 */
import java.util.Arrays;

class Solution {

    public int maximizeSum(int[] arr, int k) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length && k > 0; i++) {
            if (arr[i] < 0) {
                arr[i] = -arr[i];
                k--;
            } else {
                break;
            }
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int num : arr) {
            sum += num;
            min = Math.min(min, num);
        }
        // If k is odd, we need to flip the smallest element to maximize the sum
        if (k % 2 != 0) {
            // Flip the smallest element 
            // Why 2* min -> Because we are changing the sign of the smallest element, 
            // which effectively reduces the sum by twice its value 
            // (once for removing it and once for adding its negative). 
            //New Sum = oldSum - (2 * min);
            sum -= 2 * min;
        }

        return sum;
    }
}
