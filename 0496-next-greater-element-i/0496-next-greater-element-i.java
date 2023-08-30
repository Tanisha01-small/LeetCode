class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
        int[] ans=new int[nums1.length]; 
         HashMap<Integer,Integer> map=new HashMap<>(); 
        
        for(int i=nums2.length-1;i>=0;i--){
                if(stack.size()==0){
                    map.put(nums2[i],-1);
                }
                else if(!stack.isEmpty() && stack.peek()>nums2[i]){
                    map.put(nums2[i],stack.peek());
                }else if(!stack.isEmpty() && stack.peek()<=nums2[i]){
                    while(!stack.isEmpty() && stack.peek()<=nums2[i]){
                        stack.pop();
                    }
                    if(stack.size()==0) map.put(nums2[i],-1);
                    else{
                        map.put(nums2[i],stack.peek());
                    }
                }
                
                stack.push(nums2[i]);
            }
        
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                ans[i]=map.get(nums1[i]);
            }
        }
        
        return ans;
    }
}