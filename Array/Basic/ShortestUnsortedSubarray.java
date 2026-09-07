/**
 * Given an array arr of distinct numbers. Find the length of the shortest
 * unordered (neither increasing nor decreasing) subarray in the given array. If
 * there is no subarray then return 0.
 * 
 * Examples:
 * 
 * Input: arr[] = [7, 9, 10, 8, 11]
 * Output: 3
 * Explanation: Shortest unsorted subarray is 9, 10, 8 which is of 3 elements.
 * Input: arr[] = [1, 2, 3, 5]
 * Output: 0
 * Explanation: There is no unsorted subarray.
 * Constraints:
 * 1 <= arr.size() <= 106
 * 1 <= arr[i] <= 105
 */

/**
 * Solution explanation: using peak and valley concept
 * 1. Iterate through the array from index 1 to n-1.
 * 2. For each element, check if it is a peak (greater than its neighbors) or a valley (less than its neighbors).
 * 3. If a peak or valley is found, return 3 as the length of the shortest unordered subarray.
 * 4. If no peak or valley is found, return 0 as there is no unordered subarray.
 * 
 * Time Complexity: O(n) where n is the size of the array.
 * Space Complexity: O(1) as we are using a constant amount of space.
 */

class ShortestUnsortedSubarray {
    public int shortestUnorderedSubarray(int arr[]) {
        // Code Here
        int n = arr.length;
        
        for (int i = 1; i < n - 1; i++) {
           // If middle element is a peak or valley,
           // unordered triplet exists
           if ((arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
               || (arr[i] < arr[i - 1]
                   && arr[i] < arr[i + 1])) {
               return 3;
           }
       }

        return 0;
    }
}