package lv1;

import java.util.Stack;

public class Q3 {
    public static void main(String[] args){
        String input = ")()(";

        SolutionQ3Sub solution = new SolutionQ3Sub();
        consoleOut(solution.solution(input));
    }

    private static void consoleOut(boolean result) {
        System.out.println(result);
    }    
}

class SolutionQ3 {
    private final static char closeBracket = ')';

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char bracket : s.toCharArray()) {
            check(stack, bracket);
        }

        return stack.isEmpty();
    }

    private void check(Stack<Character> stack, char bracket) {
        if (!stack.isEmpty() && isCloseBracket(bracket)) {
            stack.pop();
            return ;
        }

        stack.push(bracket);
    }

    private boolean isCloseBracket(char bracket) {
        return (bracket == closeBracket);
    }
}

class SolutionQ3Sub {
    private final static String Bracket = "()";

    boolean solution(String s) {
        while (s.contains(Bracket)) {
            s = s.replace(Bracket, "");
        }

        return s.isEmpty();
    }
}

