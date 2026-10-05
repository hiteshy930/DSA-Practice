
/**
 * Given an array of integers arr[], return true if it is possible to split it in two subarrays (without reordering the elements), such that the sum of the two subarrays are equal. If it is not possible then return false.
 *
 * Examples:
 *
 * Input: arr[] = [1, 2, 3, 4, 5, 5]
 * Output: true
 * Explanation: We can divide the array into [1, 2, 3, 4] and [5, 5]. The sum of both the subarrays are 10.
 * Input: arr[] = [4, 3, 2, 1]
 * Output: false
 * Explanation: We cannot divide the array into two subarrays with equal sum.
 * Constraints:
 * 1 ≤ arr.size() ≤ 105
 * 1 ≤ arr[i] ≤ 106
 */

/**
 * Solution: We can first calculate the total sum of the array.
 * Then, we iterate through the array while maintaining a running
 * sum of the left subarray.
 * At each step, we calculate the right subarray sum by subtracting
 * the left sum from the total sum. If at any point the left sum equals
 * the right sum, we return true. If we finish iterating through the array without
 * finding such a split, we return false.
 *
 * Time Complexity: O(n), where n is the size of the array arr[].
 * Space Complexity: O(1), as we are using a constant amount of extra space to
 */
class TwoEqualSumSubArrays {

    public boolean canSplit(int arr[]) {
        // code here
        // total sum
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            // Update the left sum with the current element
            leftSum += arr[i];

            // Calculate the right sum by subtracting the left sum from the total sum
            int rightSum = total - leftSum;

            // Check the condition
            if (leftSum == rightSum) {
                return true;
            }
        }
        return false;
    }
}
