package lv2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q1 {
    public static void main(String[] args){
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        SolutionQ1 solution = new SolutionQ1();
        consoleOut(solution.solution(priorities, location));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }   
}

class SolutionQ1 {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue = generateQueue(priorities.length);
         
        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (priorities[current] < findMax(queue, priorities)) {
                queue.offer(current);
                continue;
            }
            
            answer++;

            if (current == location) {
                break;
            }
        } 

        return answer;
    }

    private int findMax(Queue<Integer> queue, int[] priorities) {
        return queue.stream().map(i -> priorities[i]).max(Integer::compare).orElse(-1);
    }

    private Queue<Integer> generateQueue(int size) {
        List<Integer> list = IntStream.range(0, size)
                .boxed()
                .collect(Collectors.toList());
        
        return new LinkedList<>(list);
    }
}
