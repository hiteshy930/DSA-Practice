
/**
 * Given two integer arrays a[] and b[], you have to find the intersection of
 * the two arrays. Intersection of two arrays is said to be elements that are common
 * in both the arrays. The intersection should not have duplicate elements and the result
 * may contain elements in any order.
 *
 * Note: The driver code will sort the resulting array in increasing order before printing.
 *
 * Examples:
 *
 * Input: a[] = [1, 2, 1, 3, 1], b[] = [3, 1, 3, 4, 1]
 * Output: [1, 3]
 * Explanation: 1 and 3 are the only common elements and we need to print only one occurrence of common elements.
 * Input: a[] = [1, 1, 1], b[] = [1, 1, 1, 1, 1]
 * Output: [1]
 * Explanation: 1 is the only common element present in both the arrays.
 * Input: a[] = [1, 2, 3], b[] = [4, 5, 6]
 * Output: []
 * Explanation: No common element in both the arrays.
 *
 * Constraints:
 * 1 ≤ a.size(), b.size() ≤ 105
 * 0 ≤ a[i], b[i] ≤ 105
 */
/**
 * Solution: We can use two sets to store the unique elements of both arrays.
 * Then, we can iterate through the smaller set and check if each element is present
 * in the larger set. If it is, we add it to the result list. This way, we ensure that
 * the intersection does not contain duplicate elements and we can return the result list.
 *
 * Time Complexity: O(n + m), where n is the size of array a[] and
 * m is the size of array b[].
 * Space Complexity: O(n + m), as we are using two sets to store the unique
 * elements of both arrays.
 *
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class InterSectionOfTwoArrays {

    public ArrayList<Integer> intersect(int[] a, int[] b) {
        // code here

        ArrayList<Integer> result = new ArrayList<>();

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : a) {
            set1.add(num);
        }

        for (int num : b) {
            set2.add(num);
        }

        if (set1.size() > set2.size()) {
            for (int num : set1) {
                if (set2.contains(num)) {
                    result.add(num);
                }
            }
        } else {
            for (int num : set2) {
                if (set1.contains(num)) {
                    result.add(num);
                }
            }
        }
        return result;

    }
}
