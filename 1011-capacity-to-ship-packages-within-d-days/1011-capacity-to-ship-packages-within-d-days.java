class Solution {
    public int shipWithinDays(int[] weights, int days) {
       // Arrays.sort(weights);
        int n=weights.length;
        int start=weights[0];
        int end=0;
        int result=-1;
        for(int i=0;i<n;i++){
            end+=weights[i];
            if(start<weights[i]){
                start=weights[i];
            }
        }
        
        while(start<=end){
            int mid=start+((end-start)/2);
            
            if(isValid(weights,days,n,mid)==true){
                result=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return result;
    }
    
    public boolean isValid(int[] arr,int days,int n,int max){
        int d=1;
        int sum=0;
        
        for(int i=0;i<n;i++){
            sum +=arr[i];
            if(sum>max){
                d++;
                sum =arr[i];
            }
             if(d>days){
            return false;
          }
            
        }
        
            return true;
    }
    
}