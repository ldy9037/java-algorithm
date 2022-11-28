package lv1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q8 {
    public static void main(String[] args){
        int k = 3;
        int[] lost = {10, 100, 20, 150, 1, 100, 200};

        SolutionQ8 solution = new SolutionQ8();
        consoleOut(solution.solution(k, lost));
    }

    private static void consoleOut(int[] result) {
        System.out.println(Arrays.toString(result));
    }
}

class SolutionQ8 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            queue.add(score[i]);
            
            while (queue.size() > k) {
                queue.poll();
            }
            
            answer[i] = queue.peek();
        }

        return answer;
    }
}
