import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    int source, dest, weight;

    public Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}

class Node {
    int vertex;
        long weight;

    public Node(int vertex, long weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}


class Graph {

    List<List<Edge>> adjList = null;


    Graph(List<Edge> edges, int N) {
        adjList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            adjList.get(edge.source).add(edge);
        }
    }
}

class Main {


    // Run Dijkstra’s algorithm on a given graph
    public static void findShortestPaths(Graph graph, int source, int N) {
        // create a min-heap and push source node having distance 0
        PriorityQueue<Node> minHeap;
        minHeap = new PriorityQueue<>(
                Comparator.comparing(node -> node.weight));
        minHeap.add(new Node(source, 0));



        long cost[] = new long[N];
        Arrays.fill(cost, Integer.MAX_VALUE);

        cost[source] = 0;

        boolean[] done = new boolean[N];

        while (!minHeap.isEmpty()) {

            Node node = minHeap.poll();
            done[node.vertex] = true;

            int u = node.vertex;

            for (Edge edge : graph.adjList.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;

                // Relaxation step
                if (!done[v] && weight - cost[u] < cost[v]) {

                    long temp = cost[u] + Long.max(0, weight - cost[u]);
                    cost[v] = Long.min(cost[v], temp);
                    minHeap.add(new Node(v, cost[v]));

                }
            }

        }

        String ans = (cost[N - 1] != Integer.MAX_VALUE) ? cost[N - 1] + "" : "NOT POSSIBLE";
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s[]=br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int R = Integer.parseInt(s[1]);

        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            String str[] = br.readLine().split(" ");

            int source = Integer.parseInt(str[0]) - 1;
            int dest = Integer.parseInt(str[1]) - 1;
            int weight = Integer.parseInt(str[2]);
            Edge lr = new Edge(source, dest, weight);
            Edge rl = new Edge(dest, source, weight);
            edgeList.add(lr);
            edgeList.add(rl);
        }


        // construct graph
        Graph graph = new Graph(edgeList, N);
        // Single source shortest- path algorithm
        int source = 0;
        findShortestPaths(graph, source, N);
    }
}
