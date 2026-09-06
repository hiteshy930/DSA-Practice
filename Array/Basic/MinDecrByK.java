/**
 * You are given an array arr[] and an integer k. In one operation you can
 * choose any element of array and decrease its value by k.
 * 
 * Find the minimum number of operation such that all the elements in the array
 * becomes less or equal to k.
 * 
 * Examples:
 * 
 * Input: arr[] = [5, 3, 2, 6, 8] and k = 5
 * Output: 2
 * Explanation:
 * Elements 5, 3, and 2 are already less than or equal to 5.
 * Element 6 can be reduced by 5 in one operation to become 1.
 * Element 8 can be reduced by 5 in one operation to become 3.
 * Thus, a total of 2 operations are required.
 * Input: arr[] = [2, 6, 4, 8, 1, 6] and k = 4
 * Output: 3
 * Explanation:
 * Elements 2, 4, and 1 are already less than or equal to 4.
 * Each occurrence of 6 can be reduced by 4 in one operation to become 2,
 * requiring 2 operations.
 * Element 8 can be reduced by 4 in one operation to become 4, requiring 1
 * operation.
 * Therefore, the minimum number of operations required is 3.
 * Constraints :
 * 1 ≤ arr.size() ≤ 2*104
 * 1 ≤ k ≤ 105
 * 1 ≤ arr[i] ≤ 105
 */

/**
 * Solution explanation: using simple iteration
 * 1. Initialize a variable noOfOperations to 0.
 * 2. Iterate through each element in the array.
 * 3. For each element, while it is greater than k, increment noOfOperations
 * and decrease the element by k.
 * 4. Return noOfOperations as the minimum number of operations required.
 * 
 * Time Complexity: O(n * m) where n is the size of the array and m is the number of times an element can be decreased by k.
 * Space Complexity: O(1) as we are using a constant amount of space.
 */

class MinDecrByK {
    public int minOps(int[] arr, int k) {
        // code here
        int n = arr.length;
        int noOfOperations = 0;
        
        for(int num : arr){
            int count = 0;
            while(num > k){
                noOfOperations++;
                num = num - k;      
            }
        }
        
        return noOfOperations;
    }
}