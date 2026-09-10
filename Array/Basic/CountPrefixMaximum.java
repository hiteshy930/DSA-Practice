/**
 * Given an array {@code arr} of integers, find the number of elements such that
 * all the elements before them are smaller. The first element is always counted
 * because there are no elements before it.
 *
 * <p>Examples:</p>
 *
 * <pre>
 * Input: arr = [10, 40, 23, 35, 50, 7]
 * Output: 3
 * Explanation: The elements 10, 40, and 50 are such that all preceding elements
 * are smaller. Thus, the count is 3.
 *
 * Input: arr = [5, 4, 1]
 * Output: 1
 * Explanation: Only the first element 5 is such that all preceding elements
 * (none in this case) are smaller. Thus, the count is 1.
 * </pre>
 *
 * <p>Constraints:</p>
 *
 * <ul>
 *   <li>{@code 1 <= arr.size() <= 10^6}</li>
 *   <li>{@code 1 <= arr[i] <= 10^9}</li>
 * </ul>
 */

/**
 * Solution:
 */

class CountPrefixMaximum {
    public int countElements(int[] arr) {
        // code here
         int n = arr.length;
         int current_max = arr[0];
         int current_max_index = -1;
         int result = 1;

         for(int i=0; i<n; i++){
             if(arr[i] > current_max && current_max_index < i){
                 current_max_index = i;
                 current_max = arr[i];
                 result +=1;
             }
         }
         return result;
    }
}
