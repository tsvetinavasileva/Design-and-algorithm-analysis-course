import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int vertex;
    private ArrayList<List<Integer>> adjacent;


    Graph(int vertex) {
        this.vertex = vertex;
        adjacent = new ArrayList<>(vertex);
        for (int i = 0; i < vertex; i++)
            adjacent.add(new LinkedList<>());
    }

    public void addEdge(int u, int v){
        adjacent.get(u).add(v);
    }

    public void BFS(int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertex];
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");
            for (Integer adj : adjacent.get(cur)) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
    }

    public void util(int cur, boolean visited[]) {
        visited[cur] = true;
        System.out.print(cur + " ");
        for(Integer adj : adjacent.get(cur)) {
            if (!visited[adj]) {
                visited[adj] = true;
                util(adj, visited);
            }
        }
    }

    public void DFS(int start) {
        boolean [] visited = new boolean[vertex];
        util(start, visited);
    }


    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0, 3);
        graph.addEdge(3,4);
        graph.addEdge(3,2);
        graph.addEdge(4, 5);
        graph.BFS(0);
        graph.DFS(0);
    }
}
