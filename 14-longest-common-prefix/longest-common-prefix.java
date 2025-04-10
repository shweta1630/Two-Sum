public class Solution {

    /**
     * Finds the longest common prefix string amongst an array of strings.
     * 
     * @param strs The array of strings
     * @return The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // If the array is empty, return an empty string
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start by assuming the first string is the common prefix
        String prefix = strs[0];

        // Iterate through all the strings in the array
        for (int i = 1; i < strs.length; i++) {
            // Compare the current prefix with the current string
            while (strs[i].indexOf(prefix) != 0) {
                // If prefix is not found, shorten the prefix by one character
                prefix = prefix.substring(0, prefix.length() - 1);
                // If there is no common prefix, return an empty string
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        // Return the longest common prefix
        return prefix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println(solution.longestCommonPrefix(strs1));  // Output: "fl"

        // Example 2
        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println(solution.longestCommonPrefix(strs2));  // Output: ""
    }
}