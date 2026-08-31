/**
 * Given an array arr[] of integers, find and return the elements with even
 * occurrences in the array. If no such element exists, return -1. Elements
 * should be returned in order of occurrence.
 * 
 * Examples:
 * 
 * Input: arr[] = [9, 12, 23, 10, 12, 12, 15, 23, 14, 12, 15]
 * Output: [12, 15, 23]
 * Explanation: The numbers 12, 15, and 23 each appear an even number of times.
 * Input: arr[] = [23, 12, 56, 34, 32]
 * Output: [-1]
 * Explanation: Every number in the array occurs an odd number of times.
 * Constraints:
 * 1 ≤ arr.size() ≤ 106
 * 1 ≤ arr[i] ≤ 105
 */

/**
 * Solution explanation:
 * 1. Create a LinkedHashMap to store the frequency of each element in the array.
 * 2. Iterate through the array and populate the map with the count of each element.
 * 3. Create an ArrayList to store the elements with even occurrences.
 * 4. Iterate through the map and check the frequency of each element. If the frequency is even, add the element to the ArrayList.
 * 5. If the ArrayList is empty after checking all elements, add -1 to the list to indicate no even occurrences were found.
 * 
 */
import java.util.*;

class EvenOccurrenceNumber {
    public ArrayList<Integer> findEvenOccurrences(int[] arr) {
        // code here
        Map<Integer, Integer> map = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int num: arr){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()%2 == 0){
                list.add(entry.getKey());
            }
        }
        
        if(list.isEmpty()){
            list.add(-1);
            return list;
        }
        
        return list;
    }
}