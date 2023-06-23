class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int first=0;
//         int first2=0;
//         int index=0;
//         while(first<m && first2<n){
//             if(nums1[first]<nums2[first2]){
//                 nums1[index]=nums1[first];
//                 first++;
//                 index++;
//             } else if(nums1[first]==nums2[first2]){
//                 int temp=nums1[first+1];
//                 nums1[index]=nums1[first];
//                 nums1[index+1]=nums1[first];
//                 nums2[first2]=temp;
//                 first++;
//                 index++;
//             }else{
//                 int temp=nums1[index];
//                 nums1[index]=nums2[first2];
//                 nums2[first2]=temp;
//                 first2++;
//                 index++;
//             }
//         }
        
//          while (first < m) {
//             nums1[index++] = nums1[first++];
//         }

        
//         while (first2 < n) {
//             nums1[index++] = nums2[first2++];
//         }
        
    
        int end=m-1;
        int end2=n-1;
        int k=m+n-1;
        
        while(end2 >=0){
            if(end>=0 && nums1[end]>nums2[end2]){
                nums1[k]=nums1[end];
                end--;
            }else{
                nums1[k]=nums2[end2];
                end2--;
            }
            k--;
        }

    }
}