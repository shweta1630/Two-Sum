public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure that nums1 is the smaller array
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0, right = m;
        while (left <= right) {
            int partition1 = (left + right) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;

            // Handle edge cases where partitions are at the boundaries
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            // Check if the partition is valid
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Found the correct partition
                if ((m + n) % 2 == 0) {
                    // Even total length, return the average of the max of the left and min of the right
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    // Odd total length, return the max of the left side
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                // We need to move the partition1 to the left
                right = partition1 - 1;
            } else {
                // We need to move the partition1 to the right
                left = partition1 + 1;
            }
        }

        // If we reach here, that means the input arrays were not sorted or there was an error
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2)); // Output: 2.0

        // Test case 2
        int[] nums1_2 = {1, 2};
        int[] nums2_2 = {3, 4};
        System.out.println(solution.findMedianSortedArrays(nums1_2, nums2_2)); // Output: 2.5

        // Test case 3
        int[] nums1_3 = {0, 0};
        int[] nums2_3 = {0, 0};
        System.out.println(solution.findMedianSortedArrays(nums1_3, nums2_3)); // Output: 0.0
    }
}