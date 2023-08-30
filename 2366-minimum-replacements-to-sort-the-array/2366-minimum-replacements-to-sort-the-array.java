class Solution {
    public long minimumReplacement(int[] nums) {
        int last=nums[nums.length-1];
        long count=0;
        int steps=0;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<=last) {
                last=nums[i];
         }else{
                steps=(nums[i]-1)/last ;
                last=nums[i]/(steps+1);
                count+=steps;
            }
     }
        
        return count;
  }
}


        