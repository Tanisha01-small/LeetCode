class Solution {
    public int bestClosingTime(String customers) {
        
        int sum=0;
        int penalty=0;
        int hour=-1;
        for(int i=0;i<customers.length();i++){
              if(customers.charAt(i)=='Y')sum+=1;
            else sum-=1;
            
            if(sum>penalty){
                penalty=sum;
                hour=i;
            }
        }
        
        return hour+1;
    }
}