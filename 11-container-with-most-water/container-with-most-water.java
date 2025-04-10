public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        // Iterate while the two pointers don't meet
        while (left < right) {
            // Calculate the area with the current two lines
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = width * currentHeight;
            
            // Update maxArea if we found a larger area
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointer that points to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // Output: 49
        
        // Example 2
        System.out.println(solution.maxArea(new int[]{1, 1})); // Output: 1
    }
}