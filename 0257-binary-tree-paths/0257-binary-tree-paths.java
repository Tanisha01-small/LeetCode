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
    public List<String> binaryTreePaths(TreeNode root) {
        String s="";
        List<String> ans=new ArrayList<>();
        if(root==null)return new ArrayList<>();
        path(root,ans,s);
        return ans;
    }
    
    public void path(TreeNode root,List<String> ans,String s){
        if(root==null)return;
        
        
        if(root.left==null && root.right==null){
            s+=Integer.toString(root.val);
            ans.add(s);
            s="";
        }
         
        path(root.left,ans,s+Integer.toString(root.val)+"->");
        path(root.right,ans,s+Integer.toString(root.val)+"->");
    }
}