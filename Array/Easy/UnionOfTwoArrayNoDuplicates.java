/**
 * You are given two arrays a[] and b[], return the Union of both the arrays in
 * any order.
 * 
 * The Union of two arrays is a collection of all distinct elements present in
 * either of the arrays. If an element appears more than once in one or both
 * arrays, it should be included only once in the result.
 * 
 * Note: Elements of a[] and b[] are not necessarily distinct.
 * Note that, You can return the Union in any order but the driver code will
 * print the result in sorted order only.
 * 
 * Examples:
 * 
 * Input: a[] = [1, 2, 3, 2, 1], b[] = [3, 2, 2, 3, 3, 2]
 * Output: [1, 2, 3]
 * Explanation: Union set of both the arrays will be 1, 2 and 3.
 * Input: a[] = [1, 2, 3], b[] = [4, 5, 6]
 * Output: [1, 2, 3, 4, 5, 6]
 * Explanation: Union set of both the arrays will be 1, 2, 3, 4, 5 and 6.
 * Input: a[] = [1, 2, 1, 1, 2], b[] = [2, 2, 1, 2, 1]
 * Output: [1, 2]
 * Explanation: Union set of both the arrays will be 1 and 2.
 * Constraints:
 * 1 ≤ a.size(), b.size() ≤ 106
 * 0 ≤ a[i], b[i] ≤ 105
 */
/**
 * Solution: Use a HashSet to store the elements of both arrays. Iterate through
 * both arrays and add each element to the HashSet. Since HashSet only stores
 * distinct elements, it will automatically handle duplicates. Finally, convert
 * the HashSet to an array and return it.
 * 2. Use arraylist to store the element using contains, but remember contains()
 * also traverse full list in its implementation, so it will take O(n^2) time
 * complexity. So, HashSet is better than arraylist.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
class UnionOfTwoArrayNoDuplicates {
	public static ArrayList<Integer> findUnion(int[] a, int[] b) {
		// code here
		// Use HashSet
		Set<Integer> set = new HashSet();
		ArrayList<Integer> list = new ArrayList();
		
		for (int i = 0 ; i<a.length; i++) {
			set.add(a[i]);
		}
		
		for (int i = 0 ; i<b.length; i++) {
			set.add(b[i]);
		}
		
		for (int num : set) {
			list.add(num);
		}
		
		return list;
	}
}
