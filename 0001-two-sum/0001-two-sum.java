class Solution {
    public int[] twoSum(int[] nums, int target) {
        //TC=O(N^2)
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]+nums[j]==target){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return new int[]{-1};

        //USING HASHING

        HashMap<Integer,Integer> twosum=new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++){
            int temp=nums[i];
            int diff=target-temp;

            if(twosum.containsKey(diff)){
                return new int[]{twosum.get(diff),i};
            }
            twosum.put(temp,i);
        }
        return new int[] {};
    }
}