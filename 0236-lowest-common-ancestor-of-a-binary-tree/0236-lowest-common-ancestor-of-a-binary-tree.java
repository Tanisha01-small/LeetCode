/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
//         ArrayList<TreeNode> list1=new ArrayList<>();
//         ArrayList<TreeNode> list2=new ArrayList<>();
        
//         path(root,p,list1);
//         path(root,q,list2);
        
//         list1.retainAll(list2);
//         TreeNode ans=list1.get(list1.size()-1);
//         return ans;
        
        if(root==null || root==p|| root==q)return root;
        
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        
        if(left==null)return right;
        else if(right==null)return left;
        else return root;
    }
    
//     public boolean path(TreeNode root, TreeNode x,ArrayList<TreeNode> list){
//         if(root==null)return false ;
        
//         list.add(root);
//         if(root.val==x.val)return true ;
        
//         if(path(root.left,x,list) || path(root.right,x,list)){
//             return true; 
//         }
        
//         list.remove(list.size()-1);
        
//         return false;
        
//     }
}