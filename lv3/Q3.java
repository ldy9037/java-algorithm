package lv3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Q3 {
    public static void main(String[] args){
        int n = 3;
        int[][] costs = {{0,2,1},{1,2,2},{0,1,3}};

        SolutionQ3 solution = new SolutionQ3();
        consoleOut(solution.solution(n, costs));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }
}

class SolutionQ3 {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parents = IntStream.range(0, n).toArray();

        List<Edge> edges = new ArrayList<>();

        for (int[] cost : costs) {
            edges.add(new Edge(cost[0], cost[1], cost[2]));
        }

        Collections.sort(edges);  

        for (Edge edge : edges) {
            int sourceParent = findParent(parents, edge.getSource());
            int destinationParent = findParent(parents, edge.getDestination());
            
            if (sourceParent != destinationParent) {
                answer += edge.getCost();

                if (sourceParent > destinationParent) {
                    parents[destinationParent] = sourceParent;
                    continue;
                }
                
                parents[sourceParent] = destinationParent;
            }
        }

        return answer;
    }

    private int findParent(int[] parents, int node) {
        int result = node;
        
        if (parents[node] == node) {
            return result;
        }
        
        result = findParent(parents, parents[node]);

        return result;
    }
}

class Edge implements Comparable<Edge> {
    private int source;
    private int destination;
    private int cost;

    Edge(int source, int destination, int cost) {        
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Edge o) {
        return cost - o.cost;
    }
}