/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
       
        int[] path=new int[1];
         path[0]=Integer.MIN_VALUE;
        pathSum(root,path);
        return path[0];
    }
    
    private int pathSum(TreeNode root,int[] path){
        if(root==null){
            return 0;
        }
        
        int left=Math.max(0,pathSum(root.left,path));
        int right=Math.max(0,pathSum(root.right,path));
        path[0]=Math.max(path[0],left+right+root.val);
        return root.val + Math.max(left,right);
    }
}