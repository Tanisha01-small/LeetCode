class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        sb.append(s);
        sb.reverse();
        String sr=sb.toString();
        
        int[][] dp=new int[n+1][n+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==sr.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else if(s.charAt(i-1)!=sr.charAt(j-1)){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return n-dp[n][n];
    }
}