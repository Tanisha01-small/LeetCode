class Solution {
    List<List<Integer>> sum=new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i==0 || nums[i-1]!=nums[i]){
                twosum(i+1,nums.length-1,nums,0-nums[i]);
            }
        }
        return sum;
    }
    
    public void twosum(int i,int j,int[] nums, int target){
        int a=nums[i-1];
        
        while(i<j){
            if(nums[i]+nums[j]<target){
                i++;
            }else if(nums[i]+nums[j]>target){
                j--;
            }else{
                List<Integer> list=new ArrayList<>();
                list.add(a);
                list.add(nums[i]);
                list.add(nums[j]);
                sum.add(list);
                while(i<j && nums[i]==nums[i+1])i++;
                while(i<j && nums[j]==nums[j-1])j--;
                
                i++;
                j--;
            }
        }
    }
}