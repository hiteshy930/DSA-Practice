
/**
 * Given two sorted arrays arr1[] and arr2[] of size n and m and a number x, find the pair whose sum is closest to x and the pair has an element from each array. In the case of multiple closest pairs return any one of them.
 *
 * Note : In the driver code, the absolute difference between the sum of the closest pair and x is printed.
 *
 * Examples:
 *
 * Input : arr1[] = [1, 4, 5, 7], arr2[] = [10, 20, 30, 40], x = 32
 * Output : [1, 30]
 * Explanation:The closest pair whose sum is closest to 32 is [1, 30] = 31.
 * Input : arr1[] = [1, 4, 5, 7], arr2[] = [10, 20, 30, 40], x = 50
 * Output : [7, 40]
 * Explanation: The closest pair whose sum is closest to 50 is [7, 40] = 47.
 * Constraints:
 * 1 ≤ arr1.size(), arr2.size() ≤ 105
 * 1 ≤ arr1[i], arr2[i] ≤ 109
 * 1 ≤ x ≤ 109
 *
 */
/**
 * Solution: Using Two Pointer Approach
 * 1. Initialize two pointers, one for each array. Start the first pointer at the beginning
 *    of arr1 and the second pointer at the end of arr2.
 * 2. Calculate the sum of the elements pointed to by the two pointers.
 * 3. If the sum is equal to x, return the pair as it is the closest possible sum.
 * 4. If the sum is less than x, move the first pointer to the right to increase the sum.
 * 5. If the sum is greater than x, move the second pointer to the left to decrease the sum.
 * 6. Keep track of the closest pair found so far and its difference from x.
 * 7. Repeat steps 2-6 until the pointers cross each other.
 * 8. Return the closest pair found.
 *
 * Time Complexity: O(n + m), where n and m are the sizes of arr1 and arr2 respectively.
 * Space Complexity: O(1), as we are using a constant amount of extra space.
 */
import java.util.ArrayList;

class ClosetSumPairSortedArray {

    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {

        int i = 0;
        int j = arr2.length - 1;

        int diff = Integer.MAX_VALUE;

        ArrayList<Integer> list = new ArrayList<>();

        while (i < arr1.length && j >= 0) {

            int currentSum = arr1[i] + arr2[j];
            int currentDiff = Math.abs(x - currentSum);
            // If the current difference is less than the minimum difference found so far, 
            // update the minimum difference and store the current pair
            if (currentDiff < diff) {
                diff = currentDiff;

                list.clear();
                list.add(arr1[i]);
                list.add(arr2[j]);
            }
            // Move the pointers based on the comparison of currentSum and x
            if (currentSum < x) {
                // Move the first pointer to the right to increase the sum
                i++;
            } else {
                // Move the second pointer to the left to decrease the sum
                j--;
            }
        }

        return list;
    }
}
