class Solution{
    static int[][][] dp=new int[201][201][2];
    static int countWays(int N, String S){
        // code here
        /* Find i and J, find base condition, K loop, temp answer function*/
        int i=0;
        int j=N-1;
        for (int in = 0; in <=N; in++) {
            for (int jn = 0; jn <= N; jn++) {
                for (int k = 0; k < 2; k++) {
                    dp[in][jn][k] =-1;
        }
    }
}
        return solve(S,i,j,1);
    }
    static int solve(String S,int i,int j,int istrue){
        if(i>j){
            return 0;
        }
        if(i==j){
            if(istrue==1){
                if(S.charAt(i)=='T'){
                    return 1;
                }else{
                return 0;
            }
        }else{
            if(S.charAt(i)=='F'){
                return 1;
            }else{
                return 0;
            }
        }
    }
    
    if(dp[i][j][istrue]!=-1){
        return dp[i][j][istrue];
    }
        int count=0;
        
        for(int k=i+1;k<=j-1;k=k+2){
            int lt=solve(S,i,k-1,1);
            int lf=solve(S,i,k-1,0);
            int rt=solve(S,k+1,j,1);
            int rf=solve(S,k+1,j,0);
            
            if(S.charAt(k)=='&'){
                if(istrue==1){
                    count +=lt*rt;
                }else{
                    count+=(lt*rf)+(lf*rf)+(lf*rt);
                }
            }else if(S.charAt(k)=='|'){
                if(istrue==1){
                    count+=(lt*rt)+(lt*rf)+(lf*rt);
                }else{
                    count +=lf*rf;
                }
            }else if(S.charAt(k)=='^'){
                if(istrue==1){
                    count +=(lt*rf) +(lf*rt);
                }else{
                    count += (lt*rt)+(lf*rf);
                }
            }
        }
        
        dp[i][j][istrue]=count%1003;
        
        return dp[i][j][istrue];
    }
}