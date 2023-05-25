class Solution {
    public int peakIndexInMountainArray(int[] nums){
        int start = 0;
        int end = nums.length - 1;

        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return 0;
        }

        while (start <= end) {
            int m = start + ((end - start) / 2);

            if (m > 0 && m < nums.length - 1) {
                if (nums[m] > nums[m + 1] && nums[m] > nums[m - 1]) {
                    return m;
                } else if (nums[m] < nums[m - 1]) {
                    end = m - 1;
                } else if (nums[m] < nums[m + 1]) {
                    start = m + 1;
                }
            } else {
                if (m == 0) {
                    if (nums[m] > nums[m + 1]) {
                        return 0;
                    } else {
                        return 1;
                    }
                } else if (m == nums.length - 1) {
                    if (nums[m] > nums[m - 1]) {
                        return nums.length - 1;
                    } else {
                        return nums.length - 2;
                    }
                }
            }
        }
        return -1;
    }
}