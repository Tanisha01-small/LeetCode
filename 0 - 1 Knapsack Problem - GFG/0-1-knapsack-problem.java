//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends



class Solution {
    private static int[][] dp;

    static int knapSack(int W, int wt[], int val[], int n) {
        dp = new int[n + 1][W + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return knapSackRecursive(W, wt, val, n);
    }

    private static int knapSackRecursive(int W, int wt[], int val[], int n) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (W >= wt[n - 1]) {
            return dp[n][W] = Math.max(val[n - 1] + knapSackRecursive(W - wt[n - 1], wt, val, n - 1),
                    knapSackRecursive(W, wt, val, n - 1));
        } else {
            return dp[n][W] = knapSackRecursive(W, wt, val, n - 1);
        }
    }
}
