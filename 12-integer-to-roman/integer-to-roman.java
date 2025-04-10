public class Solution {

    public String intToRoman(int num) {
        // Roman numeral mappings for standard and subtractive forms
        String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        StringBuilder result = new StringBuilder();
        
        // Loop through the values and symbols
        for (int i = 0; i < values.length; i++) {
            // While the current value can be subtracted from num
            while (num >= values[i]) {
                result.append(romanSymbols[i]);  // Append the corresponding Roman numeral symbol
                num -= values[i];               // Subtract the value from num
            }
        }
        
        return result.toString();  // Return the Roman numeral string
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int num1 = 3749;
        System.out.println(solution.intToRoman(num1));  // Output: "MMMDCCXLIX"

        // Example 2
        int num2 = 58;
        System.out.println(solution.intToRoman(num2));  // Output: "LVIII"

        // Example 3
        int num3 = 1994;
        System.out.println(solution.intToRoman(num3));  // Output: "MCMXCIV"
    }
}