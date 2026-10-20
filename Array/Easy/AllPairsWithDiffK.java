/**
 * Given an array arr[] of positive integers. Find the number of pairs of integers whose absolute difference equals to a given number k.
 * Note: (a, b) and (b, a) are considered the same. Also, the same numbers at different indices are considered different.
 * 
 * The answer is guaranteed to fit in a 32-bit integer.
 * 
 * Examples:
 * 
 * Input: arr[] = [1, 4, 1, 4, 5], k = 3
 * Output: 4
 * Explanation: There are 4 pairs with absolute difference 3, the pairs are {1, 4}, {1, 4}, {4, 1} and {1, 4}.
 * Input: arr[] = [8, 16, 12, 16, 4, 0], k = 4
 * Output: 5
 * Explanation: There are 5 pairs with absolute difference 4, the pairs are {8, 12}, {8, 4}, {16, 12}, {12, 16}, {4, 0}.
 * Constraints:
 * 1 <= arr.size() <= 2*105
 * 1 <= k <= 2*105
 * 0 <= arr[i] <= 105
 */
/**
 * Solution: We can use a HashMap to store the frequency of each element in the array.
 * Then, for each element in the array, we can check if the complement (arr[i
 * ] + k) or (arr[i] - k) exists in the HashMap. If it does, we can increment 
 * the count of pairs by the frequency of the complement.
 * 
 * Time Complexity: O(n), where n is the length of the array. We are iterating through 
 * the array once to populate the HashMap and then iterating through it again to count 
 * the pairs.
 * Space Complexity: O(n), as we are using a HashMap to store the frequency of each 
 * element in the array.
 */
import java.util.HashMap;
class AllPairsWithDiffK {
    int countPairs(int[] arr, int k) {
        // code here
       int n = arr.length;  
       HashMap<Integer, Integer> freq = new HashMap<>();
       int cnt = 0;

       for (int i = 0; i < n; i++) {

           // Check if the complement (arr[i] + k)
           // exists in the map. If yes, increment count
           if (freq.containsKey(arr[i] + k)) 
               cnt += freq.get(arr[i] + k); 

           // Check if the complement (arr[i] - k)
           // exists in the map. If yes, increment count
           if (freq.containsKey(arr[i] - k)) 
               cnt += freq.get(arr[i] - k); 

           // Increment the frequency of arr[i]
           freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1); 
       }
       return cnt;
    }
}