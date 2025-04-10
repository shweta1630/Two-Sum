public class Solution {

    /**
     * Checks if the given integer x is a palindrome.
     *
     * @param x The integer to check
     * @return true if x is a palindrome, false otherwise
     */
    public boolean isPalindrome(int x) {
        // If the number is negative or ends with 0 (but isn't 0), it's not a palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        
        // Reverse the second half of the number
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }
        
        // Check if the first half equals the reversed second half or if we have a middle digit
        return x == reversedHalf || x == reversedHalf / 10;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        System.out.println(solution.isPalindrome(121));  // Output: true

        // Example 2
        System.out.println(solution.isPalindrome(-121)); // Output: false

        // Example 3
        System.out.println(solution.isPalindrome(10));   // Output: false
    }
}