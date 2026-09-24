/**
 * Given two integer arrays a[] and b[], find the elements which are present in the first array a[], but not present in the second array b[].
 * Return the elements in the same order in which they appear in a[].
 * If there are more occurrences of an element in a[] than in b[], then extra occurrences of this element are NOT considered as missing in b[].
 * Examples :
 *
 * Input: a[] = [1, 2, 3, 4, 5, 10], b[] = [2, 3, 1, 0, 5]
 * Output: [4, 10]
 * Explanation: 4 and 10 are present in first array, but not in second array.
 * Input: a[] = [4, 3, 5, 9, 11], b[] = [4, 9, 3, 11, 10]
 * Output: [5]  
 * Explanation: Second array does not contain element 5.
 * Input: a[] = [9], b[] = [7, 9, 4, 9, 9, 9]
 * Output: []  
 * Constraints:
 *
 * 1 ≤ a.size(), b.size() ≤ 105
 * 0 ≤ a[i], b[i] ≤ 105
*/

/**
 * Solution: Using HashSet to store the elements of the second array.
 * 1. Iterate through the second array and add each element to the HashSet.
 * 2. Iterate through the first array and check if the element is present in the HashSet.
 * 3. If the element is not present in the HashSet, add it to the result list.
 * 4. Finally, return the result list.
 * 
 * Time Complexity: O(n + m), where n is the size of the first array and m is the size of the second array.
 * Space Complexity: O(m), as we are using a HashSet to store the elements of
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
class MissingInSecondArray {
    ArrayList<Integer> findMissing(int[] a, int[] b) {
        // code here
        int n = a.length;
        
        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for(int num : b){
            set.add(num);
        }
        
        for(int num : a){
            if(!set.contains(num)){
                list.add(num);
            }
        }
        
        return list;
    }
}

