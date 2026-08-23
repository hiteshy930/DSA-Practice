class AllElementsPallindrome {
        public boolean isPalinArray(int[] arr) {
                
                        for (int num : arr) {
                                    if (!isPalindrome(num)) {
                                                    return false;
                                                                }
                                                                        }
                                                                                
                                                                                        return true;
                                                                                            }

                                                                                                private boolean isPalindrome(int num) {
                                                                                                        int original = num;
                                                                                                                int reverse = 0;

                                                                                                                        while (num > 0) {
                                                                                                                                    int digit = num % 10;
                                                                                                                                                reverse = reverse * 10 + digit;
                                                                                                                                                            num /= 10;
                                                                                                                                                                    }

                                                                                                                                                                            return original == reverse;
                                                                                                                                                                                }
                                                                                                                                                                                }
}