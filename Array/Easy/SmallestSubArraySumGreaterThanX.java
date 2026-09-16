/**
 * Given a number x and an array of integers arr, find the smallest subarray
 * with sum strictly greater than the given value. If such a subarray do not
 * exist return 0 in that case.
 * 
 * Examples:
 * 
 * Input: x = 51, arr[] = [1, 4, 45, 6, 0, 19]
 * Output: 3
 * Explanation: Minimum length subarray is [4, 45, 6]
 * Input: x = 100, arr[] = [1, 10, 5, 2, 7]
 * Output: 0
 * Explanation: No subarray exist
 * Constraints:
 * 
 * 1 ≤ x, arr.size() ≤ 105
 * 0 ≤ arr[i] ≤ 104
 */

/**
 * Solution: Using Sliding Window Technique
 * 1. Initialize two pointers, left and right, to the start of the array.
 * 2. Initialize a variable sum to keep track of the current sum of the subarray
 * and a variable minLength to store the minimum length of the subarray found so
 * far
 * 3. Iterate through the array using the right pointer, adding each element to
 * the sum.
 * 4. While the sum is greater than x, update minLength with the current length
 * of the subarray (right - left + 1) and subtract the element at the left
 * pointer from the sum, then increment the left pointer.
 * 5. After the loop, if minLength is still Integer.MAX_VALUE, return 0 (no
 * subarray found), otherwise return minLength.
 * Time Complexity: O(n), where n is the length of the array. Each element is
 * processed at most twice (once by the right pointer and once by the left
 * pointer).
 * Space Complexity: O(1), as we are using a constant amount of extra space.
 */

class SmallestSubArraySumGreaterThanX {
    public static int smallestSubWithSum(int x, int[] arr) {
        // code here
        int n = arr.length;
        int left = 0, sum = 0, minLength = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > x) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= arr[left++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
