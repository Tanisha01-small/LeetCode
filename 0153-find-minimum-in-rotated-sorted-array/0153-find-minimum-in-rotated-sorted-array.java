class Solution {
    public int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start + ((end-start)/2);
            int prev=(mid+nums.length-1)%nums.length;
            int next=(mid+1)%nums.length;
            if(nums[start]<=nums[end]){
                return nums[start];
            }
            if(nums[mid]<nums[prev] && nums[mid]<nums[next]){
                return nums[mid];
            }
            
            if(nums[start]<=nums[mid]){
                start=mid+1;
            }else{
                end=mid-1;
        }
        
    }
        return nums[0];
}
}