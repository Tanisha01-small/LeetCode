class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // either take or not take 
        
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        powerset(nums,0,list,list2);
        return list;
    }
    
    public void powerset(int[] nums,int i, List<List<Integer>> ne,List<Integer> old ){
        if(i==nums.length){
            ne.add(new ArrayList<>(old));
            return;
        }
        old.add(nums[i]);
        powerset(nums,i+1,ne,old);
        old.remove(old.size()-1);
        powerset(nums,i+1,ne,old);
    }
}