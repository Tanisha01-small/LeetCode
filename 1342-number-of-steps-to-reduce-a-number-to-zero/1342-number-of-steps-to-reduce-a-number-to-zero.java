class Solution {
    public int numberOfSteps(int num) {
        int count =0;
        if(num==0) return 0;
        if(num%2==0){
            count ++;
           count += numberOfSteps(num/2);  
        }else{
            count ++;
            count +=numberOfSteps(num-1) ;    
        }
        return count;
    }
}