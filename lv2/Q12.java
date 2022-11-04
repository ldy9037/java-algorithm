package lv2;

import java.util.Stack;

public class Q12 {
    public static void main(String[] args){
        String number = "1924";
        int k = 2;

        SolutionQ12 solution = new SolutionQ12();
        consoleOut(solution.solution(number, k));
    }

    private static void consoleOut(String result) {
        System.out.println(result);
    }
}

class SolutionQ12 {
    public String solution(String number, int k) {

        String[] digits = number.split("");
        Stack<String> stack = new Stack<>();

        for (String digit : digits) {
            stack.push(digit);
            k = removeLessThan(stack, k);
        }

        removeTail(stack, k);
        
        return String.join("", stack);
    }

    private boolean greaterThan(String prevDigit, String currentDigit) {
        return (Integer.parseInt(prevDigit) >= Integer.parseInt(currentDigit));
    }

    private boolean canRemove(Stack<String> stack, String current) {
        return (!stack.empty() && !greaterThan(stack.peek(), current));
    }

    private int removeLessThan(Stack<String> stack, int k) {
        String current = stack.pop(); 

        while (canRemove(stack, current) && k != 0) {
            stack.pop();
            k--;
        }

        stack.push(current);

        return k;
    }

    private Stack<String> removeTail(Stack<String> stack, int k) {
        for (int i = 0; i < k; i++) {
            stack.pop();
        }

        return stack;
    }
}
