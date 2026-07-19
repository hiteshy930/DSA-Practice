
class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int sl = -1;
        int l = -1;
        // One Pass approach
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > l) {
                sl = l;
                l = arr[i];
            } else if (arr[i] < l && arr[i] > sl) {
                sl = arr[i];
            }
        }
        return sl;
    }
}

/*
 * Given an array of positive integers arr[] of size n, the task is to find
 * second largest distinct element in the array.
 * 
 * Note: If the second largest element does not exist, return -1.
 * 
 * Examples:
 * 
 * Input: arr[] = [12, 35, 1, 10, 34, 1]
 * Output: 34
 * Explanation: The largest element of the array is 35 and the second largest
 * element is 34.
 * 
 * Input: arr[] = [10, 5, 10]
 * Output: 5
 * Explanation: The largest element of the array is 10 and the second largest
 * element is 5.
 * 
 * Input: arr[] = [10, 10, 10]
 * Output: -1
 * Explanation: The largest element of the array is 10 there is no second
 * largest element.
 */