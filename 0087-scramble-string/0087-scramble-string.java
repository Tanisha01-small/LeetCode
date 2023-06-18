class Solution {
    public static HashMap<String,Boolean> map;
    public boolean isScramble(String s1, String s2) {
         map=new HashMap<>();
        if(s1.length()!=s2.length()){
            return false;
        }
        if(s1.length()==0 && s2.length()==0){
            return true;
        }
        
        return solve(s1,s2);
    }
    
    static boolean solve(String s1,String s2){
        if(s1.compareTo(s2)==0){
            return true;
        }
        
        if(s1.length()<=1){
            return false;
        }
        int n=s1.length();
        String key=s1+" "+s2;
        if(map.containsKey(key)) return map.get(key);
        boolean flag=false;
        
        for(int i=1;i<=n-1;i++){
            if((solve(s1.substring(0,i),s2.substring(n-i,n))==true && solve(s1.substring(i,n),s2.substring(0,n-i))==true)||(solve(s1.substring(0,i),s2.substring(0,i))==true && solve(s1.substring(i,n),s2.substring(i,n))==true)){
                flag=true;
                break;
            }
        }
        map.put(key,flag);
        return flag;
        
    } 
}
