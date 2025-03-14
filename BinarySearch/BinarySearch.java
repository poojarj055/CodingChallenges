class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Correct mid calculation
            
            if (nums[mid] == target) {
                return mid; // Target found
            }
            else if (nums[mid] > target) {
                right = mid - 1; // Search in left half
            }
            else {
                left = mid + 1; // Search in right half
            }
        }

        return -1; // Target not found
    }
}
