class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] max=new int[n-k+1];
        int i=0;
        int j=0;
        int x=0;
        int maxi=Integer.MIN_VALUE;
        Deque<Integer> d=new ArrayDeque<>();
        while(j<n){
            if(d.size()==0){
                d.add(nums[j]);
            }else{
                while(d.size()>0 && d.peekLast()<nums[j]){
                    d.removeLast();
                }
                d.add(nums[j]);
            }
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                max[x]=d.peek();
                x++;
                if(nums[i]==d.peek()){
                    d.removeFirst();
                }
                
                i++;
                j++;
            }
        }
        
        return max;
    }
}