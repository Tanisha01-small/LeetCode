//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] vis=new int[V];
        int[] path=new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,V,adj,vis,path)==true)return true;
            }
        }
        
        return false;
    }
    
    public boolean dfs(int node,int V, ArrayList<ArrayList<Integer>> adj,int[] vis,int[] path){
        vis[node]=1;
        path[node]=1;
        
        for(int it:adj.get(node)){
            if(vis[it]==0){
                if(dfs(it,V,adj,vis,path)==true)return true;
            }else if(path[it]==1){
                return true;
            }
        }
        
        path[node]=0;
        return false;
    }
}