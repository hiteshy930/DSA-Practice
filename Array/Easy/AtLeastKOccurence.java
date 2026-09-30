/**
 * Given an array arr. Return the element that occurs at least k number of times.
 * 
 * Note:
 * 
 * If there are multiple answers, please return the first one.
 * If there is no element found, return -1.
 * Examples
 * 
 * Input: arr[] = [1, 7, 4, 3, 4, 8, 7], k = 2
 * Output: 4
 * Explanation: Both 7 and 4 occur 2 times. But 4 is first that occurs twice. As the index = 4, is the first element.
 * Input:  arr[] = [3, 1, 3, 4, 5, 1, 3, 3, 5, 4], k = 3
 * Output: 3
 * Explanation: Here, 3 is the only number that appeared atleast 3 times in the array.
 * Input: arr[] = [10, 8, 2], k = 10
 * Output: -1
 * Explanation: Here no element is returning atleast 10 number of times, so -1.
 * Constraints:
 * 
 * 1 ≤ arr.size() ≤ 106
 * 0 ≤ arr[i] ≤ 106
 * 1 ≤ k ≤ 103
 */

/**
 * Solution: Using a HashMap to store the frequency of each element in the array.
 * 1. Initialize a HashMap to store the frequency of each element in the array.
 * 2. Iterate through the array arr[] using a for-each loop.
 * 3. For each element num in arr[], check if it is already present in the HashMap.
 *    If it is present, increment its frequency by 1. Otherwise, add it to the HashMap 
 *    with a frequency of 1.
 * 4. After updating the frequency, check if the frequency of the current element num is equal to k.
 *    If it is, return the current element num as it is the first element that occurs
 *    at least k times in the array.
 * 5. If no element is found that occurs at least k times, return -1
 * 
 * Time Complexity: O(n), where n is the size of the array arr[].
 * Space Complexity: O(n), as we are using a HashMap to store the frequency of
 */
import java.util.HashMap;
import java.util.Map;
class AtLeastKOccurence {
    public int firstElementKTime(int[] arr, int k) {
        // write code
        int n = arr.length;
        Map<Integer, Integer> set = new HashMap<>();
        
        for(int num : arr){
            if(set.containsKey(num)){
            set.put(num, set.get(num)+1);
            }else{
                set.put(num, 1);
            }
            
            if(set.get(num) == k){
                return num;
            }
        }
        
        return -1;
    }
}