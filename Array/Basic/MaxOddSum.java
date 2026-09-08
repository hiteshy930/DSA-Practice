/**
 * Given an array arr[] of integers, determine whether a subsequence exists with
 * an odd sum. If such a subsequence exists, return the maximum possible odd
 * sum. If no subsequence with an odd sum can be formed, return -1.
 * 
 * Examples:
 * 
 * Input: arr = [4, -3, 3, -5]
 * Output: 7
 * Explanation: The subsequence with the maximum odd sum is [4, 3], and the sum
 * is 4 + 3 = 7.
 * Input: arr = [2, 5, -4, 3, -1]
 * Output: 9
 * Explanation: The subsequence with the maximum odd sum is [2, 5, 3, -1], and
 * the sum is 2 + 5 + 3 + (-1) = 9.
 * Constraints:
 * 1 ≤ arr.length ≤ 106
 * -103 ≤ arr[i] ≤ 103
 * 
 * 
 */

/**
 * Solution explanation:
 * 1. Initialize a variable positiveSum to store the sum of positive numbers in
 * the array.
 * 2. Initialize a variable smallestNegative to store the smallest absolute value
 * of negative numbers in the array.
 * 3. Initialize a boolean variable isOddNumber to check if any odd number exists
 * in the array.
 * 4. Iterate through the array and for each number:
 *   a. If the number is positive, add it to positiveSum.
 *  b. If the absolute value of the number is odd, set isOddNumber to true and
 * update smallestNegative with the minimum of its current value and the absolute value of the number.
 * 5. After iterating through the array, check if isOddNumber is false.
 *  a. If it is false, return -1 as no subsequence with an odd
 * sum can be formed.
 * 6. If positiveSum is odd, return positiveSum as the maximum possible odd sum.
 * 7. If positiveSum is even, return positiveSum - smallestNegative as the maximum
 * possible odd sum.
 * 
 * Time Complexity: O(n) where n is the size of the array.
 * Space Complexity: O(1) as we are using a constant amount of space.
 */
class MaxOddSum {
    public int findMaxOddSum(int[] arr) {
        // code here
        int positiveSum = 0;
        int smallestNegative = Integer.MAX_VALUE;
        boolean isOddNumber = false;
        for(int num : arr){
            if(num > 0){
                positiveSum += num;
            }
            
            //check if any odd number exists
            if(Math.abs(num)%2 != 0){
                isOddNumber = true;
                smallestNegative = Math.min(smallestNegative, Math.abs(num));
            }
        }
        
        if(!isOddNumber){
            return -1;
        }
        
        if(positiveSum%2 != 0){
            return positiveSum;
        }else{
            return positiveSum - smallestNegative;
        }
    }
}
