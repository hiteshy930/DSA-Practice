/**
 * Given an unsorted array arr[] of integers and a key which is present in this array. Find the start index (index where the element is first found from left in the array) and end index (index where the element is first found from right in the array). Return an array of length 2 with elements start index and end index.

 * Note: If the key does not exist in the array then return -1 for both start and end index.

 * Examples:

 * Input: arr[] = [1, 2, 3, 4, 5, 5], key = 5
 * Output: [4, 5]
 * Explanation: 5 appears first time at index 4 and appears last time at index 5.
 * Input: arr = [6, 5, 4, 3, 1, 2], key = 4
 * Output: [2, 2]
 * Explanation: 4 appears first time and last time at index 2.
 * Input: arr = [7, 8, 6], key = 2
 * Output: [-1, -1]
 * Explanation: Since 2 does not appear in the array, we will return -1 for both the start and end indices.
 * Constraints:
 * 1 ≤ arr.size ≤ 105
 * 1 ≤ arr[i], key ≤ 109 
 */

/**
 * Solution: using two pointers approach
 * 1. Initialize two pointers, one starting from the beginning of the array (i) and the other starting from the end of the array (j).
 * 2. Iterate through the array using a for loop, with i incrementing from the start and j decrementing from the end.
 * 3. For each iteration, check if the element at index i is equal to the key and if the left index has not been found yet. If so, update the left index in the result array.
 * 4. Similarly, check if the element at index j is equal to the key and if the right index has not been found yet. If so, update the right index in the result array.
 * 5. After the loop, check if the left index was found. If not, set it to -1 in the result array. Do the same for the right index.
 * 6. Return the result array containing the start and end indices of the key in the input array.   
 * 
 * Time Complexity: O(n), where n is the size of the array arr[].
 * Space Complexity: O(1), as we are using only a constant amount of extra space
 * 
 * Another Solution: using two loops approach
 * 1. Initialize two variables, leftIndex and rightIndex, to -1.
 * 2. Iterate through the array arr[] using a for loop to find the left index
 * 3. For each element arr[i], check if it is equal to the key. If it is, update leftIndex to i and break the loop.
 * 4. Iterate through the array arr[] in reverse order using another for loop to find
 * the right index
 * 5. For each element arr[j], check if it is equal to the key. If it is, update rightIndex to j and break the loop.
 * 6. Return an array containing leftIndex and rightIndex.
 * 
 * Time Complexity: O(n), where n is the size of the array arr[].
 * Space Complexity: O(1), as we are using only a constant amount of extra space
 */

import java.util.ArrayList;
class FirstAndLastInUnsortedArray {
    public ArrayList<Integer> findIndex(int[] arr, int key) {
        // code here
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(1);
        
        boolean leftFound = false;
        boolean rightFound = false;
        
        for(int i =0, j=n-1; i<=n-1&& j>=0; i++, j--){
            if(arr[i] == key && leftFound == false){
                leftFound = true;
                result.set(0, i);
            }
            
            if(arr[j] == key && rightFound == false){
                rightFound = true;
                result.set(1, j);
            }
        }
        
        if(leftFound == false){
            result.set(0, -1);
        }
        
        if(rightFound == false){
            result.set(1, -1);
        }
        
        return result;
    }
};