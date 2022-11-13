package lv4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q1 {
    public static void main(String[] args){
        String[] arr = {"1", "-", "3", "+", "5", "-", "8"};

        SolutionQ1 solution = new SolutionQ1();
        consoleOut(solution.solution(arr));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }   
}

class SolutionQ1 {
    public int solution(String arr[]) {
        int max = 0;
        int min = 0;
        Stack<Integer> plus = new Stack<>();
        List<Integer> numbers = new ArrayList<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].equals("-")) {
                int currentNumber = plus.pop();
                numbers.add(-currentNumber + sum(plus) + max);
                numbers.add(-(currentNumber + sum(plus) + max));
                numbers.add(-(currentNumber + sum(plus)) + min);
                numbers.add(-(currentNumber + sum(plus) + min)); 

                min = numbers.stream()
                        .mapToInt(n -> n)
                        .min()
                        .getAsInt();
                max = numbers.stream()
                        .mapToInt(n -> n)
                        .max()
                        .getAsInt();

                numbers.clear();
                plus.clear();
                continue;
            }

            if (arr[i].equals("+")) {
                continue;
            }

            plus.add(Integer.parseInt(arr[i]));
        }

        return max + sum(plus);
    }

    private int sum(List<Integer> list) {
        return list.stream()
                .mapToInt(i -> i)
                .sum();
    }
}
