class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // if + is there then subtract otherwise plus for negative 
        if(nums.length==0 )return 0;
        if(nums.length==1){
            if(nums[0]==target || nums[0]==-target)return 1;
            else return 0;
        }
        
        return count(nums,target,0,0);
        }
    
    
    
    private int count(int[] nums,int target,int sum,int i){
        
        if(i==nums.length){
            if(sum==target){
                return 1;
            }else{
                return 0;
            }
        }
        
        int count1=count(nums,target,sum-nums[i],i+1);
        int count2=count(nums,target,sum+nums[i],i+1);
        
        return count1+count2;
    }
}



    