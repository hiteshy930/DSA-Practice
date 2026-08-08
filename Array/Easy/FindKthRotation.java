/**
 * Given an increasing sorted rotated array arr[] of distinct integers. The
 * array is right-rotated k times. Find the value of k.
 * Let's suppose we have an array arr[] = [2, 4, 6, 9], if we rotate it by 2
 * times it will look like this:
 * After 1st Rotation : [9, 2, 4, 6]
 * After 2nd Rotation : [6, 9, 2, 4]
 * 
 * Examples:
 * 
 * Input: arr[] = [5, 1, 2, 3, 4]
 * Output: 1
 * Explanation: The given array is [5, 1, 2, 3, 4]. The original sorted array is
 * [1, 2, 3, 4, 5]. We can see that the array was rotated 1 times to the right.
 * Input: arr = [1, 2, 3, 4, 5]
 * Output: 0
 * Explanation: The given array is not rotated.
 * Constraints:
 * 1 ≤ arr.size() ≤ 105
 * 1 ≤ arr[i] ≤ 107
 */
/**
 * Question Explanation: Given array will be already in k times roation. we need
 * to find the value of k.
 * 
 * SOLUTION:
 * 
 *  The value of k will be equal to the index of the
 * minimum element in the array. We can find the minimum element in the array
 * using binary search.
 */

class FindKthRotation {
    public int findKRotation(int arr[]) {
        // Code here
        int n= arr.length;
        int min_value = Integer.MAX_VALUE;
        int min_value_index = 0;
        
        for(int i=0; i<n; i++){
            if(arr[i] <= min_value){
                min_value = arr[i];
                min_value_index = i;
            }
        }
        return min_value_index;
    }
}
