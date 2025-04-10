public class Solution {

    /**
     * Removes duplicates from a sorted array in-place and returns the number of unique elements.
     *
     * @param nums The input sorted array
     * @return The number of unique elements
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;  // No elements to process
        }

        // Pointer to keep track of the next unique element's position
        int i = 1;

        // Start iterating from the second element
        for (int j = 1; j < nums.length; j++) {
            // If the current element is different from the previous one
            if (nums[j] != nums[j - 1]) {
                // Place the unique element at the current position of i
                nums[i] = nums[j];
                i++;  // Move i to the next position
            }
        }

        return i;  // i will represent the number of unique elements
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {1, 1, 2};
        int k1 = solution.removeDuplicates(nums1);
        System.out.println(k1);  // Output: 2
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " ");  // Output: 1 2
        }

        System.out.println();

        // Example 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = solution.removeDuplicates(nums2);
        System.out.println(k2);  // Output: 5
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " ");  // Output: 0 1 2 3 4
        }
    }
}