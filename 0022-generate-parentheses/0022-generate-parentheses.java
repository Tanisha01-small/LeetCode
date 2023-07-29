class Solution {
    public List<String> generateParenthesis(int n) {
        // choices +decisions give rise to recursion
        List<String> list=new ArrayList<>();
        int close=n;
        int open=n;
        
        String op="";
        
        rec(op,open,close,list);
        
        return list;
    }
    
   public void rec(String op, int open ,int close, List<String> list){
       if(open ==0 && close ==0){
           list.add(op);
           return ;
       }
       
       if(open !=0){
           String op1=op + "(";
           rec(op1,open-1,close,list);
       }
       
       if(close>open){
           String op2=op+")";
           rec(op2,open,close-1,list);
       }
   }
}