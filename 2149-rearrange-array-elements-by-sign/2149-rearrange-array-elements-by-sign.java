class Solution {
    public int[] rearrangeArray(int[] nums) {
        int e=0;
        int o=1;
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                ans[e]=nums[i];
                e+=2;
            }else{
                ans[o]=nums[i];
                o+=2;
            }
        }
        return ans;
    }
}