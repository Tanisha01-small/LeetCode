class Solution {
    public List<List<String>> partition(String s) {
        // We need to see where we need to do partitioning soo we need to check the start and till end is that partition palindrome or not
        List<List<String>> ans=new ArrayList<>();
        List<String> list=new ArrayList<>();
        func(0,s,ans,list);
        return ans;
    }
    
    void func(int index,String s,List<List<String>> ans,List<String> list){
        if(index==s.length()){
            ans.add(new ArrayList<>(list));
            return ;
        }
        
        for(int i=index;i<s.length();i++){
            if(pal(s,index,i)){
                list.add(s.substring(index,i+1));
                func(i+1,s,ans,list);
                list.remove(list.size()-1);
            }
        }
        
    }
    
    boolean pal(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}