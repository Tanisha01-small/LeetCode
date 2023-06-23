class Solution {
    public void rotate(int[][] matrix) {
        //int col=matrix[0][0];
        //matrix[0][0]=matrix[matrix.length-1][0];
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){ 
                int arr=0;
                arr=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=arr;
            }
        }
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length/2;j++){
                int temp=0;
                temp=matrix[i][j];
                matrix[i][j]=matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j]=temp;
            }
        }
    }
}