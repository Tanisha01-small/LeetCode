class Solution {

    void findComb(int target, int[] arr, int ind, List<Integer> ds, List<List<Integer>> ans){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i]==arr[i-1]){
                continue;
            }
            if(arr[i]>target){
                break;
             }
            ds.add(arr[i]);
            findComb(target-arr[i],arr,i+1,ds,ans);
            ds.remove(ds.size()-1);

        }
 
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(candidates);
        findComb(target,candidates,0,new ArrayList<>(),ans);
        return ans;
    }
}

// class Solution { 
// void comb(int ind, int[]arr, int tar, List<Integer> al, List<List<Integer>> res){
//     if(tar==0){
//         res.add(new ArrayList<>(al));
//         return;
//     }
    
//     for(int i=ind; i<arr.length; i++){
//         if(i>ind && arr[i]==arr[i-1]){
//             continue;
//         }
        
//         if(arr[i]>tar){
//             break;
//         }
        
//         al.add(arr[i]);
//         comb(i+1, arr, tar-arr[i], al, res);
//         al.remove(al.size()-1);
//     }
// }

// public List<List<Integer>> combinationSum2(int[] arr, int target) {
//     List<List<Integer>> res = new ArrayList<>();
//     List<Integer> al = new ArrayList<>();
    
//     Arrays.sort(arr);
    
//     comb(0, arr, target, al, res);
    
//     return res;
// }
// }