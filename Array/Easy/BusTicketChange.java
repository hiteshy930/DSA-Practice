
/**
 * You are given an array arr[] representing passengers in a queue. Each bus ticket costs 5 coins, and arr[i] denotes the note a passenger uses to pay (which can be 5, 10, or 20). You must serve the passengers in the given order and always provide the correct change so that each passenger effectively pays exactly 5 coins. Your task is to determine whether it is possible to serve all passengers in the queue without ever running out of change.
 *
 * Examples:
 *
 * Input: arr[] = [5, 5, 5, 10, 20]
 * Output: true
 * Explanation: From the first 3 customers, we collect three $5 bills in order.
 * From the fourth customer, we collect a $10 bill and give back a $5.
 * From the fifth customer, we give a $10 bill and a $5 bill.
 * Since all customers got correct change we return true.
 * Input: arr[] = [5, 5, 10, 10, 20]
 * Output: false
 * Explanation: From the first two customers in order, we collect two $5 bills. For the next two customers in order, we collect a $10 bill and give back a $5 bill. For the last customer, we can not give the change of $15 back because we only have two $10 bills. Since not every customer received the correct change, the answer is false.
 * Constraints:
 * 1 ≤ arr.size() ≤ 105
 * arr[i] contains only [5, 10, 20]
 */

/**
 * Solution: We can keep track of the number of $5 and $10 bills we have at any point 
 * in time. For each passenger, we check the note they use to pay and update our counts 
 * accordingly. If we ever encounter a situation where we cannot provide the correct change, 
 * we return false. If we successfully serve all passengers, we return true.
 * 
 * Time Complexity: O(n), where n is the size of the array arr[].
 * Space Complexity: O(1), as we are using a constant amount of extra space to keep track of the number of $5 and $10 bills.
 *
 */
class BusTicketChange {

    public boolean canServe(int[] arr) {
        // code here
        int n = arr.length;
        int note5 = 0;
        int note10 = 0;
        boolean flag = true;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 5) {
                note5 += 1;
            } else if (arr[i] == 10 && note5 >= 1) {
                note5 -= 1;
                note10 += 1;
            } else if (arr[i] == 20 && note5 >= 1 && note10 >= 1) {
                note5 -= 1;
                note10 -= 1;
            } else if (arr[i] == 20 && note5 >= 3) {
                note5 -= 3;
            } else {
                flag = false;
            }
        }

        return flag;
    }
}
