/**
 * Given a non-negative integer(without leading zeroes) represented as an array
 * arr. Your task is to add 1 to the number (increment the number by 1). The
 * digits are stored such that the most significant digit is at the starting
 * index of the array.
 * 
 * Examples:
 * 
 * Input: arr[] = [5, 6, 7, 8]
 * Output: [5, 6, 7, 9]
 * Explanation: 5678 + 1 = 5679
 * Input: arr[] = [9, 9, 9]
 * Output: [1, 0, 0, 0]
 * Explanation: 999 + 1 = 1000
 * Constraints:
 * 1 ≤ arr.size() ≤ 106
 * 0 ≤ arr[i] ≤ 9
 * There are no leading zeros in the input number.
 */
/**
 * SOLUTION: Use carry logic to add 1 to the number represented by the array.
 * Traverse the array from the end, if the digit is less than 9, simply
 * increment it and break. If the digit is 9, set it to 0 and continue to the
 * next digit. If after processing all digits, the first digit is 0, it means we
 * have a carry that needs to be added at the beginning of the result. Finally,
 * copy the modified array into a vector and return it.
 * DONT use sum of digits as it may run out of integer range for large numbers.
 */
class Solution {
    // Function for adding one to the number represented by the array
    Vector<Integer> addOne(int[] arr) {
        // code here
        // USE CARRY Logic; DON't try to sum of digit it may run out of integer range
        int n = arr.length;

        // Traverse array in back order
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < 9) {
                // add 1 to number and this will be final number
                arr[i]++;
                break;
            } else {
                // Make digit 9 as 0 and carry will be added to next iteration by arr[i]++
                arr[i] = 0;
            }
        }

        // Handle the case where each element will be 9
        Vector<Integer> ans = new Vector<>();
        // We cannot go beyond array[0], so if arr[0]==0 means one carry is left
        if (arr[0] == 0) {
            ans.add(1);
        }

        // Now copy original array to vector
        for (int x : arr) {
            ans.add(x);
        }
        return ans;

    }
}