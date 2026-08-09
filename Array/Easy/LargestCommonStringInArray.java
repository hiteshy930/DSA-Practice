/**
 * Given an array of strings arr[]. Return the longest common prefix among each
 * and every strings present in the array. If there's no prefix common in all
 * the strings, return "".
 * 
 * Examples :
 * 
 * Input: arr[] = ["geeksforgeeks", "geeks", "geek", "geezer"]
 * Output: "gee"
 * Explanation: "gee" is the longest common prefix in all the given strings.
 * Input: arr[] = ["hello", "world"]
 * Output: ""
 * Explanation: There's no common prefix in the given strings.
 * Constraints:
 * 1 ≤ |arr| ≤ 103
 * 1 ≤ |arr[i]| ≤ 103
 */

/**
 * Solution: Traverse first string and check if the character is present in all
 * the strings. If yes, then add it to the prefix string. If not, return the
 * prefix string.
 */
class LargestCommonStringInArray {
    public String longestCommonPrefix(String arr[]) {
        // code here
        String first = arr[0];
        
        StringBuilder result = new StringBuilder();
        
        //Traverse the first String char by char
        for(int i =0; i<first.length(); i++){
            
            char current = first.charAt(i);
            
            for(int j =1 ; j<arr.length; j++){
                //Traverse the array strings
                
                if (i >= arr[j].length() || arr[j].charAt(i) != current) {
                    //Check if char mismatch or String ended
                    return result.toString();
                }
            }
            
            result.append(current);
        }
        
        return result.toString();
    }
}