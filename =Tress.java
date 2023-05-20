// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class BinaryTree{
    private TreeNode root;
    
    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;
        
        public TreeNode(int data){
            this.data=data;
        }
    }
    
    public void createTree(){
        TreeNode first=new TreeNode(1);
        TreeNode second=new TreeNode(2);
        TreeNode third=new TreeNode(3);
        TreeNode fourth=new TreeNode(4);
        TreeNode fivth=new TreeNode(5);
        
        root=first;
        root.left=second;
        root.right=third;
        second.left= fourth;
        second.right=fivth;
    }
    
    //preorder traversal 
    
    public void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public static void main(String[] args){
        BinaryTree tree=new BinaryTree();
        tree.createTree();
        tree.preOrder(tree.root);
    }
}