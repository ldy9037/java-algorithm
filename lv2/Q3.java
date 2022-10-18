package lv2;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class Q3 {
    public static void main(String[] args){
        int[] prices = {1, 2, 3, 2, 3};

        SolutionQ3 solution = new SolutionQ3();
        consoleOut(solution.solution(prices));
    }

    private static void consoleOut(int[] result) {
        System.out.println(Arrays.toString(result));
    }   
}

class SolutionQ3 {
    public int[] solution(int[] prices) {
        int[] answer = IntStream.range(0, prices.length)
                .map(i -> 0)
                .toArray();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                duration(answer, stack.pop(), i);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            duration(answer, stack.pop(), prices.length - 1);
        }

        return answer;
    }

    private void duration(int[] answer, int index, int datum) {
        answer[index] = datum - index;
    }
}