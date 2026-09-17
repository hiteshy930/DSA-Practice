/**
 * Given an unsorted array arr[], find the first element such that every element
 * to its left is less than or equal to it, and every element to its right is
 * greater than or equal to it.
 * 
 * Note: If no such element exists, return -1.
 * 
 * Examples :
 * 
 * Input: arr = [4, 2, 5, 7]
 * Output: 5
 * Explanation: All elements to the left of 5 are less than or equal to 5, and
 * all elements to the right are greater than or equal to 5.
 * Input: arr = [11, 9, 12]
 * Output: -1
 * Explanation: No element in the array satisfies the required condition.
 * Constraints:
 * 3 ≤ arr.size() ≤ 106
 * 1 ≤ arr[i] ≤ 106
 */

/**
 * Solution: Using Two Arrays
 * 1. Create two arrays leftMax and rightMin of the same size as arr.
 * 2. Fill leftMax such that leftMax[i] contains the maximum value from arr[0]
 * to arr[i].
 * 3. Fill rightMin such that rightMin[i] contains the minimum value from arr[i]
 * to arr[n-1].
 * 4. Iterate through the array from index 1 to n-2 and check if arr[i] is
 * greater than or equal to leftMax[i] and less than or equal to rightMin[i]. If
 * such an element is found, return it.
 * 5. If no such element is found, return -1.
 * Time Complexity: O(n), where n is the length of the array. We traverse the
 * array three times to fill leftMax, rightMin, and to find the required
 * element.
 * Space Complexity: O(n), as we are using two additional arrays of size n.
 */

class LeftSmallerRightGreater {
    public int findElement(int[] arr) {
        int n = arr.length;
        // leftMax[i] stores maximum of arr[0..i]
        int[] leftMax = new int[n];
        leftMax[0] = arr[0];

        // Fill leftMax[1..n-1]
        for (int i = 1; i < n; i++)
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);

        // rightMin[i] stores minimum of arr[i..n - 1]
        int[] rightMin = new int[n];
        rightMin[n - 1] = arr[n - 1];

        // Fill rightMin[1..n-1]
        for (int i = n - 2; i >= 0; i--)
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);

        // Check if we found a required element
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] >= leftMax[i] && arr[i] <= rightMin[i]) {
                return arr[i];
            }
        }
        return -1;

    }

}
