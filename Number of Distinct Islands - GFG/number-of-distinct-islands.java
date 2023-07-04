//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        HashSet<ArrayList<Integer>> set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    visited[i][j]=false;
                }else if(grid[i][j]==0){
                    visited[i][j]=true;
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==false){
                    ArrayList<Integer> fin=new ArrayList<>();
                    dfs(i,j,visited,grid,fin,i,j,n,m);
                    set.add(fin);
                }
            }
        }
        
        return set.size();
    }
    
    public void dfs(int row,int col,boolean[][] visited,int[][] grid, ArrayList<Integer> fin,int row0,int col0,int n,int m){
        visited[row][col]=true;
        fin.add(row-row0);
        fin.add(col-col0);
        
        int[] delrow={-1,0,0,1};
        int[] delcol={0,1,-1,0};
        
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            
            
            if(nrow>=0 && ncol >=0 && ncol<m && nrow<n && visited[nrow][ncol]==false){
                dfs(nrow,ncol,visited,grid,fin,row0,col0,n,m);
            }
        }
        
    }
}
