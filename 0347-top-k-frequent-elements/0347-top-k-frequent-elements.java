class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Count the frequency of each element
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        
        // Sort the list based on the frequency in descending order
        entryList.sort((a, b) -> b.getValue() - a.getValue());
        
        
        for (int i = 0; i < k; i++) {
            ans[i] = entryList.get(i).getKey();
        }
        
        return ans;
    }
}