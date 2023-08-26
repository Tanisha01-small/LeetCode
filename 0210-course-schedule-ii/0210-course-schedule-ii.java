class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0;i<prerequisites.length;i++){
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        for(int i=0;i<numCourses;i++){
            for(int it:list.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)q.add(i);
        }
        
        int[] topo=new int[numCourses];
        int index=0;
        while(!q.isEmpty()){
            int node=q.peek();
            q.poll();
            topo[index]=node;
            index++;
            
            for(int it:list.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        
        if(index==numCourses)return topo;
         return new int[0];
    }
}