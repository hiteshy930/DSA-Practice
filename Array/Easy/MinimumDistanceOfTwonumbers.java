/**
 * You are given an array, arr[]. Find the minimum index based distance between
 * two different elements of the array, x and y. Return -1, if either x or y
 * does not exist in the array.
 * 
 * Examples:
 * 
 * Input: arr[] = [1, 2, 3, 2], x = 1, y = 2
 * Output: 1
 * Explanation: x = 1 and y = 2. There are two distances between x and y, which
 * are 1 and 3 out of which the least is 1.
 * Input: arr[] = [86, 39, 90, 67, 84, 66, 62], x = 42, y = 12
 * Output: -1
 * Explanation: x = 42 and y = 12. We return -1 as x and y don't exist in the
 * array.
 * Input: arr[] = [10, 20, 30, 40, 50], x = 10, y = 50
 * Output: 4
 * Explanation: The distance between x = 10 (index 0) and y = 50 (index 4) is 4,
 * which is the only distance between them.
 * Constraints:
 * 1 <= arr.size() <= 105
 * 0 <= arr[i], x, y <= 105
 * x != y
 * 
 * 
 */
/**
 * Solution:
 * Maintain 2 indexes for x and y, update them when we find x or y in the array.
 * If both indexes are updated, calculate the distance and update the minimum
 * distance.
 */
class MinimumDistanceOfTwonumbers {
    int minDist(int arr[], int x, int y) {

        int xIndex = -1;
        int yIndex = -1;

        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == x) {

                xIndex = i;

                if (yIndex != -1) {
                    minDistance = Math.min(
                        minDistance,
                        xIndex - yIndex
                    );
                }

            } else if (arr[i] == y) {

                yIndex = i;

                if (xIndex != -1) {
                    minDistance = Math.min(
                        minDistance,
                        yIndex - xIndex
                    );
                }
            }
        }

        if (xIndex == -1 || yIndex == -1) {
            return -1;
        }

        return minDistance;
    }
}