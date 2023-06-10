// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         // we need to choose numers that make upto target from candidates and we can choose any number unlimited times and theres should not be repetations of list within list, soo first we need list
        
//         List<List<Integer>> comb=new ArrayList<>();
//         findcomb(candidates,comb,new ArrayList<>(),target,0);      
//         return comb;
//     }
    
//     private void findcomb(int[] arr,List<List<Integer>> comb,List<Integer> ans, int target,int i){
//         if(arr.length==i){
//             return;
//         }
        
//         if(arr[i]<target){
//             ans.add(arr[i]);
//             findcomb(arr,comb,ans,target-arr[i],i);
            
//         }
//     }
// }

class Solution {

    private void findComb(int i, int target, int [] arr, List<Integer> ds,List<List<Integer>> ans){
        if(i==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[i]<=target){
            ds.add(arr[i]);
            findComb(i,target-arr[i],arr,ds,ans);
            ds.remove(ds.size()-1);
        }
        findComb(i+1,target,arr,ds,ans);
        }




    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans=new ArrayList<>();
        findComb(0,target,candidates,new ArrayList<>(), ans);

        return ans;

        
    }
}