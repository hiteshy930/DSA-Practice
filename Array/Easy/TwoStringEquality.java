/**
 * Given two strings s1 and s2, determine if they are exactly the same, considering case sensitivity.

Examples:

Input: s1 = "abc" , s2 = "abc" 
Output: true
Input: s1 = " " , s2 = " "
Output: true
Input: s1 = "geeks", s2 = "Geeks"
Output: false
Constraints:
1 ≤ |s1|, |s2| ≤ 105
 */
/**
 * Solution: 1. Check if the lengths of the two strings are equal. If they are
 * not, return false.
 * 2. If the lengths are equal, iterate through the characters of both strings
 * and compare
 * 3. If any character is different, return false. If all characters are the
 * same, return true.
 * 4. We can also use the built-in function String.equals() to compare the two
 * strings. If they are equal, return true, otherwise return false.
 */
class Solution {
    public static boolean areStringsSame(String s1, String s2) {
        // code here
        return (s1.equals(s2)) ? true : false;
    }
}