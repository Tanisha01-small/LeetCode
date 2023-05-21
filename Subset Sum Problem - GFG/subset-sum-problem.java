//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        // if(sum==0 ){
        //     return true;
        // }
        // if(sum!=0 && N==0){
        //     return false;
        // }
        
        // if(arr[N-1]<=sum){
        //     return (isSubsetSum(N-1,arr,sum-arr[N-1])||isSubsetSum(N-1,arr,sum));
        // }
        
        // if(arr[N-1]>sum){
        //     return isSubsetSum(N-1,arr,sum);
        // }
        
        // return false;
        
        boolean[][] dp=new boolean[N+1][sum+1];
        
        for(int i=0;i<=N;i++){
            for(int j=0;j<=sum;j++){
                if(i==0){
                    dp[i][j]=false;
                }
                if(j==0){
                    dp[i][j]=true;
                }
            }
        }
        
        for(int i=1;i<=N;i++){
           for(int j=0;j<=sum;j++){
               
        
        if(arr[i-1]<=j){
             dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
        }
        
        if(arr[i-1]>sum){
             dp[i][j]=dp[i-1][j];
    }
}
    }
    
    return dp[N][sum];
}
}