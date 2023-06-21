//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends

class Pair{
    int row;
    int col;
    int distance;
    
    Pair(int _row,int _col,int _distance){
        this.row=_row;
        this.col=_col;
        this.distance=_distance;
    }
}
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int[][] ans=new int[n][m];
        int[][] visited=new int[n][m];
        Queue<Pair> q=new LinkedList<Pair>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                 if(grid[i][j]==1){
                    q.add(new Pair(i,j,0));
                    visited[i][j]=1;
                }else{
                    visited[i][j]=0;
                    
                }
            }
        }
        //i will the ans 0 only when the number is 1 in originial grid
        
        int[] delrow={-1,0,0,1};
        int[] delcol={0,-1,1,0};
        
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int dis=q.peek().distance;
            q.poll();
            ans[r][c]=dis;
            for(int i=0;i<4;i++){
                    int nrow=r+delrow[i];
                    int ncol=c+delcol[i];
                    
                    if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && visited[nrow][ncol]==0){
                        visited[nrow][ncol]=1;
                        q.add(new Pair(nrow,ncol,dis+1));
                    }
                }
            }
        
        
        return ans;
        
        
    }
}