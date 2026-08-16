
/**
 * Given an array arr[] consisting of only 0's and 1's. Modify the array
 * in-place to segregate 0s onto the left side and 1s onto the right side of the
 * array.
 * 
 * Examples :
 * 
 * Input: arr[] = [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
 * Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]
 * Explanation: After segregation, all the 0's are on the left and 1's are on
 * the right. Modified array will be [0, 0, 0, 0, 0, 1, 1, 1, 1, 1].
 * Input: arr[] = [1, 1]
 * Output: [1, 1]
 * Explanation: There are no 0s in the given array, so the modified array is [1,
 * 1]
 * Constraints:
 * 1 ≤ arr.size() ≤ 105
 * 0 ≤ arr[i] ≤ 1
 */

/**
 * Solution:
 * 1. Create a temporary array to store the 0's from the original array.
 * 2. Iterate through the original array and add all the 0's to the temporary
 * array.
 * 3. After that, fill the original array with the 0's from the temporary
 * array and then fill the rest of the original array with 1's.
 * 4. This will segregate the 0's and 1's in the original array.
 * 5. The time complexity of this solution is O(n) and the space complexity is O(n) 
 * as we are using a temporary array to store the 0's.
 */
import java.util.ArrayList;

class Segregate0and1 {
    void segregate0and1(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        // track zero and set into one temp array
        for (int num : arr) {
            if (num == 0) {
                temp.add(num);
            }
        }
        int temp_length = temp.size();
        for (int i = 0; i < n; i++) {
            if (i < temp_length) {
                arr[i] = temp.get(i);
            } else {
                arr[i] = 1;
            }
        }
    }
}
