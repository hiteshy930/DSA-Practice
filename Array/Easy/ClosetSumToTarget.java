/**
 * Given an array arr[] and a number target, find a pair of elements (a, b) in arr[], where a ≤ b whose sum is closest to target.
 *
 * Note: Return the pair in sorted order and if there are multiple such pairs return the pair with maximum absolute difference. If no such pair exists return an empty array.
 *
 * Examples:
 *
 * Input: arr[] = [10, 30, 20, 5], target = 25
 * Output: [5, 20]
 * Explanation: As 5 + 20 = 25 is closest to 25.
 * Input: arr[] = [5, 2, 7, 1, 4], target = 10
 * Output: [2, 7]
 * Explanation: As (4, 5), (2, 7) and (4, 7) both are closest to 10, but absolute difference of (4, 5) is 1, (2, 7) is 5 and (4, 7) is 3. Hence, [2, 7] has maximum absolute difference and closest to target.
 * Input: arr[] = [10], target = 10
 * Output: []
 * Explanation: As the input array has only 1 element, return an empty array.
 * 
 * Constraints:
 *
 * 1 ≤ arr.size() ≤ 2*105
 * 0 ≤ arr[i] ≤ 105
 * 0 ≤ target ≤ 2*105
 */

/**
 * Solution: Using a two-pointer approach to find the pair of elements whose sum is closest to the target.
 * 1. Sort the input array arr[].
 * 2. Initialize two pointers, left at the start of the array and right at the end of the array.
 * 3. Initialize variables to keep track of the closest sum and the corresponding pair.
 * 4. While left pointer is less than right pointer:
 *    a. Calculate the current sum of the elements at the left and right pointers.
 *    b. If the current sum is equal to the target, return the pair as it is the closest possible sum.
 *    c. If the current sum is less than the target, move the left pointer to the right to increase the sum.
 *    d. If the current sum is greater than the target, move the right pointer to the left to decrease the sum.
 *   e. Update the closest sum and pair if the current sum is closer to the target than the previous closest sum.
 * 5. After the loop ends, return the closest pair found.
 * Time Complexity: O(n log n), where n is the size of the input array arr[] (due to sorting).
 * Space Complexity: O(1), as we are using constant space.
 */
import java.util.ArrayList;
import java.util.Arrays;

class ClosetSumToTarget {
    public ArrayList<Integer> sumClosest(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();

        if (arr.length < 2) {
            return result;
        }

        Arrays.sort(arr);

        int i = 0;
        int j = arr.length - 1;

        int minDiff = Integer.MAX_VALUE;
        int maxDifference = -1;

        while (i < j) {
            int sum = arr[i] + arr[j];
            int diff = Math.abs(target - sum);
            int difference = arr[j] - arr[i];

            // Better sum, or same sum difference but larger pair difference
            if (diff < minDiff ||
                (diff == minDiff && difference > maxDifference)) {

                minDiff = diff;
                maxDifference = difference;

                result.clear();
                result.add(arr[i]);
                result.add(arr[j]);
            }

            // Move pointers to get closer to target
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                // Exact target found, but there could be another
                // exact pair with a larger absolute difference.
                i++;
            }
        }

        return result;
    }
}