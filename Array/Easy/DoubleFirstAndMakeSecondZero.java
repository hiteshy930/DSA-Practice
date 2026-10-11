/**
 * Given an array arr[] of size n, modify it such that if two adjacent elements are equal and non-zero, double the first element and replace the second element with 0. After processing the entire array, move all 0s to the end while maintaining the relative order of the non-zero elements. Return the modified array.
 * 
 * Examples:
 *
 * Input: arr[] = [2, 2, 0, 4, 0, 8] 
 * Output: [4, 4, 8, 0, 0, 0] 
 * Explanation: At index 0 and 1 both the elements are the same. So, we change the element at index 0 to 4 and the element at index 1 is 0 then shift all the zeros to the end of the array [4,4,8,0,0,0].
 * Input: arr[] = [0, 2, 2, 2, 0, 6, 6, 0, 0, 8] 
 * Output: [4, 2, 12, 8, 0, 0, 0, 0, 0, 0]
 * Explanation: Elements at indices 1 and 2 are equal and non-zero, so they are replaced by 4 and 0. Similarly, elements at indices 5 and 6 are replaced by 12 and 0. After moving all 0s to the end, the final array becomes [4, 2, 12, 8, 0, 0, 0, 0, 0, 0].
 * Constraints:
 * 1 ≤ arr.size() ≤ 105
 * 0 ≤ arr[i] ≤ 106
 *
 */

/**
 * Solution: Using ArrayList
 * 1. Create an ArrayList to store the result.
 * 2. Iterate through the input array and for each pair of adjacent elements, check if
 *    they are equal and non-zero. If they are, double the first element and set the second
 *    element to 0.
 * 3. After processing the entire array, iterate through the modified array and add all 
 *    non-zero elements to the result list.
 * 4. Finally, add zeros to the end of the result list until its size matches
 *    the original array size.
 * 5. Return the result list.
 * 
 * Time Complexity: O(n), where n is the size of the input array.
 * Space Complexity: O(n), as we are using an ArrayList to store the result. 
 */
import java.util.ArrayList;
class DoubleFirstAndMakeSecondZero {
    public ArrayList<Integer> modifyArray(int arr[]) {
        // code here
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0, j = i+1; j<n; i++, j++){
            if(arr[i] == arr[j]){
                arr[i] += arr[i];
                arr[j] = 0;
            }
        }
        
        for(int num : arr){
            if(num > 0){
                list.add(num);
            }
        }
        
        while(list.size() < n){
            list.add(0);
        }
        
        return list;
    }
}
