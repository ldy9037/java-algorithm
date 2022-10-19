package lv2;

import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q4 {
    public static void main(String[] args){
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        SolutionQ4 solution = new SolutionQ4();
        consoleOut(solution.solution(scoville, K));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }
}

class SolutionQ4 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>(
                IntStream.of(scoville)
                        .boxed()
                        .collect(Collectors.toList()));

        while (heap.peek() < K) {
            if (heap.size() < 2) {
                return -1;
            }

            heap.add(mix(heap.poll(), heap.poll()));
            answer++;    
        }

        return answer;
    }

    private int mix(int leastSpicy, int secondLessSpicy) {
        return leastSpicy + (secondLessSpicy * 2);
    }
}