package lv1;

import java.util.Arrays;
import java.util.Stack;

public class Q2 {
    public static void main(String[] args){
        int[] input = {1,1,3,3,0,1,1};

        SolutionQ2 solution = new SolutionQ2();
        consoleOut(solution.solution(input));
    }

    private static void consoleOut(int[] result) {
        System.out.println(Arrays.toString(result));
    }
}

class SolutionQ2 {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Stack<Integer> stack = new Stack<>();
        
        for (int element : arr) {
            push(stack, element);
        }

        answer = stack.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        
        return answer;
    }

    private void push(Stack<Integer> stack, int element) {
        if (canPush(stack, element)) {
            stack.push(element);
        }
    }

    private boolean canPush(Stack<Integer> stack, int element) {
        return (stack.empty() || stack.peek() != element);
    }
}