//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class  Pair{
    int first;
    int second;
    public Pair(int v,int wt){
        this.first=v;
        this.second=wt;
    }
}
class Solution {

	public int[] shortestPath(int N,int M, int[][] edge) {
		//Code here
		// convert of array to adj list
		ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
		for(int i=0;i<N;i++){
		    ArrayList<Pair> t=new ArrayList<>();
		    adj.add(t);
		}
		
		for(int i=0;i<M;i++){
		    int s=edge[i][0];
		    int e=edge[i][1];
		    int weight=edge[i][2];
		    adj.get(s).add(new Pair(e,weight));
		}
		
		int[] visited=new int[N];
		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<N;i++){
		    if(visited[i]==0){
		        dfs(i,visited,adj,stack);
		    }
		}
		
		int[] distance=new int[N];
		
		for(int i=0;i<N;i++){
		    distance[i]=(int)(1e9);
		}
		
		distance[0]=0;
		while(!stack.isEmpty()){
		    int node=stack.peek();
		    stack.pop();
		    
		    for(int i=0;i<adj.get(node).size();i++){
		        int v=adj.get(node).get(i).first;
		        int wt=adj.get(node).get(i).second;
		        if(distance[node]+wt<distance[v]){
		            distance[v]=distance[node]+wt;
		        }
		    }
		}
		for(int i=0;i<N;i++){
		    if(distance[i]==1e9){
		        distance[i]=-1;
		    }
		}
		
		return distance;
	}
	
	public void dfs(int node,int[] visited,ArrayList<ArrayList<Pair>> adj,Stack<Integer> stack){
	    visited[node]=1;
	    for(int i=0;i<adj.get(node).size();i++){
	        int n=adj.get(node).get(i).first;
	        if(visited[n]==0){
	            dfs(n,visited,adj,stack);
	        }
	    }
	    
	    stack.push(node);
	}
}