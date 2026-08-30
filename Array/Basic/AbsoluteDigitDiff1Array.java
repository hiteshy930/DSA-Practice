
/**
 * Given an array arr[] and a number k,  find all the numbers less than k that have at least two digits and the absolute difference between every adjacent digit of that number should be 1.
 *
 *  *Note: Return an empty list if no such number is present.
 *
 *  *Examples:
 *
 *  *Input: arr[] = [7, 98, 56, 43, 45, 23, 12, 8], k = 54
 * Output: [43, 45, 23, 12]
 * Explanation: 43 45 23 12 all these numbers have adjacent digits diff as 1 and they are less than 54.
 * Input: arr[] = [87, 89, 45, 235, 465, 765, 123, 987, 499, 655], k = 1000
 * Output: [87, 89, 45, 765, 123, 987]
 * Explanation: 87 89 45 765 123 987 all these numbers have adjacent digits diff as 1 and they are less than 1000.
 * Constraints:
 *
 *  *1 ≤ k, arr.size(), arr[i] ≤ 106
 */
/**
 * Solution Explanation:
 * 1. Iterate through the given array and check for each number if it has at least
 * two digits and is less than k.
 * 2. For each valid number, check if the absolute difference between every adjacent digit is
 * 1 using the isDiff1() method.
 * 3. If the number satisfies both conditions, add it to a temporary array.
 * 4. Finally, create a result array of the exact required size and copy the valid
 * numbers from the temporary array to the result array.
 * 5. Return the result array.
 *
 */
class AbsoluteDigitDiff1Array {

    int[] getDigitDiff1AndLessK(int[] arr, int k) {

        int n = arr.length;
        int[] temp = new int[n];
        int tempIndex = 0;

        for (int i = 0; i < n; i++) {

            // Must be at least 2 digits and less than k
            if (arr[i] >= 10 && arr[i] < k) {
                if (isDiff1(arr[i])) {
                    temp[tempIndex] = arr[i];
                    tempIndex++;
                }
            }
        }

        // Create result array of exact required size
        int[] result = new int[tempIndex];

        for (int i = 0; i < tempIndex; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    public boolean isDiff1(int num) {

        int previousDigit = num % 10;
        num = num / 10;

        while (num > 0) {

            int currentDigit = num % 10;

            if (Math.abs(previousDigit - currentDigit) != 1) {
                return false;
            }

            previousDigit = currentDigit;
            num = num / 10;
        }

        return true;
    }
}
