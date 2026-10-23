
/**
 * You are given an array arr[] containing non-negative integers. Your task is to select the minimum number of elements such that the sum of the selected elements is greater than the sum of the remaining elements in the array.
 *
 * Examples:
 *
 * Input: arr[] = [2, 17, 7, 3]
 * Output: 1
 * Explanation: By selecting only the element 17, the sum of the remaining elements is 2 + 3 + 7 = 12, which is less than 17. Thus, the minimum number of elements required is 1.
 * Input: arr[] = [20, 12, 18, 4]
 * Output: 2
 * Explanation: By selecting 12 and 18, their sum becomes 12 + 18 = 30, which is greater than the sum of the remaining elements 20 + 4 = 24. Alternatively, selecting 20 and 18 would also satisfy the condition. Thus, the minimum number of elements required is 2.
 * Input: arr[] = [1, 1, 1, 1, 10]
 * Output: 1
 * Explanation: Selecting only the element 10 gives a sum of 10, which is greater than the sum of the remaining elements (1 + 1 + 1 + 1 = 4). Therefore, the minimum number of elements required is 1.
 * Constraints:
 *
 * 1 ≤ arr.size() ≤ 105
 * 1 ≤ arr[i] ≤ 104
 *
 */

/**
 * Solution: Using a greedy approach, we can sort the array in descending order and
 * keep selecting elements from the largest to the smallest until the sum of the selected
 * elements becomes greater than the sum of the remaining elements. We can keep track of
 * the count of selected elements and return it as the result.
 *
 * Time Complexity: O(n log n) due to sorting the array.
 * Space Complexity: O(1) as we are using a constant amount of extra space.
 */

import java.util.Arrays;
class SmallerSubsetWithGreaterSum {

    int minSubset(int[] arr) {
        // code here

        Arrays.sort(arr);

        long totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        long selectedSum = 0;
        int count = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            selectedSum += arr[i];
            count++;

            if (selectedSum > totalSum - selectedSum) {
                return count;
            }
        }

        return count;
    }
}
