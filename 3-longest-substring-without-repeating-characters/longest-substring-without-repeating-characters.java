import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Set to keep track of characters in the current window
        HashSet<Character> charSet = new HashSet<>();
        int left = 0;  // Left pointer of the sliding window
        int maxLength = 0;

        // Traverse the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            // If the character is already in the set, shrink the window from the left
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the set
            charSet.add(s.charAt(right));

            // Update the max length of the substring
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));  // Output: 3
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));     // Output: 1
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));    // Output: 3
    }
}