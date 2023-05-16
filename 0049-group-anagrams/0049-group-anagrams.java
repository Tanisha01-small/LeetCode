class Solution {
    public List<List<String>> groupAnagrams(String[] strs) { 

        //*********WE WILL USE HASHMAP */
        // List<List<String>> arr=new ArrayList<>();
        // int[] freq1=new int[26];
        // for(int i=0;i<strs.length;i++){
        // for(char ch:strs[i].toCharArray()){
        //     freq1[ch-'a']++;
        // }
        // for(int j=i+1;j<strs.length;j++){
        //     for(char ch:strs[j].toCharArray()){
        //         freq1[ch-'a']--;
        //     }
        //     if(freq1.length()==0){
        //         arr.add(Arrays.toString(strs[j]));
        //     }
        //     Arrays.fill(freq1,null);
        // }

        // }

        // return arr;


        HashMap<HashMap<Character,Integer>,List<String>> map=new HashMap<>();

        for(String s:strs){
            HashMap<Character,Integer> freq=new HashMap<>();
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                freq.put(ch,freq.getOrDefault(ch,0)+1);
            }

            if(map.containsKey(freq)==false){
                ArrayList<String> list=new ArrayList<>();
                list.add(s);
                map.put(freq,list);
            }else{
                List<String> list=map.get(freq);
                list.add(s);
            }
        }

        List<List<String>> res=new ArrayList<>();

        for(List<String> val:map.values()){
            res.add(val);
        }

        return res;
    }
}