class Solution {
    //See in this as islands are connected soo this is a graph problem and first we need a 2d arry only because to do bfs or dfs and mark both the visited areas as it's a matrix soo we need to mark the visited nodes simultaneously.ANd then we will check for it's neighbous in all 8 directions.water doesn't count . and thr moment stack or queue becomes empty it means that the region around that island group is covered soo increase the count of island by 1.ANd how we know it's a graph problem by looking that there is connection and islands are connected to each other.Let's do BFS in this.
    // public ArrayList<Integer> bfs(int v,ArrayList<ArrayList<Inter>> adj){
    //     ArrayList<Integer> bfss=new ArrayList<>();
    //     boolean[] visited=new boolean[v];
    //     Queue<Integer> q=neq LinkedList<>();

    //     q.offer(0);
    //     visited[0]=true;

    //     while(!q.isEmpty){
    //         int u=q.poll();
    //         bfss.add(u);

    //         for(int i:adj.get(u)){
    //             if(visited==false){
    //                 visited=true;
    //                 q.offer(i);
    //             }
    //         }
    //     }
    //     return bfss;
    // }
    
    public int numIslands(char[][] grid) {
             

        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    drawGraph(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;   
    }

    public static void drawGraph(char[][] arr,int i,int j, boolean[][] visited){
       if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == '0' || visited[i][j]) {
    return;
}

        
        visited[i][j]=true;
        //Queue<Integer> q=new LinkedList<>();

        drawGraph(arr,i-1,j,visited);
        drawGraph(arr,i,j+1,visited);
        drawGraph(arr,i,j-1,visited);
        drawGraph(arr,i+1,j,visited);
    }

}