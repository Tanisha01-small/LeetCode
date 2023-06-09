//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

// class Pair{
//     int value;
//     int vp;
//     Pair(int _value,int _vp){
//         this.value=_value;
//         this.vp=_vp;
//     }
// }
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            visited[i]=false;
        }
        for(int i=0;i<V;i++){
            if(!visited[i]){
               if(/*bfs(i,adj,visited*/dfs(i,adj,visited,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    
    // public boolean bfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited){
    //     visited[node]=true;
    //     Queue<Pair> q=new LinkedList<>();
    //     q.add(new Pair(node,-1));
        
    //     while(!q.isEmpty()){
    //         int it=q.peek().value;
    //         int parent=q.peek().vp;
    //         q.poll();
            
    //         for(int adjnode:adj.get(it)){
    //             if(visited[adjnode]==false){
    //                 visited[adjnode]=true;
    //                 q.add(new Pair(adjnode,it));
    //             }else if(parent!=adjnode){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    
       public boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited,int parent){
        visited[node]=true;
    
            for(int adjnode:adj.get(node)){
                if(visited[adjnode]==false ){
                    visited[adjnode]=true;
                    if(dfs(adjnode,adj,visited,node))return true;
                }else if(adjnode!=parent){
                    return true;
                }
            }
        
        return false;
    }
}