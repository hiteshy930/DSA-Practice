/**
 * Given an array arr[] of n integers and an integer k, find the count of
 * elements that appear more than n/k times in the array.
 * 
 * Examples :
 * 
 * Input: arr[] = [3, 1, 2, 2, 1, 2, 3, 3], k = 4
 * Output: 2
 * Explanation: The elements 2 and 3 each occur 3 times, which is more than n/k
 * = 2.
 * Input: arr = [2, 3, 3, 2], k = 3
 * Output: 2
 * Explanation: Both 2 and 3 appear 2 times in the array, which is more than
 * n/k.
 * Constraints:
 * 
 * arr.size() ≤ 106
 * 0 ≤ arr[i] ≤ 108
 * 1 ≤ k ≤ arr.size()
 */

/**
 * Solution: Using HashMap
 * 1. Create a HashMap to store the frequency of each element in the array.
 * 2. Iterate through the array and update the frequency of each element in the
 * HashMap.
 * 3. Iterate through the HashMap and count the number of elements whose frequency
 * is greater than n/k.
 * 4. Return the count of such elements.
 * 
 * Time Complexity: O(n), where n is the length of the array. We traverse the
 * array twice, once to fill the HashMap and once to count the elements.
 * Space Complexity: O(n), as we are using a HashMap to store the frequency of
 * elements, which can have at most n entries in the worst case.
 */
class CountFrequentElements {
    public int countOccurence(int[] arr, int k) {
        // code here
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        
        for(int num : arr){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                 map.put(num, 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > n/k){
                result++;        
            }
        }
        
        return result;
    }
}