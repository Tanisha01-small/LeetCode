class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans=new ArrayList<>();
        int n=graph.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<n;i++){
            for(int it:graph[i])
            adj.get(it).add(i);
        }
        
        int[] indegree=new int[n];
        
        for(int i=0;i<n;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)q.add(i);
        }
        
        while(!q.isEmpty()){
            int node=q.peek();
            q.poll();
            ans.add(node);
            
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0)q.add(it);
            }
        }
        
        Collections.sort(ans);
        return ans;
    }
}