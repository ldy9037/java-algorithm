package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Q2 {
    public static void main(String[] args){
        int bridge_length = 5;
        int weight = 5;
        int[] truck_weights = {2,2,2,2,1,1,1,1,1};

        SolutionQ2 solution = new SolutionQ2();
        consoleOut(solution.solution(bridge_length, weight, truck_weights));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }   
}


class SolutionQ2 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> time = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            answer++;
            while (totalWeight(bridge) + truck_weights[i] > weight || (!time.isEmpty() && time.peek() == answer)) {
                bridge.poll();    
                answer = time.poll();
            }
            
            bridge.offer(truck_weights[i]);
            time.offer(bridge_length + answer);
        }

        return bridge_length + answer;
    }

    private int totalWeight(Queue<Integer> bridge) {
        return bridge.stream()
                .mapToInt(i -> i)
                .sum();
    }
}