//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[][] dp=new int[501][501];
    static int palindromicPartition(String str)
    {
        // code here
        int i=0;
        int j=str.length()-1;
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(str,i,j);
    }
    
    static int solve(String str, int i,int j){
        if(i>=j){
            return 0;
        }
        
         if(ispal(str,i,j)==true){
            return 0;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
       
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int temp=solve(str,i,k)+solve(str,k+1,j)+1;
            
            ans=Math.min(ans,temp);
        }
        dp[i][j]=ans;
        return ans;
    }
    
    static boolean ispal(String str,int i,int j){
        while(i<=j){
                if(str.charAt(i)!=str.charAt(j)){
                   return false; 
        }
        
        i++;
        j--;
    }
    return true;
}
}