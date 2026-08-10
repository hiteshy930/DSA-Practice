/**
 * Given an array, arr[] construct a product array, res[] where each element in
 * res[i] is the product of all elements in arr[] except arr[i]. Return this
 * resultant array, res[].
 * Note: Each element is res[] lies inside the 32-bit integer range.
 * 
 * Examples:
 * 
 * Input: arr[] = [10, 3, 5, 6, 2]
 * Output: [180, 600, 360, 300, 900]
 * Explanation: For i=0, res[i] = 3 * 5 * 6 * 2 is 180.
 * For i = 1, res[i] = 10 * 5 * 6 * 2 is 600.
 * For i = 2, res[i] = 10 * 3 * 6 * 2 is 360.
 * For i = 3, res[i] = 10 * 3 * 5 * 2 is 300.
 * For i = 4, res[i] = 10 * 3 * 5 * 6 is 900.
 * Input: arr[] = [12, 0]
 * Output: [0, 12]
 * Explanation: For i = 0, res[i] is 0.
 * For i = 1, res[i] is 12.
 * Constraints:
 * 2 <= arr.size() <= 105
 * -100 <= arr[i] <= 100
 */

/**
 * Solution:
 * Find product of full array and then divide it by arr[i] to get res[i]. If
 * arr[i] is 0, then we need to find product of all other elements except
 * arr[i].
 */
class ProductArrayPuzzle {
    public static int[] productExceptSelf(int arr[]) {

        int n = arr.length;
        int[] res = new int[n];

        int product = 1;
        int zeroCount = 0;

        // Find product of non-zero elements
        // and count zeros
        for (int i = 0; i < n; i++) {

            if (arr[i] == 0) {
                zeroCount++;
            } else {
                product *= arr[i];
            }
        }

        // More than one zero, all products will be zero
        if (zeroCount > 1) {
            return res;
        }

        // Exactly one zero, only the index with zero will have product of other elements
        if (zeroCount == 1) {

            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) {
                    res[i] = product;
                }
            }

            return res;
        }

        // No zeros, calculate product for each index 
        for (int i = 0; i < n; i++) {
            res[i] = product / arr[i];
        }

        return res;
    }
}