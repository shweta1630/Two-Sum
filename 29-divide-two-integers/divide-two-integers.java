public class Solution {
    public int divide(int dividend, int divisor) {
        // Handle the edge case of overflow.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result.
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Work with positive values for easier calculation
        long dividendAbs = Math.abs((long) dividend);
        long divisorAbs = Math.abs((long) divisor);

        int quotient = 0;

        // Perform division using bitwise shifting (long division)
        while (dividendAbs >= divisorAbs) {
            long tempDivisor = divisorAbs, multiple = 1;

            // Double the divisor until it's larger than the dividend
            while (dividendAbs >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // Subtract the largest multiple of the divisor from the dividend
            dividendAbs -= tempDivisor;
            quotient += multiple;
        }

        // If the result should be negative, negate the quotient
        return isNegative ? -quotient : quotient;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        System.out.println(solution.divide(10, 3)); // Output: 3

        // Example 2
        System.out.println(solution.divide(7, -3)); // Output: -2

        // Example 3
        System.out.println(solution.divide(-2147483648, -1)); // Output: 2147483647 (overflow case)
    }
}