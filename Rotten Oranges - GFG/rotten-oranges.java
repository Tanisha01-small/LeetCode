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
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int row;
    int col;
    int time;
    
    Pair(int _row,int _col,int _time){
        this.row=_row;
        this.col=_col;
        this.time=_time;
    }
}

class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        Queue<Pair> q=new LinkedList<>();
        int countfresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    visited[i][j]=true;
                }else if(grid[i][j]==1){
                    visited[i][j]=false;
                    countfresh++;
                }else if(grid[i][j]==0){
                    visited[i][j]=true;
                }
            }
        }
        
        int tm=0;
        int count=0;
        int[] delrow={-1,0,0,1};
        int[] delcol={0,-1,1,0};
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int t  =q.peek().time;
            tm=Math.max(t,tm);
            q.poll();
            
            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m &&visited[nrow][ncol]==false){
                    visited[nrow][ncol]=true;
                    q.add(new Pair(nrow,ncol,t+1));
                    count++;
                }
            }
            
        }
        
        if(count!=countfresh){
            return -1;
        }
        
        return tm;
        
    }
    
    
}