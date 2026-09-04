/**
 * Given an integer array arr[], count the number of distinct special integers.
 * An integer x is called a special integer if x - 1, x, and x + 1 are all
 * present in the array. Return the number of distinct special integers.
 * 
 * Examples:
 * 
 * Input: arr[] = [1, 2, 3, 3, 4]
 * Output: 2
 * Explanation: The special integers in this arr are 2 and 3.
 * Input: arr[] = [2, 3, 5, 7]
 * Output: 0
 * Explanation: There is no special integer in this arr.
 * Constraints:
 * 
 * 1 ≤ arr.size() ≤ 105
 * -109 ≤ arr[i] ≤ 109
 * 
 */

/**
 * Solution explanation: using HashMap
 * 1. Create a HashMap to store the value as 1.
 * 2. Iterate through the array and add each element to the HashMap.
 * 3. Iterate through the array again and check if x-1 and x+1 are present in the HashMap.
 * 4. If both are present, increment the count and set the value of x in the HashMap to 0 to avoid duplicate counting.
 * 5. Return the count of distinct special integers.
 * 
 * Time Complexity: O(n) where n is the size of the array.
 * Space Complexity: O(n) for storing the elements in the HashMap.
 * 
 */
import java.util.HashMap;
import java.util.Map;
class OccurenceOfConsecutiveNumbers {
    public int specialIntegers(int[] arr) {
        // code here
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int i = 0; i<n ; i++){
            map.put(arr[i], 1);
        }
        
        for(int num : arr){
            //Check if x-1 or x+1 present in map or not
            // also to avoid duplicate checking for a number
            if(map.containsKey(num-1) && map.containsKey(num + 1) && map.get(num) != 0){
                map.put(num, 0);
                count++;
            }
        }
        return count;
    }
}