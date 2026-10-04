
/**
 * Given an array arr[] of size n, let s be the sum of all elements in the array. Find the minimum integer x present in arr[] such that s ≤ n * x.
 *
 * Examples:
 *
 * Input: arr[] = [1, 3, 2]
 * Output: 2
 * Explanation: The sum of the array is 6. Since 6 ≤ 3 × 2, 2 satisfies the condition. Among all valid integers present in the array, 2 is the minimum.
 * Input: arr[] = [3]
 * Output: 3
 * Explanation: The sum of the array is 3. Since 3 ≤ 1 × 3, 3 is the only possible answer.
 * Constraints:
 *
 * 1 ≤ ar.size() ≤ 105
 * 1 ≤ ar[i] ≤ 109
 *
 */

/**
 * Solution: We can first calculate the sum of all elements in the array.
 * Then, we iterate through the array to find the minimum integer x that satisfies
 * the condition s ≤ n * x.
 * We keep track of the minimum valid integer found during the iteration.
 *
 * Time Complexity: O(n), where n is the size of the array arr[].
 * Space Complexity: O(1), as we are using a constant amount of extra space to
 */
class MinimumElementMeetingAverage {

    public int minimumInteger(int[] arr) {
        long sum = 0;

        for (int num : arr) {
            sum += num;
        }

        int result = Integer.MAX_VALUE;

        for (int num : arr) {
            // Check if the current number satisfies the condition s ≤ n * x
            if ((long) arr.length * num >= sum) {
                // Update the result if the current number is smaller than 
                // the previous result
                result = Math.min(result, num);
            }
        }

        return result;
    }
}
