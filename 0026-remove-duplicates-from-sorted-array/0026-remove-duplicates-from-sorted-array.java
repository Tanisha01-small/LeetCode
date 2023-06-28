class Solution {
    public int removeDuplicates(int[] nums) {
        
        LinkedHashSet<Integer> set=new LinkedHashSet<>();
        int k=0;
        
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                k++;
            }else{
                set.add(nums[i]);
            }
        }
        
        int n=nums.length-k;
        int[] expectedNums=new int[n];
        int j=0;
        for(int i:set){
            expectedNums[j++]=i;
        }
        
        for(int i=0;i<n;i++){
            nums[i]=expectedNums[i];
        }
        //Arrays.sort(nums);
        return n;
    }
}