/**
 * Given an array arr[] of integers, sort the array (in descending order) according 
 * to count of set bits in binary representation of array elements. 
 * 
 * Note: For integers having same number of set bits in their binary representation, 
 * sort according to their position in the original array i.e., a stable sort.
 * 
 * Examples:
 * Input: arr[] = [5, 2, 3, 9, 4, 6, 7, 15, 32]
 * Output: [15, 7, 5, 3, 9, 6, 2, 4, 32]
 * Explanation: The integers in their binary representation are:
 * 15 - 1111
 * 7  - 0111
 * 5  - 0101
 * 3  - 0011
 * 9  - 1001
 * 6  - 0110
 * 2  - 0010
 * 4  - 0100
 * 32 - 10000
 * hence the non-increasing sorted order is: [15], [7], [5, 3, 9, 6], [2, 4, 32]
 * Input: arr[] = [1, 2, 3, 4, 5, 6]
 * Output: [3, 5, 6, 1, 2, 4]
 * Explanation: The integers in their binary representation are:
 * 3  - 0011
 * 5  - 0101
 * 6  - 0110
 * 1  - 0001
 * 2  - 0010
 * 4  - 0100
 * hence the non-increasing sorted order is: [3, 5, 6], [1, 2, 4]
 * Constraints:
 * 1 ≤ arr.size() ≤ 105
 * 1 ≤ arr[i] ≤ 106
 */

/**
 * Solution: We can use a custom comparator to sort the array based on the count of set 
 * bits in the binary representation of each element.
 * We can count the number of set bits in each element using bitwise operations.
 * 
 * Time Complexity: O(n log n), where n is the length of the array. 
 * The sorting operation takes O(n log n) time.
 * Space Complexity: O(n), as we are using an additional array to store the elements for 
 * sorting. 
 */
import java.util.ArrayList;
import java.util.Arrays;
class SortBySetBitCount {
    ArrayList<Integer> sortBySetBitCount(int[] arr) {
        // code here
        Integer[] arrInteger = new Integer[arr.length];

               for (int i = 0; i < arr.length; i++) {
                   arrInteger[i] = arr[i];
               }

               // custom comparator
               Arrays.sort(arrInteger, (a, b) -> {
                   int count1 = countBits(a);
                   int count2 = countBits(b);

                   // descending order of set bits
                   if (count1 != count2) {
                       return count2 - count1;
                   }

                   // maintain original order (stable behavior)
                   return 0;
               });

               // Convert array to ArrayList and return
               return new ArrayList<>(Arrays.asList(arrInteger));
    }
    
    int countBits(int n)
       {
           int cnt = 0;
           while (n > 0) {
            
               cnt += (n & 1);
               n = n >> 1;
           }
           return cnt;
       }
}