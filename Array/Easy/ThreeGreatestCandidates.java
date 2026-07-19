/**
 * The hiring team aims to find 3 candidates who are great collectively. Each
 * candidate has an ability expressed as an integer. Three candidates are great
 * collectively if the product of their abilities is maximum.
 *
 * Given the abilities of some candidates in an array, return the maximum
 * collective ability from the pool of candidates.
 *
 * Examples:
 * Input: arr[] = [10, 3, 5, 6, 20]
 * Output: 1200
 * Explanation: Multiplication of 10, 6, and 20 is 1200.
 *
 * Input: arr[] = [-10, -3, -5, -6, -20]
 * Output: -90
 * Explanation: Multiplication of -3, -5 and -6 is -90.
 *
 * Constraints:
 * 3 ≤ arr.size ≤ 10^5
 * -10^3 ≤ arr[i] ≤ 10^3
 */
/**
 * Solution:
 * Brute force: three nested loops to find the three greatest candidates.
 * Better solution: sort the array and return the last three elements.
 * Optimal solution (Greedy approach): traverse the array once and track the
 * top three maximum values and the two smallest values.
 */
class Solution {
    // Greedy approach - O(n) Time and O(1) Space
    int maxProduct(int[] arr) {
        // code here
        // Largest Product can be either of 3 max positive numbers or 2 minimum + 1 max
        // number
        // Let's find maximum 3 numbers
        int n = arr.length;

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {

            if (arr[i] >= firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = arr[i];

            } else if (arr[i] >= secondMax) {
                thirdMax = secondMax;
                secondMax = arr[i];
            } else if (arr[i] > thirdMax) {
                thirdMax = arr[i];
            }

            // Lets find 2 minimum numbers
            if (arr[i] < firstMin) {
                secondMin = firstMin;
                firstMin = arr[i];
            } else if (arr[i] < secondMin) {
                secondMin = arr[i];
            }
        }

        int prodOfMax3 = firstMax * secondMax * thirdMax;

        int prodOfMin2AndMax1 = firstMin * secondMin * firstMax;

        return Math.max(prodOfMax3, prodOfMin2AndMax1);
    }
}
