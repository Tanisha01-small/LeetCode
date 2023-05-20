import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private int V;
    private int E;
    private LinkedList<Integer>[] adj;

    public Graph(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }

    public String toStr() {
        StringBuilder sb = new StringBuilder();
        sb.append(V).append(" ").append(E).append("\n");
        for (int i = 0; i < V; i++) {
            sb.append(i).append(" ");
            for (int j : adj[i]) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void bfs(int s) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.offer(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (int i : adj[u]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int s) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        visited[s] = true;
        stack.push(s);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            System.out.print(u + " ");
            for (int i : adj[u]) {
                if (!visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 0);

        System.out.println(g.toStr());

        System.out.println("BFS:");
        g.bfs(0);

        System.out.println("DFS:");
        g.dfs(0);
    }
}
