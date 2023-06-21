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
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        // code here, If the O is not at boundary then should be converted otherwise it won't be converted 
        int[][] visited=new int[n][m];
        char[][] ans   =new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j]=0;
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                     if(a[i][j]=='O'){
                         visited[i][j]=1;
                         dfs(n,m,i,j,visited,a);
                     }
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0){
                    ans[i][j]='X';
                }else{
                    ans[i][j]='O';
                }
            }
        }
        return ans;
    }
    
    public static void dfs(int n,int m,int row, int col,int[][] visited,char[][] a){
        visited[row][col]=1;
        
        int[] delrow={-1,0,0,1};
        int[] delcol={0,-1,1,0};
        
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && visited[nrow][ncol]==0 && a[nrow][ncol]=='O'){
                dfs(n,m,nrow,ncol,visited,a);
            }
        }
    }
}