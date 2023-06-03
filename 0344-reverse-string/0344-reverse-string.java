class Solution {
    public void reverseString(char[] s) {
      int st=0;
      int l=s.length-1;
       while(l>st){
            swap(s, st, l);
            st++;
            l--;
        }
    } 
    
    public void swap(char[] s,int st,int l){
        char temp=s[st];
        s[st]=s[l];
        s[l]=temp;
    }
}