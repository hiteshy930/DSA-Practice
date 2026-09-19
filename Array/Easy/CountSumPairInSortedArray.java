/**
 * You are given an integer target and an array arr[]. You need to find number
 * of pairs in arr[] which sums up to target. It is given that the elements of
 * the arr[] are in sorted order.
 * 
 * Note: Pairs should have elements of distinct indexes.
 * 
 * Examples :
 * 
 * Input: arr[] = [-1, 1, 5, 5, 7], target = 6
 * Output: 3
 * Explanation: There are 3 pairs which sum up to 6 : {1, 5}, {1, 5} and {-1,
 * 7}.
 * Input: arr[] = [1, 1, 1, 1], target = 2
 * Output: 6
 * Explanation: There are 6 pairs which sum up to 2 : {1, 1}, {1, 1}, {1, 1},
 * {1, 1}, {1, 1} and {1, 1}.
 * Input: arr[] = [-1, 10, 10, 12, 15], target = 125
 * Output: 0
 * Explanation: There is no such pair which sums up to 125.
 * Constraints:
 * -105 <= target <=105
 * 2 <= arr.size() <= 105
 * -105 <= arr[i] <= 105
 * 
 */

/**
 * Solution: Two Pointer Approach
 * 1. Initialize two pointers, left and right, at the beginning and end of the
 * array, respectively.
 * 2. While left is less than right, calculate the sum of the elements at the
 * left and right pointers.
 * 3. If the sum is less than the target, increment the left pointer to increase
 * the sum.
 * 4. If the sum is greater than the target, decrement the right pointer to
 * decrease the sum.
 * 5. If the sum is equal to the target, count the number of occurrences of
 * the elements at the left and right pointers, and add the product of these
 * counts to the total count of pairs. Then, move the left pointer to the right
 * and the right pointer to the left, skipping over any duplicate elements.
 * 6. Return the total count of pairs.
 * 
 * Time Complexity: O(n), where n is the length of the array. We traverse the
 * array once using the two pointers.
 * Space Complexity: O(1), as we are using a constant amount of extra space.
 */

class CountSumPairInSortedArray {
    int countPairs(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;
        int count = 0;

        // Two pointer approach to find pairs with sum equal to target
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                // If the elements at left and right pointers are the same, we can calculate
                // the number of pairs directly using the formula n * (n - 1) / 2, where n is
                // the number of occurrences of that element.
                if (arr[left] == arr[right]) {
                    int n = right - left + 1;
                    count += n * (n - 1) / 2;
                    break;
                }

                int leftValue = arr[left];
                int rightValue = arr[right];

                int leftCount = 0;
                int rightCount = 0;

                // Count the occurrences of the leftValue and rightValue
                while (left <= right && arr[left] == leftValue) {
                    leftCount++;
                    left++;
                }

                // Count the occurrences of the rightValue
                while (right >= left && arr[right] == rightValue) {
                    rightCount++;
                    right--;
                }

                count += leftCount * rightCount;
            }
        }

        return count;
    }
}