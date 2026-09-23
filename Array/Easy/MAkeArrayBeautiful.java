
/**
 * Given an array of negative and non-negative integers. You need to make the array beautiful.
 *
 * An array is beautiful if two adjacent integers, arr[i] and arr[i+1] are either negative or positive. You can do the following operation any number of times until the array becomes beautiful.
 * If two adjacent are different i.e. one of them is negative and other is positive, remove them.
 * Return the beautiful array after performing the above operation.
 * An empty array is also a beautiful array.
 * There can be multiple beautiful output arrays. For consistencty with the test cases, scan the array from left to right for removing two adjacent.
 * Note: 0 is considered a positive number in this context.
 *
 * Examples:
 *
 * Input: arr[] = [4, 2,-2, 1]
 * Output: [4, 1]
 * Explanation: As at indices 1 and 2 , 2 and -2 have different sign, they are removed. And the the final array is: [4, 1].
 * Input: arr[] = [2,-2, -1, 1]
 * Output: []
 * Explanation: As at indices 0 and 1, 2 and -2 have different sign, so they are removed. Now the array is 1 -1.Now 1 and -1 are also removed as they have different sign. So the final array is empty.
 *
 *  Constraints:
 * 1 ≤ arr.size() ≤ 105
 * -105 ≤ arr[i] ≤ 105
 */

/**
 * Solution: Using arraylist to store the beautiful array. 
 * We can iterate through the input array and check the last element
 * of the list and the current element of the input array. 
 * If they have the same sign, we add the current element to the list. 
 * If they have different signs, we remove the last element from the list. 
 * Finally, we return the list as the beautiful array.
 *
 * Time Complexity: O(n), where n is the size of the input array.
 * Space Complexity: O(n), as we are using an arraylist to store the beautiful array
 */
import java.util.ArrayList;
import java.util.List;

class MAkeArrayBeautiful {

    List<Integer> makeBeautiful(int[] arr) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (list.isEmpty()) {
                list.add(arr[i]);
            } else if ((list.get(list.size() - 1) >= 0 && arr[i] >= 0)
                    || (list.get(list.size() - 1) < 0 && arr[i] < 0)) {
                // Same sign
                list.add(arr[i]);
            } else {
                // Different signs -> remove the previous element
                list.remove(list.size() - 1);
            }
        }

        return list;
    }
}
