class Solution {
    public int[] searchRange(int[] nums, int target) {
        //int[] ans = {-1, -1};
        // First Occurrence
        int start = 0, end = nums.length - 1;
        int first=-1;
        int last=-1;
        
        while (start <= end) {
            int mid = start + ((end-start)/2);
            if (target == nums[mid]) {
                first = mid;
                end = mid - 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            }
        }
        
        start = 0;
        end = nums.length - 1;
        while (start <= end) {
            int mid = start + ((end-start)/2);
            if (target == nums[mid]) {
                last = mid;
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            }
        }
        return new int[]{first,last};
    }
}