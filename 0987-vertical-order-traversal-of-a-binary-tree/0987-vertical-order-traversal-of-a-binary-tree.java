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
// class Multi{
//     TreeNode node;
//     int hd;
//     int vd;
//     public Multi(TreeNode node,int hd,int vd){
//         this.node=node;
//         this.hd=hd;
//         this.vd=vd;
        
//     }
// }
// class Solution {
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
//         Queue<Multi> q=new LinkedList<Multi>();
//         q.offer(new Multi(root,0,0));
//         while(!q.isEmpty()){
//             Multi temp=q.poll();
//             TreeNode node=temp.node;
//             int x=temp.hd;
//             int y=temp.hd;
            
//             if(!map.containsKey(x)){
//                 map.put(x,new TreeMap<>());
//             }
//             if(!map.get(x).containsKey(y)){
//                 map.get(x).put(y,new PriorityQueue<>());
//             }
            
//             map.get(x).get(y).offer(node.val);
            
//             if(node.left!=null){
//                 q.offer(new Multi(node.left,x-1,y+1));
//             }
            
//              if(node.right!=null){
//                 q.offer(new Multi(node.right,x+1,y+1));
//             }
//         }
        
//         List<List<Integer>> list=new ArrayList<>();
        
//         for(TreeMap<Integer,PriorityQueue<Integer>> small:map.values()){
//             list.add(new ArrayList<>());
//             for(PriorityQueue<Integer> queue:small.values()){
//                 while(!queue.isEmpty()){
//                     list.get(list.size()-1).add(queue.poll());
//                 }
//             }
//         }
        
//         return list;
//     }
// }

class Solution {
    class Tuple{
        TreeNode node;
        int row;
        int col;
        public Tuple(TreeNode _node,int _row,int _col){
            node=_node;
            row=_row;
            col=_col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map =new TreeMap<>();
        Queue<Tuple> que=new LinkedList<Tuple>();
        que.offer(new Tuple(root,0,0));
        while(!que.isEmpty()){
            Tuple tuple=que.poll();
            TreeNode node=tuple.node;
            int x=tuple.row;
            int y=tuple.col;
            //- If Map does not conatian the map, then create one
            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);

            if(node.left != null){
                que.offer(new Tuple(node.left, x-1, y+1));
            }
            if(node.right != null){
                que.offer(new Tuple(node.right ,x+1 , y+1));
            }
        }
        List<List<Integer>> list=new ArrayList<>();
        for(TreeMap<Integer , PriorityQueue<Integer>> ys: map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer>nodes: ys.values()){
                while(!nodes.isEmpty()){
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;
    }
}