class Solution {
    public int fib(int n) {
       int f0=0;
       int f1=1;
       if(n==0 || n==1){
           return n  ;
       }
       return fib(n-1) + fib(n-2);
    }
}