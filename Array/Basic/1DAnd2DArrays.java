
/**
 * Given a integer n. We have n*n values of a 2-d array, and  n values of 1-d array. Task is to find the sum of the left diagonal values of the 2-d array and the max element of the 1-d array and print them with space in between.
 *
 *  *Example 1:
 *
 *  *â€‹Input : arr[][] = {{1,2,3}, {4,5,6}, {7, 8,9}}
 * and N = 3
 * brr[] = {3, 6, 9}
 * Output : 15 9
 * Explanation:
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * So, this sum of left diagonal (1+ 5 + 9) = 15
 * The maximum element in an array brr is 9
 * So, will return {15, 9} as an answer.
 *
 *  *â€‹Example 2:
 *
 *  *Input : arr[][] = {{1,2}, {1, 2}} and N = 2
 * brr[] = {10, 1}
 * Output :  3 10  *
 *
 *  *Your Task:
 * This is a function problem. The input is already taken care of by the driver code. You only need to complete the function array() that takes a two-dimension array (a), another one dimension array (b), sizeOfArray (n), and return the ArrayList which is having the sum of the diagonal elements of the array a and the maximum number of the array b. The driver code takes care of the printing.
 *
 *  *Expected Time Complexity: O(N).
 * Expected Auxiliary Space: O(1).
 *
 *
 *
 *
 *  *Constraints
 * 1 ≤ n ≤ 100
 * 1 ≤ a[i][j], b[i] ≤ 103
 */
/**
 * Solution:
 * 1. Find the sum of the left diagonal elements of the 2-d array by iterating through the array and adding the elements at positions (i, i) for i from 0 to n-1.
 * 2. Find the maximum element of the 1-d array by iterating through the array and keeping track of the maximum value found.
 * 3. Return an ArrayList containing the sum of the diagonal elements and the maximum element
 *
 */
import java.util.ArrayList;

class Complete {

    public static ArrayList<Integer> array(int a[][], int b[], int n) {
        // Complete the function
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(getDiagonalSum(a, n));
        list.add(getMaxNumber(b, n));

        return list;

    }

    public static int getDiagonalSum(int a[][], int n) {
        int sum = 0;

        for (int i = 0, j = 0; i < n && j < n; i++, j++) {
            sum += a[i][j];
        }

        return sum;
    }

    public static int getMaxNumber(int b[], int n) {
        int max = Integer.MIN_VALUE;

        for (int num : b) {
            max = Math.max(max, num);
        }

        return max;
    }
}
