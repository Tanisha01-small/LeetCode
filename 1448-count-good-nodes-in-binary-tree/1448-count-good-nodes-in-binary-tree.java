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
     
    public int goodNodes(TreeNode root) {
      return good(root,Integer.MIN_VALUE);
    }
    
    public int good(TreeNode node, int min){
        if(node==null)return 0;
        
        int count=0;
        if(node.val>=min){
            count+=1;
            min=node.val;
        }
        
        count+=good(node.left,min);
        count+=good(node.right,min);
        
        return count;
    }
}