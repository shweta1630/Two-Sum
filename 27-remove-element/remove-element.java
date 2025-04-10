public class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // Pointer for the position of non-val elements

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // Move the non-val element to the k-th position
                k++; // Increment the count of valid elements
            }
        }

        // Return the count of elements that are not equal to val
        return k;
    }

    // Example to print the array and result
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        int k1 = solution.removeElement(nums1, val1);
        System.out.println("k = " + k1);
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println(); // Output will be 2 2

        // Example 2
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        int k2 = solution.removeElement(nums2, val2);
        System.out.println("k = " + k2);
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println(); // Output will be 0 1 3 0 4 (Order doesn't matter)
    }
}