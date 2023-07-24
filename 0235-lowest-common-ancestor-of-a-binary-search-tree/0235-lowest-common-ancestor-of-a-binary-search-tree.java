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
        // what if we call for left subtree and right subtree and agar value equal nikla for p and q kahi that we basically need to find the root like p and q are connected toh return min of both otherwise we need to find common root betwwen them 
        
        if(root==null || root==p || root==q)return root;
        
        TreeNode left=lowestCommonAncestor(root.left, p, q);
        TreeNode right=lowestCommonAncestor(root.right, p, q);
        
        
        if(left==null)return right;
        else if(right==null)return left;
        else return root;
        
    }
}