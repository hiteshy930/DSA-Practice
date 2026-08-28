
/**
 * Given an array {@code arr[]}, construct its sum triangle as follows:
 *
 * <p>
 * The bottom row of the triangle is the original array. Each element in the row
 * above is formed by adding the two adjacent elements directly below it.
 * Continue until only one element remains at the top of the triangle.</p>
 *
 * <p>
 * Return all elements of the sum triangle in top-to-bottom order and, within
 * each row, from left to right.</p>
 *
 * <p>
 * Example 1:</p>
 *
 * <pre>
 * Input:  arr[] = [4, 7, 3, 6, 7]
 * Output: [81, 40, 41, 21, 19, 22, 11, 10, 9, 13, 4, 7, 3, 6, 7]
 *
 *        81
 *      40  41
 *    21  19  22
 *  11  10   9   13
 * 4   7   3   6    7
 * </pre>
 *
 * <p>
 * The rows are constructed from bottom to top:</p>
 *
 * <pre>
 * [4, 7, 3, 6, 7]
 * [11, 10, 9, 13]
 * [21, 19, 22]
 * [40, 41]
 * [81]
 * </pre>
 *
 * <p>
 * Example 2:</p>
 *
 * <pre>
 * Input:  arr[] = [1, 2, 4]
 * Output: [9, 3, 6, 1, 2, 4]
 *
 *    9
 *  3   6
 * 1  2  4
 * </pre>
 *
 * <p>
 * Constraints:</p>
 * <ul>
 * <li>{@code 1 <= arr.size() <= 25}</li>
 * <li>{@code 1 <= arr[i] <= 100}</li>
 * </ul>
 */

/**
 * Solution explanation:
 * The problem requires constructing a sum triangle from a given array. The approach involves recursively calculating the sum of adjacent elements to form the next row of the triangle until only one element remains. The final result is collected in a list that contains all elements of the triangle in top-to-bottom order.
 *
 * Time Complexity: O(n^2) - Each level of the triangle requires summing adjacent elements, and there are n levels.
 * Space Complexity: O(n^2) - The result list stores all elements of the triangle, which can be up to n(n+1)/2 elements.
 *
 * 1. Start with the original array as the bottom row of the triangle.
 *  2. Recursively compute the next row by summing adjacent elements of the current row.
 * 3. Continue this process until only one element remains at the top of the triangle
 * 4. Collect all elements in a list in top-to-bottom order and return it.
 * 5. The recursive function handles the construction of the triangle and the 
 *    collection of elements.
 * 6. The base case for the recursion is when the list has only one element, 
 *    at which point it returns that list.
 * 7. The recursive function builds the triangle by creating a new list for each row and
 *    adding the sums of adjacent elements from the current row.
 * 8. Finally, the function combines the current row with the results from the recursive
 *    call to build the complete triangle in the desired order.
 *
 */
import java.util.ArrayList;

class Solution {

    public ArrayList<Integer> getTriangle(int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();

        for (int x : arr) {
            list.add(x);
        }

        return getList(list);
    }

    public ArrayList<Integer> getList(ArrayList<Integer> list) {

        if (list.size() == 1) {
            return list;
        }

        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < list.size() - 1; i++) {
            int sum = list.get(i) + list.get(i + 1);
            temp.add(sum);
        }

        //
        ArrayList<Integer> ans = getList(temp);

        //add current list to ans list
        ans.addAll(list);

        return ans;
    }
}
