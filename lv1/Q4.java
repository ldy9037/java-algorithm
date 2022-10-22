package lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q4 {
    public static void main(String[] args){
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        SolutionQ4 solution = new SolutionQ4();
        consoleOut(solution.solution(array, commands));
    }

    private static void consoleOut(int[] result) {
        System.out.println(Arrays.toString(result));
    }   
}

class SolutionQ4 {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();

        for (int[] command : commands) {
            int[] sliced = Arrays.copyOfRange(array, command[0] - 1, command[1]); 
            Arrays.sort(sliced);
            
            answer.add(sliced[command[2] - 1]);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}