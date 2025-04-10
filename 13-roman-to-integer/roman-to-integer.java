import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Converts a Roman numeral string to an integer.
     *
     * @param s The Roman numeral string
     * @return The integer representation of the Roman numeral
     */
    public int romanToInt(String s) {
        // Map for Roman numeral values
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            int currentVal = romanMap.get(s.charAt(i));

            // Check if the next numeral is larger than the current one
            if (i + 1 < length && currentVal < romanMap.get(s.charAt(i + 1))) {
                total -= currentVal;  // Subtract if next numeral is larger
            } else {
                total += currentVal;  // Add if next numeral is smaller or equal
            }
        }

        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        System.out.println(solution.romanToInt("III"));   // Output: 3

        // Example 2
        System.out.println(solution.romanToInt("LVIII")); // Output: 58

        // Example 3
        System.out.println(solution.romanToInt("MCMXCIV"));// Output: 1994
    }
}