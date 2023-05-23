class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int area=0;
        for(int i=0;i<height.length;i++){
            int curarea=(right-left)* (Math.min(height[right],height[left]));
            area=Math.max(area,curarea);
            if(height[left]<height[right]){
                left++;
            }else if(height[left]>height[right]){
                right--;
            }else{
                right--;
                left++;
            }
          
        }
        return area;
        
    }
}