class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor=image[sr][sc];
        int[][] ans=image;
        int[] delrow={-1,0,0,1};
        int[] delcol={0,-1,1,0};
        dfs(sr,sc,image,ans,iniColor,color,delrow,delcol);
        return ans;
    }
    
    public static void dfs(int sr,int sc,int[][] image,int[][] ans,int iniColor,int newColor,int[] delrow,int[] delcol){
        ans[sr][sc]=newColor;
        int n=image.length;
        int m=image[0].length;
        
        for(int i=0;i<4;i++){
            int newrow=sr+delrow[i];
            int newcol=sc+delcol[i];
            if(newrow>=0 && newcol>=0 && newrow<n && newcol<m && image[newrow][newcol]==iniColor && ans[newrow][newcol]!=newColor){
                dfs(newrow,newcol,image,ans,iniColor,newColor,delrow,delcol);
            }
        }
    }
}