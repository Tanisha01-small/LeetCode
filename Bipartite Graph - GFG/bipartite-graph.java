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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        //Queue<Integer> q=new LinkedList<>();
        int[] visited=new int[V];
        
        for(int i=0;i<V;i++){
            visited[i]=-1;
        }
        
         for(int i=0;i<V;i++){
            if(visited[i]==-1){
                //if(bfs(visited,i,adj,V)==false)return false;
                if(dfs(visited,i,adj,V,0)==false)return false;
            }
        }
        
        return true;
    }
    // 0 and 1 for painting 
    public boolean dfs(int[] visited,int node,ArrayList<ArrayList<Integer>>adj,int V,int color){
       // Queue<Integer> q=new LinkedList<>();
        //q.add(node);
        visited[node]=color;
        
        // while(!q.isEmpty()){
        //     int n=q.peek();
        //     q.poll();
            
            for(int it:adj.get(node)){
                if(visited[it]==-1){
                    //visited[it]=1-color;
                    //q.add(it);
                    if(dfs(visited,it,adj,V,1-color)==false)return false;
                }else if(visited[it]==color){
                    return false;
                }
            }
        //}
        
        return true;
    }
}