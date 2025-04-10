public class Solution {

    /**
     * Reverses the digits of a 32-bit signed integer.
     *
     * @param x The input integer
     * @return The reversed integer, or 0 if it overflows the 32-bit signed integer range
     */
    public int reverse(int x) {
        int result = 0;
        int INT_MAX = Integer.MAX_VALUE;
        int INT_MIN = Integer.MIN_VALUE;

        while (x != 0) {
            // Extract the last digit
            int digit = x % 10;
            x /= 10;

            // Check for overflow before multiplying result by 10 and adding the digit
            if (result > INT_MAX / 10 || (result == INT_MAX / 10 && digit > 7)) {
                return 0;  // Positive overflow
            }
            if (result < INT_MIN / 10 || (result == INT_MIN / 10 && digit < -8)) {
                return 0;  // Negative overflow
            }

            // Add the digit to the reversed number
            result = result * 10 + digit;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        System.out.println(solution.reverse(123));  // Output: 321

        // Example 2
        System.out.println(solution.reverse(-123)); // Output: -321

        // Example 3
        System.out.println(solution.reverse(120));  // Output: 21
    }
}