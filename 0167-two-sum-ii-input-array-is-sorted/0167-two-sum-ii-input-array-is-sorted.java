class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer>  map=new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            int temp=numbers[i];
            int diff=target-temp;
            if(map.containsKey(diff)){
                return new int[]{map.get(diff)+1,i+1};
            }
            map.put(temp,i);   
        }
        return new int[] {};
        
    }
}