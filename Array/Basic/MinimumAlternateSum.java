/**
 * Given two arrays a[] and b[] of equal size, where a[i] and b[i] denote the
 * time required to climb the i-th step using technique 1 and technique 2,
 * respectively, find the minimum total time required to climb all steps. Geek
 * may start with either technique but must alternate between the two techniques
 * at every step.
 *
 * Examples:
 *
 * Input: a[] = [2, 1, 2], b[]= [3, 2, 1]
 * Output: 5
 * Explanation: Starting with technique 1: a[0] + b[1] + a[2] = 2 + 2 + 2 = 6
 * Starting with technique 2: b[0] + a[1] + b[2] = 3 + 1 + 1 = 5
 * The minimum of the two is 5, achieved by starting with technique 2.
 * Input: a[] = [1, 3, 1, 2], b[]= [2, 2, 3, 1]
 * Output: 5
 * Explanation: Starting with technique 1 yields the minimum total time of 5.
 * Constraints:
 * 1 ≤ a.size(), b.size() ≤ 105
 * 1 ≤ a[i], b[i] ≤ 106
 */

/**
 * Solution explanation:
 * The problem can be solved by calculating the total time required for both
 * techniques and returning the minimum of the two. We can iterate through the
 * arrays and calculate the total time for each technique by alternating
 * between the two techniques at every step. Finally, we return the minimum of
 * the two total times.
 * 
 * Time Complexity: O(n), where n is the size of the input arrays.
 * Space Complexity: O(1), as we are using a constant amount of space.
 */
class MinimumAlternateSum {
    public int minTime(int[] a, int[] b) {
        // code here
        int n = a.length;

        int firstTechniqueSum = 0;
        int secondTechniqueSum = 0;

        // technique first
        for (int i = 0; i < n; i += 2) {

            firstTechniqueSum += a[i];
            if (i < n - 1) {
                firstTechniqueSum += b[i + 1];
            }

        }

        // technique second
        for (int i = 0; i < n; i += 2) {
            if (i < n - 1) {
                secondTechniqueSum += a[i + 1];
            }
            secondTechniqueSum += b[i];

        }
        return Math.min(firstTechniqueSum, secondTechniqueSum);
    }
}
