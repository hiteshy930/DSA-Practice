/**
 * Given an unsorted array arr[] of integers and an integer x, find the floor and ceiling of x in arr[].

Floor of x is the largest element which is smaller than or equal to x. Floor of x doesn’t exist if x is smaller than smallest element of arr[].
Ceil of x is the smallest element which is greater than or equal to x. Ceil of x doesn’t exist if x is greater than greatest element of arr[].
Return an array of integers denoting the [floor, ceil]. Return -1 for floor or ceiling if the floor or ceiling is not present.

Examples:

Input: x = 7 , arr[] = [5, 6, 8, 9, 6, 5, 5, 6]
Output: 6, 8
Explanation: Floor of 7 is 6 and ceil of 7 is 8.
Input: x = 10 , arr[] = [5, 6, 8, 8, 6, 5, 5, 6]
Output: 8, -1
Explanation: Floor of 10 is 8 but ceil of 10 is not possible.
Constraints :
1 ≤ arr.size ≤ 105
1 ≤ arr[i], x ≤ 106
 */

/**
 * Solution:
 * Iterate through the array and find the floor and ceiling of x.
 * 
 */
class FloorAndCeilOfUnsortedArray {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        int floor = -1;
        int ceil = -1;

        for (int num : arr) {

            // Floor: largest number <= x
            if (num <= x) {
                floor = Math.max(floor, num);
            }

            // Ceiling: smallest number >= x
            if (num >= x) {
                if (ceil == -1) {
                    ceil = num;
                } else {
                    ceil = Math.min(ceil, num);
                }
            }
        }

        int[] result = new int[2];
        result[0] = floor;
        result[1] = ceil;

        return result;

    }
}
