class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seq=new HashSet<>();

        for(int n:nums){
            seq.add(n);
        }
        int longseq=0;
        for(int n:seq){
            if(!seq.contains(n-1)){
                int currentnum=n;
                int sequences=1;
            

            while(seq.contains(currentnum+1)){
                currentnum +=1;
                sequences +=1;
            }
            longseq=Math.max(longseq,sequences);
            }
        }
        return longseq;
    }
        }






        // Arrays.sort(nums);
        // int count=1;
        // int res=1;
        // if(nums.length==0){
        //     return 0;
        // }
        // for(int i=1;i<nums.length;i++){
        //     if(nums[i]-nums[i-1]==1){
        //         count++;
        //     }else if(nums[i]-nums[i-1]>1 ){
        //     break;
        //     }

        // }
        
        // for(int i=count+1;i<nums.length;i++){
        //     if(nums[i]-nums[i-1]==1){
        //         res++;
        //     }else if(nums[i]-nums[i-1]>1){
        //     break ;
        //     }
        // }
        // return Math.max(count,res);
    