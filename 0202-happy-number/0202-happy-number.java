class Solution {
    public boolean isHappy(int n) {
        // linked list cycle problem
        int slow=n;
        int fast=n;
        
        do{
            slow=find(slow);
            fast=find(find(fast));
        }while(slow!=fast);
            
        if(fast==1){
            return true;
        }
        
        return false;
        
    }
    
    public int find(int n){
        int res=0;
        while(n>0){
            int rem=(n%10);
            res+=rem*rem;
            n=n/10;
        }
        return res;
    }
}