
/**
 * A string s is given to represent a positive number. The task is to round s to the nearest multiple of 10.  If you have two multiples equally apart from s, choose the smallest element among them.
 *
 * Examples:
 *
 * Input: s = "29"
 * Output: 30
 * Explanation: Close multiples are 20 and 30, and 30 is the nearest to 29.
 * Input: s = "15"
 * Output: 10
 * Explanation: 10 and 20 are equally distant multiples from 20. The smallest of the two is 10.
 * Constraints:
 * 1 <= s.size()<= 105
 */
/**
 * Solution: easiest explanation is to check the last digit of the string. 
 * If it is less than or equal to 5, we can simply replace it with 0. 
 * If it is greater than 5, we can replace it with 0 and add 1 to the previous digit. 
 * If the previous digit is 9, we need to handle the carry and continue adding 1 to 
 * the previous digits until we reach a digit that is not 9 or we reach the beginning of 
 * the string. If we reach the beginning of the string and still have a carry, 
 * we need to add a new digit '1' at the beginning of the string.
 * 
 * Time Complexity: O(n), where n is the size of the string s.
 * Space Complexity: O(1), as we are using only a constant amount of extra space
 */
class HLevel_NearestRoundDigit {

    public String roundToNearest(String s) {

        int n = s.length();

        // If last digit is <= 5,
        // simply replace it with 0
        if (s.charAt(n - 1) - '0' <= 5) {
            s = s.substring(0, n - 1) + '0';
            return s;
        }

        // Last digit is > 5, so round up
        s = s.substring(0, n - 1) + '0';

        int i = n - 2;
        int carry = 1;

        // Handle carry
        while (i >= 0 && carry == 1) {

            int digit = s.charAt(i) - '0';

            digit += carry;

            if (digit > 9) {
                digit = 0;
                carry = 1;
            } else {
                carry = 0;
            }

            s = s.substring(0, i)
                    + (char) (digit + '0')
                    + s.substring(i + 1);

            i--;
        }

        // Example: 99 -> 100
        if (carry == 1) {
            s = "1" + s;
        }

        return s;
    }
}
