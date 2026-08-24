/**
 * Given an array arr[] representing the size of candles which is reduced by 1
 * unit each day. The room is illuminated using all the present candles. Find
 * the maximum number of days the room will stay illuminated (at least one
 * candle having a size greater than 0)
 * 
 * Examples:
 * 
 * Input: arr[] = [1, 1, 2]
 * Output: 2
 * Explanation: The candle's length is reduced by 1 in first day. So, at the end
 * of day 1: Sizes would be [0 0 1], So, at end of second day: Sizes would be [0
 * 0 0]. This means the room was illuminated for 2 days.
 * Input: arr[] = [2, 3, 4, 2, 1]
 * Output: 4
 * Constraints:
 * 1 ≤ arr.size() ≤ 106
 * 1 ≤ arr[i] ≤ 109
 */

/**
 * Solution:
 * Understand the problem, problem is each candle in array is reduced by 1 unit
 * each day, so the maximum number of days the room will stay illuminated is
 * equal to the maximum length of candle in the array. So, we can find the
 * maximum length of candle in the array and return it as the answer.
 * 
 * 1. Find the maximum length of candle in the array.
 * 2. Return the maximum length of candle as the answer.
 */
class FightingDarkness {
    public int maxDays(int arr[]) {
        // code here
        int n = arr.length;
        int maxLengthCandle = Integer.MIN_VALUE;

        for (int num : arr) {
            maxLengthCandle = Math.max(maxLengthCandle, num);
        }

        return maxLengthCandle;
    }
}