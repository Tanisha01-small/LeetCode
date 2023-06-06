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
    public int diameterOfBinaryTree(TreeNode root) {
        // we need to find the height excep the only condition is that you have to change root node to get the max
        if(root==null)return 0;
        int op1=diameterOfBinaryTree(root.left);
        int op2=diameterOfBinaryTree(root.right);
        
        int op3=height(root.left)+height(root.right);
        
        return Math.max(op1,Math.max(op2,op3));
       
    }
    
    private int height(TreeNode root){
        if(root==null)return 0;
        
        int left=height(root.left);
        left++;
        int right=height(root.right);
        right++;
        
        return Math.max(left,right);
    }
}