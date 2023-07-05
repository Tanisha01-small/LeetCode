//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

// class Pair{
//     int v;
//     int wt;
//     public Pair(int v,int wt){
//         this.v=v;
//         this.wt=wt;
//     }
// }

class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        Queue<Integer> q=new LinkedList<>();
        int[] distance=new int[n];
        q.add(src);
        
        for(int i=0;i<n;i++){
            distance[i]=(int)(1e9);
        }
        
        distance[src]=0;
        
        // conversion of array to adj list
        
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        while(!q.isEmpty()){
            int node=q.peek();
            q.poll();
            for(int it:adj.get(node)){
                if(distance[node]+1<distance[it]){
                    distance[it]=distance[node]+1;
                    q.add(it);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(distance[i]==1e9){
                distance[i]=-1;
            }
        }
        
        return distance;
    }
}