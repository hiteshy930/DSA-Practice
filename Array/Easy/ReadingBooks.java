/**
 * Given two arrays arr1[] and arr2[], and an integer k, where arr1[i]
 * represents the time required to read a book of kind i once and arr2[i]
 * represents the points earned after reading it once.
 * 
 * Geek has k minutes and can choose exactly one kind of book. He may read the
 * chosen book repeatedly within the available time, but cannot read books of
 * different kinds.
 * 
 * Return the maximum possible points Geek can earn.
 * 
 * Examples:
 * 
 * Input: k = 10, arr1[] = [3, 4, 5], arr2[] = [4, 4, 5]
 * Output: 12
 * Explanation:
 * Choosing the first kind allows Geek to read it ⌊10 / 3⌋ = 3 times and earn 3
 * × 4 = 12 points.
 * Choosing the second kind allows Geek to read it ⌊10 / 4⌋ = 2 times and earn 2
 * × 4 = 8 points.
 * Choosing the third kind allows Geek to read it ⌊10 / 5⌋ = 2 times and earn 2
 * × 5 = 10 points.
 * Therefore, the maximum points Geek can earn is 12.
 * Input: k = 12, arr1 = [8, 5], arr2 = [100, 5]
 * Output: 100
 * Explanation:
 * Choosing the first kind allows Geek to read it ⌊12 / 8⌋ = 1 time and earn 1 ×
 * 100 = 100 points.
 * Choosing the second kind allows Geek to read it ⌊12 / 5⌋ = 2 times and earn 2
 * × 5 = 10 points.
 * Therefore, the maximum points Geek can earn is 100.
 * Constraints:
 * 1 ≤ arr.size() ≤ 105
 * 1 ≤ k, arr1[i] ≤ 104
 * 0 ≤ arr2[i] ≤ 104
 */

/**
 * Solution:
 * 1. Initialize a variable maxPoints to store the maximum points earned.
 * 2. Iterate through the arrays arr1 and arr2 simultaneously using a for loop.
 * 3. For each book kind, calculate the number of times Geek can read it by
 * dividing k by the time required to read that book (arr1[i]).
 * 4. Calculate the total points earned by multiplying the number of times
 * Geek can read the book by the points earned for that book (arr2[i]).
 * 5. Update maxPoints if the total points earned in this iteration is greater
 * than the current maxPoints.
 * 6. After iterating through all book kinds, return the maxPoints as the
 * result.
 * 
 * Time Complexity: O(n), where n is the length of the input arrays arr1 and
 * arr2.
 * Space Complexity: O(1), as we are using a constant amount of extra space.
 */

class ReadingBooks {
    public int maxPoint(int k, int[] arr1, int[] arr2) {
        // code
        int n = arr1.length;
        int m = arr2.length;

        int maxPoints = Integer.MIN_VALUE;

        for (int i = 0, j = 0; i < n && j < m; i++, j++) {
            // divide k by arr[i]
            int noOfTimesCanRead = k / arr1[i];

            // check total point can earn in this iteration
            int noOfPoints = noOfTimesCanRead * arr2[j];

            maxPoints = Math.max(maxPoints, noOfPoints);
        }

        return maxPoints;
    }
}
