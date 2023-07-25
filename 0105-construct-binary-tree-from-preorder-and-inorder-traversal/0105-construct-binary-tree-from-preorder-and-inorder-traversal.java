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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || preorder.length!=inorder.length)return null;
        
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
    
    public TreeNode build(int[] preorder,int ps,int pe,int[] inorder,int is,int ie,Map<Integer,Integer> map){
        if(ps>pe || is>ie)return null;
        
        int root=preorder[ps];
        
        TreeNode node=new TreeNode(root);
        int interval=map.get(root);
        int numsLeft=interval-is;
        node.left=build(preorder,ps+1,ps+numsLeft,inorder,is,interval-1,map);
        node.right=build(preorder,ps+numsLeft+1,pe,inorder,interval+1,ie,map);
        
        return node;
    }
}