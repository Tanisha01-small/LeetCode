public class Main {
    public static void main(String[] args) {
        //Solution solution = new Solution();
        String t1 = "ABCD";
        String t2 = "ACDF";
        System.out.println(lcs(t1,t2)); // Output: "ACD"
    }
    
        public static String lcs(String t1,String t2){
        int n=t1.length();
        int m=t2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(t1.charAt(i-1)==t2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else if(t1.charAt(i-1)!=t2.charAt(j-1)){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        int i=n;
        int j=m;
        StringBuilder s=new StringBuilder();
        while(i>0 && j>0){
            if(t1.charAt(i-1)==t2.charAt(j-1)){
                s.append(t1.charAt(i-1));
                i--;
                j--;
            }else {
                if(dp[i-1][j]>dp[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }
        return s.reverse().toString();
    }

}