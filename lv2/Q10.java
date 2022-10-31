package lv2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Q10 {
    public static void main(String[] args){
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        SolutionQ10 solution = new SolutionQ10();
        consoleOut(solution.solution(n, wires));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }
}

class SolutionQ10 {
    List<Integer> nodeCount = new LinkedList<>();

    public int solution(int n, int[][] wires) {
        List<Edge> edges = new LinkedList<>();

        for (int[] wire : wires) {
            edges.add(new Edge(wire[0], wire[1]));
        }

        int totalCount = dfs(1, edges);
        nodeCount.remove(0);
        
        return minDifference(totalCount);
    }

    public int dfs(int source, List<Edge> edges) {
        int result = 1;

        List<Integer> destinations = findNextNodes(source, edges);

        for (int destination : destinations) {
            result += dfs(destination, edges);
        }

        nodeCount.add(result);

        return result;
    }

    private List<Integer> findNextNodes(int source, List<Edge> edges) {
        List<Integer> result = new ArrayList<>();
        Iterator<Edge> iterator = edges.iterator();

        while (iterator.hasNext()) {
            Edge edge = iterator.next();
            
            if (edge.canGo(source)) { 
                result.add(edge.getDestination(source));
                iterator.remove();
            }
        }

        return result;
    }

    private int minDifference(int totalCount) {
        return nodeCount.stream()
                .mapToInt(i -> difference(totalCount, i))
                .min()
                .getAsInt();
    }

    private int difference(int totalCount, int childCount) {
        return Math.abs((totalCount - childCount) - childCount);
    }
}

class Edge {
    private final int source;
    private final int destination;

    Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    public boolean canGo(int source) {
        return (this.source == source || this.destination == source);
    }

    public int getDestination(int source) {
        return (this.source == source) ? this.destination : this.source;
    }
}