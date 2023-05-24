class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start=0;
        int end=letters.length-1;
        char r='#';
        while(start<=end){
            int mid=start+((end-start)/2);
    
            if(letters[mid]<=target){
                start=mid+1;
            }else if(letters[mid]>=target){
                r=letters[mid];
                end=mid-1;
            }
            
            if(r=='#'){
                r=letters[0];
            }
        }
        return r;
    }
}

