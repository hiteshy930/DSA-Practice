/**
 * Given an array arr of even size, sort the first half of the array in
 * ascending order and the second half in descending order.
 * 
 * Examples :
 * 
 * Input: arr[] = [10, 20, 30, 40]
 * Output: [10, 20, 40, 30]
 * Explanation:
 * The array is divided into two equal halves: [10, 20] and [30, 40].
 * The first half is already in ascending order, so it remains [10, 20].
 * The second half is sorted in descending order, changing [30, 40] to [40, 30].
 * Thus, the final array becomes [10, 20, 40, 30].
 * Input: arr[] = [5, 4, 6, 2, 3, 8, 9, 7]
 * Output: [2, 4, 5, 6, 9, 8, 7, 3]
 * Explanation:
 * The array is divided into two equal halves: [5, 4, 6, 2] and [3, 8, 9, 7].
 * Sorting the first half in ascending order gives [2, 4, 5, 6].
 * Sorting the second half in descending order gives [9, 8, 7, 3].
 * Combining both halves, the final array becomes [2, 4, 5, 6, 9, 8, 7, 3].
 * Constraints:
 * 1 ≤ arr.size() ≤ 105
 * 1 ≤ arr[i] ≤ 106
 */

/**
 * Solution explanation: using ArrayList
 * 1. Initialize two ArrayLists first_half and second_half to store the first and second
 *   halves of the array respectively.
 * 2. Iterate through the first half of the array and add the elements to first_half.
 * 3. Iterate through the second half of the array and add the elements to second_half
 *  respectively.
 * 4. Sort first_half in ascending order and second_half in descending order.
 * 5. Create a new ArrayList result and add all elements from first_half followed by
 *  all elements from second_half.
 * 6. Return the result ArrayList.
 * 
 * Time Complexity: O(n log n) due to sorting of both halves.
 * Space Complexity: O(n) for storing the two halves and the result.
 */
import java.util.ArrayList;
import java.util.Collections;
class HalfAscHalfDesc {
    public ArrayList<Integer> customSort(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> first_half = new ArrayList<>();
        ArrayList<Integer> second_half = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<n/2; i++){
            first_half.add(arr[i]);
        }
        
        for(int i=n/2; i<n; i++){
            second_half.add(arr[i]);
        }
        
        Collections.sort(first_half);
        Collections.sort(second_half, Collections.reverseOrder());
        
        result.addAll(first_half);
        result.addAll(second_half);
        return result;
        
    }
    
   
}