
/**
 * Given an array exits[] of size n, where each index represents a node and exits[i] represents the node that node i points to. If exits[i] = -1, node i does not point to any node.

 *  *The weight of a node i is the sum of the indices of all nodes that point to node i.

 *  *Find the node with the maximum weight. If multiple nodes have the same maximum weight, return the node with the largest index.

 *  *Note: Nodes are indexed from 0 to n - 1. A node has a weight of 0 if no other node points to it.

 *  *Examples:

 *  *Input: exits[] = [2, 0, -1, 2]
 * Output: 2
 * Explanation: Nodes 1 and 3 point as follows: 1 → 0 → 2 ← 3.
 * The weights are weight[0] = 1, weight[1] = 0, weight[2] = 0 + 3 = 3, and weight[3] = 0. Thus, node 2 has the maximum weight.
 * Input: exits[] = [-1]
 * Output: 0
 * Explanation: No node points to node 0, so its weight is 0. Since it is the only node, the answer is 0.
 * Constraints:
 * 1  ≤  n  ≤  105
 * -1  <  exits[i]  <  n
 * exits[i]  ≠  i
 */

/**
 * Solution: 
 * We can create an array weight[] of size n to store the weights of each node. 
 * We can iterate through the exits[] array and for each node i, if exits[i] is not -1, 
 * we add the index i to the weight of the node that exits[i] points to. 
 * After calculating the weights, we can iterate through the weight[] array to find the 
 * node with the maximum weight. If multiple nodes have the same maximum weight, 
 * we return the node with the largest index.
 * 
 * Time Complexity: O(n), where n is the size of the exits[] array.
 * Space Complexity: O(n), as we are using an additional array weight[] of size n
 * to store the weights of each node.
 */
class MaximumWeightNode {

    public int maxWeightNode(int[] exits) {
        // code here
        int n = exits.length;
        long[] weight = new long[n];
        // Initialize the weight array to store the weights of each node
        for (int i = 0; i < n; i++) {
            // If the current node points to another node, add its index 
            // to the weight of that node
            if (exits[i] != -1) {
                // Add the index of the current node to the weight of the 
                // node it points to
                weight[exits[i]] += i;

            }

        }

        int ans = 0;
        // Iterate through the weight array to find the node with the maximum weight
        for (int i = 0; i < n; i++) {
            // If the weight of the current node is greater than or equal 
            // to the weight of the
            // node with the maximum weight found so far, update the answer 
            // to the current node
            if (weight[i] >= weight[ans]) {
                // Update the answer to the current node if its weight is greater
                // than or equal to the maximum weight found so far
                ans = i;
            }

        }
        return ans;
    }
}
