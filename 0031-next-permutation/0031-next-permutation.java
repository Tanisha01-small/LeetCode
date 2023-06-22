class Solution {
    public void nextPermutation(int[] nums) {
        // to generate all solutions in sorted order and search for th next permutation of nums given,need to find the breakpoint,i<i+1,now number just greater than i and then sort the remaining numbers with remaining part .
        
        int index=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        
        if(index==-1){
            reverse(nums,0,nums.length-1);
            return;
        }
        
        for(int i=nums.length-1;i>index;i--){
            if(nums[i]>nums[index]){
                swap(nums,i,index);
                break;
            }
        }
        
        reverse(nums,index+1,nums.length-1);
    }
    
    public void swap(int[] nums,int a ,int b){
        int temp=nums[b];
        nums[b]=nums[a];
        nums[a]=temp;
    }
    
    public void reverse(int[] nums,int start,int end){
        if(start>=end){
            return;
        }
        
        swap(nums,start,end);
        reverse(nums,start+1,end-1);
    }
}