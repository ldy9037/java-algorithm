package lv3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.IntStream;

public class Q14 {
    public static void main(String[] args){
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        SolutionQ14 solution = new SolutionQ14();
        consoleOut(solution.solution(n, vertex));
    }

    private static void consoleOut(long result) {
        System.out.println(result); //28
    }
}

class SolutionQ14 {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];

        Map<Integer, List<Integer>> adjacentMap = new HashMap<>();

        distances[0] = 0;
        for (int i = 1; i < n; i++) {
            distances[i] = n;
        }

        for (int i = 1; i < n; i++) {
            visited[i] = false;
        }

        for (int[] e : edge) {
            mapPutWithDefault(adjacentMap, e[0] - 1, e[1] - 1);
            mapPutWithDefault(adjacentMap, e[1] - 1, e[0] - 1);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            
            if (visited[node[0]]) {
                continue;
            }    
            
            visited[node[0]] = true;

            List<Integer> adjacentNodeList = adjacentMap.get(node[0]);
            
            for (int adjacentNode : adjacentNodeList) {
                if (distances[adjacentNode] > node[1] + 1) {
                    distances[adjacentNode] = node[1] + 1;
                }
                
                queue.add(new int[]{adjacentNode, node[1] + 1});
            }
        }

        int maximum = IntStream.of(distances).max().getAsInt();

        for (int distance : distances) {
            if (maximum == distance) {
                answer++;
            }
        }

        return answer;
    }

    private void mapPutWithDefault(Map<Integer, List<Integer>> map, int source, int destination) {
        if (!map.containsKey(source)) {
            map.put(source, new ArrayList<Integer>());
        } 

        map.get(source).add(destination);
    }
}