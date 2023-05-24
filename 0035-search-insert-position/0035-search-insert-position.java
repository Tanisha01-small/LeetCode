class Solution {
    public int searchInsert(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int res=-1;
        while(start<=end){
            int mid=start+((end-start)/2);
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                res=mid+1;
                start=mid+1;
            }else if(nums[mid]>target) {
                res=mid;
                end=mid-1;
            }
        }
        return res;
    }
}