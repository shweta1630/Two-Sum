public class Solution {
    
    public int myAtoi(String s) {
        // Initialize pointer and the result variable
        int index = 0, result = 0, sign = 1;
        
        // Step 1: Skip leading whitespace
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        
        // Step 2: Check for sign
        if (index < s.length()) {
            char c = s.charAt(index);
            if (c == '-') {
                sign = -1;  // Negative number
                index++;
            } else if (c == '+') {
                index++;  // Positive number, no need to change the sign
            }
        }
        
        // Step 3: Convert the digits
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';  // Convert char to integer
            // Check for overflow before multiplying and adding the digit
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;  // Overflow case
            }
            result = result * 10 + digit;
            index++;
        }
        
        // Step 4: Apply the sign and return the result
        return result * sign;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        System.out.println(solution.myAtoi("42")); // Output: 42
        
        // Example 2
        System.out.println(solution.myAtoi(" -042")); // Output: -42
        
        // Example 3
        System.out.println(solution.myAtoi("1337c0d3")); // Output: 1337
        
        // Example 4
        System.out.println(solution.myAtoi("0-1")); // Output: 0
        
        // Example 5
        System.out.println(solution.myAtoi("words and 987")); // Output: 0
    }
}