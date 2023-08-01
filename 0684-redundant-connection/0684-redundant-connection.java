class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        List<Set<Integer>> list=new ArrayList<>();
        
        for(int i=0;i<n+1;i++){
            list.add(new HashSet<>());
        }
        
        int[] arr=new int[2];
        
        for(int[] it:edges){
            int u=it[0];
            int v=it[1];
            if(dfs(list,u,v,0)){
                arr=it;
            }else{
                list.get(u).add(v);
                list.get(v).add(u);
            }
        }
        return arr;
        
    }
    
    boolean dfs(List<Set<Integer>> list,int u,int v,int parent){
        
        if(u==v)return true;
        for(int it:list.get(u)){
            if(it==parent)continue;
            boolean t=dfs(list,it,v,u);
            if(t)return true;
        }
        
        return false;
    }
}