// class Solution {
//     public String shortestCommonSupersequence(String str1, String str2) {
//         int n=str1.length();
//         int m=str2.length();
//         int[][] dp=new int[n+1][m+1];
        
//         for(int i=0;i<=n;i++){
//             for(int j=0;j<=m;j++){
//                 if(i==0 || j==0){
//                     dp[i][j]=0;
//                 }
//             }
//         }
        
//         for(int i=1;i<=n;i++){
//             for(int j=1;j<=m;j++){
//                 if(str1.charAt(i-1)==str2.charAt(j-1)){
//                     dp[i][j]=1+dp[i-1][j-1];
//                 }else if(str1.charAt(i-1)!=str2.charAt(j-1)){
//                     dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
//                 }  
//             }
//         }
        
//         int i=n;
//         int j=m;
        
//         StringBuilder sb=new StringBuilder();
        
//         while(i >0 && j>0){
//               if(str1.charAt(i-1)==str2.charAt(j-1)){
//                     sb.append(str1.charAt(i-1));
//                   i--;
//                   j--;
//                 }else {
//                   if(dp[i-1][j]>dp[i][j-1]){
//                       i--;
//                   }else{
//                       j--;
//                   }
//               }  
//         }
        
// //         String s=sb.reverse().toString();
        
// //         if(str1.length()>=str2.length()){
// //            StringBuilder fin=new StringBuilder(str1);
// //             String f=fin.toString().replace(s,"");
// //              StringBuilder f2=new StringBuilder(str2);
// //             return f2.append(f).toString();
// //         }else{
// //              StringBuilder fin=new StringBuilder(str2);
// //             String f=fin.toString().replace(s,"");
// //              StringBuilder f2=new StringBuilder(str1);
// //              return f2.append(f).toString();
// //         }
        
//         while (i > 0) {
//             sb.append(str1.charAt(i-1));
//             i--;
//         }
        
//         while (j > 0) {
//             sb.append(str2.charAt(j-1));
//             j--;
//         }
        
//         return sb.reverse().toString();
        
//     }
// }

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        // Construct the dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // Build the shortest common supersequence
        StringBuilder sb = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (str1.charAt(i-1) == str2.charAt(j-1)) {
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            } else {
                if (dp[i-1][j] > dp[i][j-1]) {
                    sb.append(str1.charAt(i-1));
                    i--;
                } else {
                    sb.append(str2.charAt(j-1));
                    j--;
                }
            }
        }

        // Append remaining characters from str1
        while (i > 0) {
            sb.append(str1.charAt(i-1));
            i--;
        }

        // Append remaining characters from str2
        while (j > 0) {
            sb.append(str2.charAt(j-1));
            j--;
        }

        return sb.reverse().toString();
    }
}
