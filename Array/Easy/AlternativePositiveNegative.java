/**
 * Given an unsorted array arr containing both positive and negative numbers.
 * Your task is to rearrange the array and convert it into an array of alternate
 * positive and negative numbers without changing the relative order.
 * 
 * Note:
 * 
 * Resulting array should start with a positive integer (0 will also be
 * considered as a positive integer).
 * If any of the positive or negative integers are exhausted, then add the
 * remaining integers in the answer as it is by maintaining the relative order.
 * Examples:
 * 
 * Input: arr[] = [9, 4, -2, -1, 5, 0, -5, -3, 2]
 * Output: [9, -2, 4, -1, 5, -5, 0, -3, 2]
 * Explanation: The positive numbers are [9, 4, 5, 0, 2] and the negative
 * integers are [-2, -1, -5, -3]. Since, we need to start with the positive
 * integer first and then negative integer and so on (by maintaining the
 * relative order as well), hence we will take 9 from the positive set of
 * elements and then -2 after that 4 and then -1 and so on.
 * Input: arr[] = [-5, -2, 5, 2, 4, 7, 1, 8, 0, -8]
 * Output: [5, -5, 2, -2, 4, -8, 7, 1, 8, 0]
 * Explanation : The positive numbers are [5, 2, 4, 7, 1, 8, 0] and the negative
 * integers are [-5,-2,-8]. According to the given conditions we will start from
 * the positive integer 5 and then -5 and so on. After reaching -8 there are no
 * negative elements left, so according to the given rule, we will add the
 * remaining elements (in this case positive elements are remaining) as it in by
 * maintaining the relative order.
 * Input: arr[] = [9, 5, -2, -1, 5, 0, -5, -3, 2]
 * Output: [9, -2, 5, -1, 5, -5, 0, -3, 2]
 * Explanation: The positive numbers are [9, 5, 5, 0, 2] and the negative
 * integers are [-2, -1, -5, -3]. Since, we need to start with the positive
 * integer first and then negative integer and so on (by maintaining the
 * relative order as well), hence we will take 9 from the positive set of
 * elements and then -2 after that 5 and then -1 and so on.
 * Constraints:
 * 1 ≤ arr.size() ≤ 106
 * -106 ≤ arr[i] ≤ 106
 */

/**
 * Solution:
 * Split the array into two arrays, one for positive numbers and one for
 * negative numbers. Then, merge the two arrays in an alternate manner while
 * maintaining the relative order.
 * 
 */
import java.util.ArrayList;
class AlternativePositiveNegative {
    void rearrange(ArrayList<Integer> arr) {

        int n = arr.size();

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Separate positive and negative numbers
        for (int i = 0; i < n; i++) {
            if (arr.get(i) < 0) {
                neg.add(arr.get(i));
            } else {
                pos.add(arr.get(i));
            }
        }

        int minSize = Math.min(pos.size(), neg.size());

        // Put positive numbers at even indexes
        // and negative numbers at odd indexes
        for (int i = 0; i < minSize; i++) {
            arr.set(2 * i, pos.get(i));
            arr.set(2 * i + 1, neg.get(i));
        }

        // Add remaining positive numbers
        int index = 2 * minSize;

        for (int i = minSize; i < pos.size(); i++) {
            arr.set(index, pos.get(i));
            index++;
        }

        // Add remaining negative numbers
        for (int i = minSize; i < neg.size(); i++) {
            arr.set(index, neg.get(i));
            index++;
        }
    }
}