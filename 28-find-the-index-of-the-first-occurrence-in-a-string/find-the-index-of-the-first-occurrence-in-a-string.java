public class Solution {

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle); // Returns the index of the first occurrence or -1 if not found
    }

    public static void main(String[] args) {
        // Test cases
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println("Result for haystack1, needle1: " + strStr(haystack1, needle1));  // Output: 0

        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println("Result for haystack2, needle2: " + strStr(haystack2, needle2));  // Output: -1
    }
}