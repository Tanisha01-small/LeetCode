/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
// DFS 
class Solution {
    // HashMap<Node,Node> map=new HashMap<>();
    // public Node cloneGraph(Node node) {
    //     if(node==null)return null;
    
        
    //     if(map.containsKey(node)){
    //         return map.get(node);
    //     }
    //     map.put(node,new Node(node.val));
    //     for(Node val:node.neighbors){
    //         map.get(node).neighbors.add(cloneGraph(val));
    //     }
    // return map.get(node);

// BFS 
public Node cloneGraph(Node node){
    if(node==null) return null;

    Node graph=new Node(node.val);
    HashMap<Node,Node> map=new HashMap<>();
    map.put(node,graph);
    Queue<Node> queue=new LinkedList<>();

    queue.offer(node);

    while(!queue.isEmpty()){
        Node cur=queue.poll();
        for(Node val:cur.neighbors){
            if(!map.containsKey(val)){
                map.put(val,new Node(val.val));
                queue.offer(val);
            }
            map.get(cur).neighbors.add(map.get(val));
        }
    }
    return graph;
}

}