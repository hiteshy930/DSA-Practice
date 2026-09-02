/**
 * You are given an array arr of numbers. Return the sum of all the elements
 * except the first and last elements.
 * 
 * Examples:
 * 
 * Input: arr[] = [5, 24, 39, 60, 15, 28, 27, 40, 50, 90]
 * Output: 283
 * Explanation: The sum of all the elements except the first and last element is
 * 283.
 * Input: arr[] = [5, 10, 1, 11]
 * Output: 11
 * Explanation: The sum of all the elements except the first and last element is
 * 11.
 * Input: arr[] = [5, 10]
 * Output: 0
 * Explanation: The sum of all the elements except the first and last element is
 * 0.
 * Constraints:
 * 2<=arr.size()<=105
 * 2<=arr[i]<=105
 */

/**
 * Solution explanation:
 * 1. Initialize a variable sum to 0.
 * 2. Iterate through the array starting from the second element (index 1) to the second last element (index arr.length - 2).
 * 3. Add each element to the sum variable.
 * 4. Return the sum after the loop ends.
 */
class SumExceptFirstAndLast {
    public int sumExceptFirstLast(int[] arr) {
        // code here
        
        int sum = 0;
        for(int i = 1; i < arr.length - 1; i++){
            sum += arr[i];
        }
        
        return sum;
    }
}