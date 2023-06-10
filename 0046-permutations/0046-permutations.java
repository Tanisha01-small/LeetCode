class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> per=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        boolean[] map=new boolean[nums.length];
        permutation(nums,per,ds,map);
        return per;
    }
    
    public void permutation(int[] nums,List<List<Integer>> per,List<Integer> ds,boolean[] map){
        if(ds.size()==nums.length){
            per.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(!map[i]){
                map[i]=true;
                ds.add(nums[i]);
                permutation(nums,per,ds,map);
                ds.remove(ds.size()-1);
                map[i]=false;
            }
        }
    }
}