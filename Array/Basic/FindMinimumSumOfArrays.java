
/**
 * Given two arrays arr1[] and arr2[] of the same size, find the minimum sum of
 * two elements such that one element is from arr1[] and the other is from
 * arr2[], and they are not at the same index in their respective arrays.
 *
 * Examples:
 *
 * Input: arr1[] = [5, 4, 13, 2, 1], arr2[] = [2, 3, 4, 6, 5]
 * Output: 3
 * Explanation: The minimum sum is obtained by taking 1 from arr1[] and 2 from
 * arr2[]. The sum is 1 + 2 = 3.
 * Input: arr1[] = [5, 4, 13, 1], arr2[] = [3, 2, 6, 1]
 * Output: 3
 * Explanation: The minimum sum is obtained by taking 1 from arr1[] and 2 from
 * arr2[]. We can't take 1 from arr2[] as it is at the same index.
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(1)
 *
 * Constraints:
 * 2 ≤ arr1.size() = arr2.size() ≤ 106
 * 1 ≤ arr1[i], arr2[i] ≤ 105
 */

/**
 * Solution Explanation:
 * The problem requires finding the minimum sum of two elements from two arrays, ensuring that the elements
 * are not at the same index. The approach involves finding the two smallest elements in each array and their respective indices. If the smallest elements from both arrays are at different indices, their sum is returned. If they are at the same index, the algorithm considers the second smallest element from one of the arrays to ensure that the indices do not match, and returns the minimum possible sum.
 * 
 * Time Complexity: O(n) - single pass to find the two smallest elements in each array
 * Space Complexity: O(1) - only a fixed number of variables are used
 * 
 * Advantages:
 * - Efficient with linear time complexity
 * - Constant space usage
 * 
 */
class FindMinimumSumOfArrays {

    public int minSum(int[] arr1, int[] arr2) {
        int n = arr1.length;

        int min1 = Integer.MAX_VALUE;
        int min1Index = -1;
        int min2 = Integer.MAX_VALUE;
        int min2Index = -1;

        int minA = Integer.MAX_VALUE;
        int minAIndex = -1;
        int secondA = Integer.MAX_VALUE;

        // Find two smallest in arr1
        for (int i = 0; i < n; i++) {
            if (arr1[i] < minA) {
                secondA = minA;
                minA = arr1[i];
                minAIndex = i;
            } else if (arr1[i] < secondA) {
                secondA = arr1[i];
            }
        }

        // Find two smallest in arr2
        for (int i = 0; i < n; i++) {
            if (arr2[i] < min1) {
                min2 = min1;
                min2Index = min1Index;

                min1 = arr2[i];
                min1Index = i;
            } else if (arr2[i] < min2) {
                min2 = arr2[i];
            }
        }

        if (minAIndex != min1Index) {
            return minA + min1;
        }
        //Since I can't use both smallest elements because they're at the same index, 
        // I'll try replacing the arr2 minimum and replacing the arr1 minimum, 
        // then choose whichever gives the smaller sum.
        return Math.min(minA + min2, secondA + min1);
    }
}
