/**
 * Given an array arr[] of integers, determine whether it is possible to rearrange the array using any number of swaps between adjacent elements - so that no two adjacent elements in the resulting array are equal.
 *
 * Examples:

 * Input: arr[] = [1, 1, 2]
 * Output: true
 * Explanation: Swapping the last two elements gives [1, 2, 1], where no two adjacent elements are equal.
 * Input: arr[] = [7, 7, 7, 7]
 * Output: false
 * Explanation: Every element is identical, so any arrangement will always have equal adjacent elements - no sequence of swaps can fix this.
 * Constraints:
 * 1 ≤ arr.size() ≤ 106
 * 1 ≤ arr[i] ≤ 105
 *
 */

/**
 * Solution explanation below:
 * 1. Create a frequency array to count the occurrences of each element in the
 * input array.
 * 2. Iterate through the input array and update the frequency array
 * accordingly.
 * 3. Keep track of the maximum frequency encountered during the iteration.
 * 4. After processing the entire array, check if the maximum frequency is less
 * than or equal to (n + 1) / 2, where n is the size of the input
 * array. This condition ensures that no element appears more than half the
 * time, which would make it impossible to arrange the elements such that no two
 * adjacent elements are the same.
 * 5. If the condition is satisfied, return true; otherwise, return false.
 * 
 * Why this solution(count max frequency) works:
 * The solution works because if the maximum frequency of any element is greater
 * than (n +
 * 1) / 2, it means that there are too many occurrences of that element to be
 * able to place them in the array without having at least two of them adjacent
 * to each other. By ensuring that the maximum frequency is less than or equal
 * to (n + 1) / 2, we can guarantee that it is possible to arrange the elements
 * in such a way that no two adjacent elements are the same.
 * 
 * Time Complexity: O(n), where n is the size of the input array. We iterate
 * through the array once to build the frequency array and find the maximum
 * frequency.
 * Space Complexity: O(k), where k is the range of the input values (in this
 */
class DifferentAdjacentElements {
    boolean distinctAdjacent(int[] arr) {
        int n = arr.length;

        int[] freq = new int[100001];
        int maxFreq = 0;

        for (int x : arr) {
            freq[x]++;
            maxFreq = Math.max(maxFreq, freq[x]);
        }

        return maxFreq <= (n + 1) / 2;
    }
}
