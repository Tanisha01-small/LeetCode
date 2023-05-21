class Solution {
    public boolean containsDuplicate(int[] nums) {
        //TIME COMPLEXITY IS O(N^2)
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]==nums[j]) return true;
        //     }
        // }
        // return false;

// TC=O(NLOGN)
        // Arrays.sort(nums);
        // for(int i=0;i<nums.length-1;i++){
        //   if(nums[i]==nums[i+1])return true;
        // }
        // return false;

//TC=O(N)
        Set<Integer> unique=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
          if(unique.contains(nums[i]))return true;
          unique.add(nums[i]);
        }
        return false;
    }
}