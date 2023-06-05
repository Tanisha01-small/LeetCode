class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length()==0){
            return false;
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if((board[i][j]==word.charAt(0)) && string(board,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean string(char[][] board,String word, int w,int m,int n){
        if(w==word.length()){
            return true;
        }
        
        //mark visited one to avoid repeat search
        
        if(m<0 || m>=board.length||n<0||n >= board[0].length || word.charAt(w) != board[m][n]){
            return false;
        }
        
        char temp=board[m][n];
        board[m][n]='#';
        
       boolean got=string(board,word, w+1,m+1,n)|| string(board,word, w+1,m-1,n)||string(board,word, w+1,m,n+1)||string(board,word, w+1,m,n-1);
        
        board[m][n]=temp;
        return got;
            
        
    }
}