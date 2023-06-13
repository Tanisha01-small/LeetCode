class Solution {
    static int[][] dp=new int[1001][1001];
    public int longestCommonSubsequence(String text1, String text2) {
        /* We will be doing 3 solutions 
        -Recursive
        *******************TLE FOR RECURSIVE *******************
         int n=text1.length();
        int m=text2.length();
        if(n==0 || m==0){
            return 0;
        }
        return longest(text1,text2,n,m);
    }
    
    private int longest(String text1, String text2, int s1,int s2){
        if(s1==0 || s2==0)return 0;
        
        if(text1.charAt(s1-1)==text2.charAt(s2-1)){
            return 1+longest(text1,text2,s1-1,s2-1);
        }else if(text1.charAt(s1-1)!=text2.charAt(s2-1)){
            return Math.max(longest(text1,text2,s1-1,s2),longest(text1,text2,s1,s2-1));
        }
        return 0;
        
        
        -Memoization
        
        int n=text1.length();
        int m=text2.length();
        if(n==0 || m==0){
            return 0;
        }
        dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j]=-1;
            }
        }
        
        return longest(text1,text2,n,m);
    }
    
     private int longest(String text1, String text2, int s1,int s2){
        if(s1==0 || s2==0)return 0;
        
         if(dp[s1][s2]!=-1){
             return dp[s1][s2];
         }
        if(text1.charAt(s1-1)==text2.charAt(s2-1)){
            return dp[s1][s2]=1+longest(text1,text2,s1-1,s2-1);
        }else if(text1.charAt(s1-1)!=text2.charAt(s2-1)){
            return dp[s1][s2]= Math.max(longest(text1,text2,s1-1,s2),longest(text1,text2,s1,s2-1));
        }
        return 0;
        
        -Top down approach
        
        common thing is first to check whether any string is empty or not our input should get smaller soo for next condition if the value is same then we can move infex of both strings if not we will have a choice for both the strings to first take one of the string complete and other one without the last element.
        */
        int n=text1.length();
        int m=text2.length();
       
        dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else if(text1.charAt(i-1)!=text2.charAt(j-1)){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
        
        
     }
}