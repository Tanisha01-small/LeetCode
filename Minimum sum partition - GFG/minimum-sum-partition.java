//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int range=0;
	    for(int i=0;i<n;i++){
	        range +=arr[i];
	    }
	    return subsetsum(arr,range,n);
	}
	
	private int subsetsum(int[] arr,int range,int n){
	    boolean[][] dp=new boolean[n+1][range+1];
	    
	    for(int i=0;i<=n;i++){
	        for(int j=0;j<=range;j++){
	            if(i==0){
	                dp[i][j]=false;
	            }
	            if(j==0){
	                dp[i][j]=true;
	            }
	        }
	    }
	    
	    for(int i=1;i<=n;i++){
	        for(int j=1;j<=range;j++){
	            if(arr[i-1]<=j){
	                dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
	            }else if(arr[i-1]>j){
	                dp[i][j]=dp[i-1][j];
	            }
	        }
	    }
	    
	    int[] sum=new int[(range/2)+1];
	    for(int i=0;i<sum.length;i++){
	        if(dp[n][i]==true){
	            sum[i]=i;
	        }
	    }
	    
	    int min=range;
	    
	    for(int i=0;i<sum.length;i++){
	        min=Math.min(min,range-2*sum[i]);
	    }
	    return min;
	    
	}
}
