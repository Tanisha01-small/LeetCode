class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] visited=new int[n][m];
        //char[][] ans   =new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j]=0;
            }
        }
        
        //For first row and last row
        
//         for(int j=0;j<m;j++){
//             if(visited[0][j]==0 && board[0][j]=='O'){
//                 dfs(n,m,0,j,visited,board);
//             }
//               if(visited[m-1][j]==0 && board[m-1][j]=='O'){
//                 dfs(n,m,m-1,j,visited,board);
//             }
//         }
        
//              for(int i=0;i<n;i++){
//             if(visited[i][0]==0 && board[i][0]=='O'){
//                 dfs(n,m,i,0,visited,board);
//             }
//               if(visited[i][n-1]==0 && board[i][n-1]=='O'){
//                 dfs(n,m,i,n-1,visited,board);
//             }
//         }
        
          for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                     if(board[i][j]=='O'){
                         visited[i][j]=1;
                         dfs(n,m,i,j,visited,board);
                     }
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0){
                    board[i][j]='X';
                }else{
                    board[i][j]='O';
                }
            }
        }

    }
    
    public void dfs(int n,int m,int row, int col,int[][] visited,char[][] a){
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