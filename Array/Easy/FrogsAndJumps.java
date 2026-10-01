/**
 * Frogs are positioned at one end of a pond, and each wants to reach the other end. The pond has some leaves arranged in a straight line.
 * 
 * Each frog has a strength s, meaning it jumps exactly s leaves at a time - for example, a frog with strength 2 visits leaves 2, 4, 6, and so on while crossing the pond.
 * 
 * Given the strength of each frog (as an array arr[]) and the total number of leaves k, find how many leaves are not visited by any frog after all frogs have crossed the pond.
 * 
 * Examples:
 * 
 * Input: arr[] = [3, 2, 4], k = 4
 * Output: 1
 * Explanation: Frog with strength 3 visits leaf 3. Frog with strength 2 visits leaves 2, 4. Frog with strength 4 visits leaf 4. Leaf 1 is never visited by any frog.
 * Input: arr[] = [1, 3, 5], k = 6
 * Output: 0
 * Explanation: Frog with strength 1 visits leaves 1, 2, 3, 4, 5, 6 every leaf. All leaves are already covered, so none are left unvisited.
 * Constraints:
 * 1 ≤ n, k, arr[i] ≤ 105
 */

/**
 * Solution: Using a boolean array to keep track of the leaves that have been visited by the frogs.
 * 1. Initialize a boolean array visited[] of size k+1 to keep track of
 *    the leaves that have been visited by the frogs.
 * 2. Iterate through the array arr[] using a for-each loop.
 * 3. For each frog's strength s in arr[], mark all the leaves that the
 *    frog can visit by setting the corresponding indices in the visited[] array to true.
 * 4. After all frogs have crossed the pond, iterate through the visited[] array and
 *    count the number of leaves that have not been visited by any frog.
 * 5. Return the count of unvisited leaves.
 * 
 * Time Complexity: O(n*k), where n is the size of the array arr[] and k is the total number of leaves.
 * Space Complexity: O(k), as we are using a boolean array of size k+1
 */
class FrogsAndJumps {
	int unvisitedLeaves(int arr[], int k) {
		// code here
		int n = arr.length;
		int leaves_not_visited = 0;
		boolean visited[] = new boolean[k + 1];
		
        // Initialize all leaves as unvisited
		for (int i = 0; i<n; i++) {
			for (int leaf = arr[i]; leaf <= k; leaf += arr[i]) {
				visited[leaf] = true;
			}
		}
		
        // Count the number of leaves that have not been visited by any frog
		for (int i = 1; i<visited.length; i++) {
			if (visited[i] == false)
				leaves_not_visited += 1;
		}
		return leaves_not_visited;
	}
}
