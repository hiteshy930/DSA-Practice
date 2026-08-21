/**
 * 
 */
class IsPalimdromeArray {
        public static boolean isPalindrome(int[] arr) {
                // code here
                        int n=arr.length;
                                
                                        int i = 0;
                                                int j = n-1;
                                                        boolean isPalindrome = true;
                                                                
                                                                        while (i<=j){
                                                                                    if(arr[i] != arr[j]){
                                                                                                    isPalindrome = false;
                                                                                                                }
                                                                                                                            i++;
                                                                                                                                        j--;
                                                                                                                                                }
                                                                                                                                                        
                                                                                                                                                                return isPalindrome;
                                                                                                                                                                    }
                                                                                                                                                                    }

}