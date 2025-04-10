import java.util.*;

public class Solution {
    // Mapping of digits to letters
    private static final String[] MAPPING = {
        "",     // index 0, no digit 0
        "",     // index 1, no digit 1
        "abc",   // index 2
        "def",   // index 3
        "ghi",   // index 4
        "jkl",   // index 5
        "mno",   // index 6
        "pqrs",  // index 7
        "tuv",   // index 8
        "wxyz"   // index 9
    };

    // Function to return all letter combinations
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Edge case: If input string is empty
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        // Start the backtracking process
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    // Backtracking function to generate all possible combinations
    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // If the current string length matches the digits length, add it to the result
        if (current.length() == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        // Get the letters corresponding to the current digit
        String letters = MAPPING[digits.charAt(index) - '0'];
        
        // Explore each letter for the current digit
        for (char letter : letters.toCharArray()) {
            current.append(letter);  // Choose the letter
            backtrack(digits, index + 1, current, result);  // Recurse for the next digit
            current.deleteCharAt(current.length() - 1);  // Backtrack and remove the letter
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        String digits1 = "23";
        System.out.println(solution.letterCombinations(digits1));  // Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

        // Example 2
        String digits2 = "";
        System.out.println(solution.letterCombinations(digits2));  // Output: []

        // Example 3
        String digits3 = "2";
        System.out.println(solution.letterCombinations(digits3));  // Output: ["a", "b", "c"]
    }
}