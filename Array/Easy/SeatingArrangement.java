
/**
 * Given an integer k representing the number of people to be seated and an array seats[], where 0 denotes an empty seat and 1 denotes an occupied seat.
 *
 * Determine whether it is possible to seat all k people such that no two occupied seats are adjacent (including newly seated people).
 *
 * Examples:
 *
 * Input: k = 2, seats[] = [0, 0, 1, 0, 0, 0, 1]
 * Output: true
 * Explanation: The two people can sit at index 0 and 4.
 * Input: k = 1, seats[] = [0, 1, 0]
 * Output: false
 * Explanation: There is no way to get a seat for one person.
 * Input: k = 0, seats[] = [0, 0, 0, 1, 1]
 * Output: false
 * Explanation: The seating arrangement already contains two adjacent occupied seats at indices 3 and 4.
 * Constraints:
 * 0 ≤ k ≤ 105
 * 1 ≤ seats.size() ≤ 105
 * seats[i] == 0 or seats[i] == 1
 */
/**
 * Solution: Using a greedy approach to seat people from left to right.
 * 1. First, check if the existing arrangement is already invalid
 *    (i.e., two adjacent occupied seats). If so, return false.
 * 2. Iterate through the seats array and for each empty seat, 
 *    check if the left and right seats are empty or out of bounds.
 * 3. If both left and right seats are empty, seat a person there and decrement k.
 * 4. If k reaches 0, return true. If the loop ends and k is still greater than 0, 
 *    return false.
 *
 * Time Complexity: O(n), where n is the size of the seats array.
 * Space Complexity: O(1), as we are using constant space.
 */
class SeatingArrangement {

    public boolean canSeatAllPeople(int k, int[] seats) {

        int n = seats.length;

        // Check if existing arrangement is already invalid
        for (int i = 0; i < n - 1; i++) {
            if (seats[i] == 1 && seats[i + 1] == 1) {
                return false;
            }
        }

        // Try to seat people from left to right
        for (int i = 0; i < n; i++) {

            if (k == 0) {
                return true;
            }

            if (seats[i] == 1) {
                continue;
            }
            // Check if the left and right seats are empty or out of bounds
            boolean leftEmpty = (i == 0 || seats[i - 1] == 0);
            boolean rightEmpty = (i == n - 1 || seats[i + 1] == 0);
            // If both left and right seats are empty, we can seat a person here
            if (leftEmpty && rightEmpty) {
                seats[i] = 1;  // IMPORTANT: occupy the seat
                k--;
            }
        }

        return k == 0;
    }
}
