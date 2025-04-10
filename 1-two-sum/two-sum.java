import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the number and its index
        HashMap<Integer, Integer> numMap = new HashMap<>();
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;
            
            // Check if the complement exists in the map
            if (numMap.containsKey(complement)) {
                // Return the indices of the complement and current number
                return new int[] { numMap.get(complement), i };
            }
            
            // Store the current number and its index in the map
            numMap.put(num, i);
        }
        
        // Return an empty array if no solution is found (though the problem guarantees one solution)
        return new int[] {};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Indices: [" + result1[0] + ", " + result1[1] + "]"); // Output: [0, 1]
        
        // Test case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Indices: [" + result2[0] + ", " + result2[1] + "]"); // Output: [1, 2]
        
        // Test case 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Indices: [" + result3[0] + ", " + result3[1] + "]"); // Output: [0, 1]
    }
}