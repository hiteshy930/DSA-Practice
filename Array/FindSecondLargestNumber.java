
class Solution {
	public int getSecondLargest(int[] arr) {
		// code here
		int sl = -1; int l = -1;
		// One Pass approach
		for (int i = 0; i<arr.length; i++) {
			if (arr[i]>l) {
				sl = l;
				l = arr[i];
			} else if (arr[i]<l && arr[i] > sl) {
				sl = arr[i];
			}
		}
		return sl;
	}
}
