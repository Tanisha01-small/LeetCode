class Solution {
    public int findKthLargest(int[] nums, int k) {
        // min heap formation of K-size
        PriorityQueue<Integer> min_heap=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            min_heap.add(nums[i]);
            if(min_heap.size()>k){
                min_heap.poll();
            }
        }
        
        return min_heap.peek();
         
    }
}