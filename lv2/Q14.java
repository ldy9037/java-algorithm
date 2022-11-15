package lv2;

import java.util.Arrays;

public class Q14 {
    public static void main(String[] args){
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        SolutionQ14 solution = new SolutionQ14();
        consoleOut(solution.solution(numbers, target));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }
}

class SolutionQ14 {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        int current = numbers[numbers.length - 1];

        if (numbers.length == 1) {
            if (target + current == 0 || target - current == 0) {
                answer ++;    
            }
            
            return answer;
        }

        answer += solution(Arrays.copyOf(numbers, numbers.length - 1), target + current);
        answer += solution(Arrays.copyOf(numbers, numbers.length - 1), target - current);       

        return answer;
    }
}
