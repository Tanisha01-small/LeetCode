class Solution {
    public int findCircleNum(int[][] isConnected) {
        // code here
        ArrayList<ArrayList<Integer>> adjls=new ArrayList<>();
        // matrix to list
        int V=isConnected.length;
        for(int i=0;i<V;i++){
            adjls.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjls.get(i).add(j);
                    adjls.get(j).add(i);
                }
            }
        }
        
        boolean[] visited=new boolean[V];
        int count=0;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                count++;
                dfs(i,adjls,visited);
            }
        }
        
        return count;
    }
    
    static void dfs(int node,ArrayList<ArrayList<Integer>> adjls,boolean[] visited){
        visited[node]=true;
        for(int it:adjls.get(node)){
            if(visited[it]==false){
                dfs(it,adjls,visited);
            }
        }
    } 
}