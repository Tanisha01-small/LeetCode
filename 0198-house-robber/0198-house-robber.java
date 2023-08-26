class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return min(nums,nums.length-1,dp);
    }
    
    public int min(int[] nums,int index,int[] dp){
        
        if(index<0)return 0;
        dp[0]=nums[0];
        if(dp[index]!=-1)return dp[index];
        
        int pick=nums[index]+min(nums,index-2,dp);
        int np=0+min(nums,index-1,dp);
        return dp[index]=Math.max(np,pick);
    }
}