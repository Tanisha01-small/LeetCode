class Solution {
    public boolean isPalindrome(String s) {
        int head=0;
        int tail=s.length()-1;
  

        if(s.isEmpty() || s.length()==1){
            return true;
        }

        while(head<tail){
        char chead=s.charAt(head);
        char ctail=s.charAt(tail);
            while(head<tail && !Character.isLetterOrDigit(chead)){
                head++;
                 chead=s.charAt(head);
            }
            while(head<tail && !Character.isLetterOrDigit(ctail)){
                tail--;
                ctail=s.charAt(tail);
            } 
            if(Character.toLowerCase(chead)!=Character.toLowerCase(ctail)){
                return false;
            }
            head++;
            tail--;
        }

        return true;
        
    }
}