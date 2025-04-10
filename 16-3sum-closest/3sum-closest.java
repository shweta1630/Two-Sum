import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array
        Arrays.sort(nums);
        
        // Initialize the variable to track the closest sum
        int closestSum = Integer.MAX_VALUE;
        
        // Iterate through the array, considering each element as the first number in the triplet
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements to avoid redundant triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            // Two-pointer approach
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                // Update closestSum if the current sum is closer to the target
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
                
                // Adjust pointers based on the comparison with the target
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    // If sum equals target, return the sum
                    return sum;
                }
            }
        }
        
        // Return the closest sum found
        return closestSum;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1)); // Output: 2
        
        // Example 2
        System.out.println(solution.threeSumClosest(new int[]{0, 0, 0}, 1)); // Output: 0
    }
}