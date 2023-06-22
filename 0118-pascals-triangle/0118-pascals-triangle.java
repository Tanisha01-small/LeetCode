class Solution {
    public List<List<Integer>> generate(int numRows) {
        /* 
        3 Types of Problems:-
        1- Row and column given print element
        2- print row 
        3- print full Triangle
        
        Problem 1:-
        
        n-1Cr-1(permutation )
        res=1;
        for(int i=0;i<col;i++){
        res=res*(row-i);
        res=res/(i+1);
        }
        
        Problem 2:-
        
        int ans=1;
        for(int i=1;i<row;i++){
        ans=ans*(row-i);
        ans=ans/i;
        sout(ans)
        }
        
        Problem 3:-
        */
        
        
        List<List<Integer>> pascal=new ArrayList<>();
        
        for(int i=1;i<=numRows;i++){
            pascal.add(generateRow(i));
        }
        return pascal;
    }
    
    public List<Integer> generateRow(int row){
        
        long ans=1;
        List<Integer> fin=new ArrayList<>();
        fin.add(1);
        for(int i=1;i<row;i++){
            ans=ans*(row-i);
            ans=ans/i;
            fin.add((int)ans);
        }
        return fin;
    }
}