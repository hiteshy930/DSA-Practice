
/**
 * Given an array, arr[] of integers, 
 * your task is to return the smallest and second smallest element in the array.
 *  If the smallest and second smallest do not exist, return -1.
 * 
 * Examples:
 * Input: arr[] = [2, 4, 3, 5, 6]
 * Output: [2, 3] 
 * Explanation: 2 and 3 are respectively the smallest and second smallest elements in the array.
 * Input: arr[] = [1, 1, 1]
 * Output: [-1]
 * Explanation: Only element is 1 which is smallest, so there is no second smallest element.
 * Constraints:
 * 1 ≤ arr.size ≤105
 * 1 ≤ arr[i] ≤ 105
 */

/**
 * Solution: Find the first and second minimum elements in an array.
 * 
 */
import java.util.ArrayList;

class FirstAndSecondMinimum {
    public ArrayList<Integer> minAnd2ndMin(int[] arr) {
        // code here
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int second_min = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                second_min = min;
                min = Math.min(min, arr[i]);
            } else if (arr[i] > min && arr[i] < second_min) {
                second_min = Math.min(second_min, arr[i]);
            }
        }

        if (min == Integer.MAX_VALUE || second_min == Integer.MAX_VALUE) {
            list.add(-1);
        } else {

            list.add(min);
            list.add(second_min);
        }

        return list;
    }
}
