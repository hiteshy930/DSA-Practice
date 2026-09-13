/**
 * Given an array arr of distinct elements, the task is to rearrange the
 * elements of the array in a zig-zag fashion so that the converted array should
 * be in the below form:
 * 
 * arr[0] < arr[1] > arr[2] < arr[3] > arr[4] < . . . . arr[n-2] < arr[n-1] >
 * arr[n].
 * 
 * Note: Modify the given arr[] only, If your transformation is correct, the
 * output will be "true" else the output will be "false".
 * 
 * Examples
 * 
 * Input: arr[] = [4, 3, 7, 8, 6, 2, 1]
 * Output: true
 * Explanation: After modification the array will look like 3 < 7 > 4 < 8 > 2 <
 * 6 > 1, the checker in the driver code will produce 1.
 * Input: arr[] = [4, 7, 3, 8, 2]
 * Output: true
 * Explanation: After modification the array will look like 4 < 7 > 3 < 8 > 2
 * hence output will be 1.
 * Input: arr[] = [2, 8, 1, 7, 5, 9]
 * Output: true
 * Constraints:
 * 1 <= arr.size() <= 106
 * 0 <= arri <= 108
 */

/**
 * Solution explanation below:
 * 1. Iterate through the array starting from the second element (index 1) and incrementing by 2 in each iteration.
 * 2. For each element at index i, check if the previous element (arr[i-1]) is greater than the current element (arr[i]). If it is, swap the two elements to ensure that arr[i-1] < arr[i].
 * 3. Next, check if the next element (arr[i+1]) exists and if it is greater than the current element (arr[i]). If it is, swap the two elements
 * to ensure that arr[i] > arr[i+1].
 * 4. Repeat this process for all elements in the array.
 * 5. After processing the entire array, the elements will be rearranged in a zig-zag fashion.
 * 
 * Time Complexity: O(n), where n is the size of the input array. We iterate through the array once to rearrange the elements in zig-zag fashion.
 * Space Complexity: O(1), as we are modifying the input array in place and not
 * 
 */

class ConvertZigZag {
    public static void zigZag(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i += 2) {

            // arr[i-1] < arr[i]
            if (arr[i - 1] > arr[i]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }

            // arr[i] > arr[i+1]
            if (i + 1 < n && arr[i + 1] > arr[i]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }
}