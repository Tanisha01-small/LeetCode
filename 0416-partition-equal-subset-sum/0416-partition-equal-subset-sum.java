class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length; 
        for(int i=0;i<n;i++){
            sum+=nums[i];     
        }
        
         if(sum%2!=0){
                return false;
            }else{     
             return subsetSum(nums,sum/2);
         }
    }
        
        public boolean subsetSum(int[] arr,int s){
             int n=arr.length;
            boolean[][] dp=new boolean[n+1][s+1];
           
              for(int i=0;i<=n;i++){
                 for(int j=0;j<=s;j++){
                     if(i==0){
                         dp[i][j]=false;
                     }
                     if(j==0){
                         dp[i][j]=true;
                     }
                 }
             }
            
            for(int i=1;i<=n;i++){
                for(int j=1;j<=s;j++){
                    if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
                    }
                    
                    if(arr[i-1]>j){
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
            return dp[n][s];
            
        }
    
    }
