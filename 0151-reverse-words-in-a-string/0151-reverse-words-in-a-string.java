class Solution {
    public String reverseWords(String s) {
        String[] ans=s.trim().split("\\s+");
        String fin="";
        for(int i=ans.length-1;i>0;i--){
            fin+=ans[i]+" ";
        }
        return fin + ans[0];
    }
}


