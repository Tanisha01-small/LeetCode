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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> list=new ArrayList<>();
        boolean flag=true; // 0 means L-R
                    // 1 means R-L
        q.add(root);
        
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> last=new ArrayList<>();
            
                for(int i=0;i<n;i++){
                    if(q.peek().left!=null)q.add(q.peek().left);
                    if(q.peek().right!=null)q.add(q.peek().right);
                    if(flag==true)last.add(q.poll().val);
                    else if(flag==false)last.add(0,q.poll().val);
                }
            
            flag=!flag;
            list.add(last);
        }
        
        return list;
    }
}