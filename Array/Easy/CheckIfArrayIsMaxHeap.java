
/**
 * Given an array arr[], determine whether it represents the level-order traversal of a valid max heap. Return true if it does; otherwise, return false.
 *
 * Examples :
 *
 * Input: arr[] = [90, 15, 10, 7, 12, 2]
 * Output: true
 * Explanation: The given array represents the following tree. Each parent node is greater than or equal to its children, so the max-heap property holds.
 *
 * Input: arr[] = [9, 15, 10, 7, 12, 11]
 * Output: false
 * Explanation: The given array represents the following tree. It does not satisfy the max-heap property, as 9 is smaller than 15 and 10, and 10 is smaller than 11.
 *
 * Constraints:
 * 1 ≤ n ≤ 105
 * 1 ≤ arr[i] ≤ 105
 */

/**
 * Solution: using the property of a max heap,
 * we can check if each parent node is greater than or equal to its children.
 * For a node at index i, its left child is at index 2*i + 1 and its right child
 * is at index 2*i + 2. We can iterate through the array and check if each parent node
 * satisfies this condition.
 *
 * Time Complexity: O(n), where n is the length of the array. We need to check each
 * parent node in the array.
 * Space Complexity: O(1), as we are not using any additional data structures.
 */
class CheckIfArrayIsMaxHeap {

    public boolean isMaxHeap(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n / 2; i++) {
            // Calculate the indices of the left and right children of the current node
            // How?: For a node at index i, its left child is at index 2*i + 1 and 
            // right child is at index 2*i + 2
            int left = 2 * i + 1;
            // Calculate the index of the right child of the current node
            int right = 2 * i + 2;
            // Check if the current node is greater than or equal to its left child
            if (arr[i] < arr[left]) {
                return false;
            }
            // Check if the current node is greater than or equal to its right child
            if (right < n && arr[i] < arr[right]) {
                return false;
            }
        }

        return true;
    }
}
