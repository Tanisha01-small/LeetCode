class Solution {
    public int maxSubArray(int[] nums) {
        // O(n^2)
        int max=Integer.MIN_VALUE;
        // for(int i=0;i<nums.length;i++){
        //     int sum=0;
        //     for(int j=i;j<nums.length;j++){
        //         sum +=nums[j];
        //         max=Math.max(sum,max);
        //     }
        // }
        
        //Kadanes algo
        int sum=0;
        
        for(int i=0;i<nums.length;i++){
            sum +=nums[i];
            if(sum>max){
                max=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return max;
    }
}