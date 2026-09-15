
/**
 * Given two unsorted arrays a[]  and b[], the task is to find all pairs whose sum equals x from both arrays.

 * Note: All pairs should be returned in increasing order of u. For eg. for two pairs (u1,v1) and (u2,v2), if u1 < u2 then (u1,v1) should be returned first else second.

 * Examples:

 * Input: target = 9, a[] = [1, 2, 4, 5, 7], b[] = [5, 6, 3, 4, 8]
 * Output: 
 * 1 8
 * 4 5 
 * 5 4
 * Explanation: (1, 8), (4, 5), (5, 4) are the pairs which sum to 9.
 * Input: target = 8, a[] = [-1, -2, 4, -6, 5, 7], b[] = [6, 3, 4, 0]
 * Output:
 * 4 4 
 * 5 3
 * Input: target = 9, a[] = [1, 2, 4, 5, 7, 4], b[] = [5, 6, 3, 4, 8, 4]
 * Output:
 * 1 8
 * 4 5
 * 4 5
 * 5 4
 * 5 4
 * Explanation: (1, 8), (4, 5), (4, 5), (5, 4) and (5, 4) are the pairs which sum to 9.
 * Constraints:
 *
 * 1 ≤ arr1.size(), arr2.size() ≤ 105
 * -2*104 ≤ arr1[i], arr2[i] ≤ 2*104
 */

/**
 * Solution:
 * 1. Sort the first array arr1[].
 * 2. Store the frequency of each value in arr2[] using a HashMap.
 * 3. Iterate through the sorted arr1[] and for each element, calculate the
 * difference between the target and the current element.
 * 4. Check if the difference exists in the HashMap. If it does, add the pair (current element, difference) to the result list for each occurrence of the difference in arr2[].
 * 5. Return the result list as an array of Pair objects.
 * 
 * Time Complexity: O(n log n + m), where n is the length of arr1[] and m is the length of arr2[]. Sorting arr1[] takes O(n log n) time, and iterating through arr1[] and checking the HashMap takes O(m) time.
 * Space Complexity: O(m), where m is the length of arr2[]. The HashMap stores the frequency of each element in arr2[], which requires O(m) space.
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Pair {
    long first, second;

    public Pair(long first, long second) {
        this.first = first;
        this.second = second;
    }
}

public class AllPairsWithSumFromArray2 {
    public Pair[] allPairs(int target, int arr1[], int arr2[]) {
        if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0) {
            return new Pair[0];
        }

        Arrays.sort(arr1);

        // Store the frequency of each value in arr2.
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : arr2) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        ArrayList<Pair> result = new ArrayList<>();

        // arr1 is sorted, so pairs are generated in increasing order of the first
        // value.
        for (int num : arr1) {
            int diff = target - num;

            if (freq.containsKey(diff)) {
                int count = freq.get(diff);

                // Add one pair for every occurrence in arr2.
                for (int j = 0; j < count; j++) {
                    result.add(new Pair(num, diff));
                }
            }
        }

        return result.toArray(new Pair[0]);
    }
}
