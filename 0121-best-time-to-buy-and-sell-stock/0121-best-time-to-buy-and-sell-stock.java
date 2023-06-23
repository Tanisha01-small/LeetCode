class Solution {
    public int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int overallprofit = 0;
        int profitifsoldtoday= 0;
        
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < lsf){
                lsf = prices[i];
            }
            profitifsoldtoday = prices[i] - lsf;
            if(overallprofit < profitifsoldtoday){
                overallprofit = profitifsoldtoday;
            }
        }
        return overallprofit;
    }
}