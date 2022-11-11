package lv3;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Q6 {
    public static void main(String[] args){
        int[][] triangle = {{7}, {3,8}, {8,1,0}, {2,7,4,4}, {4,5,2,6,5}};
        
        SolutionQ6 solution = new SolutionQ6();
        consoleOut(solution.solution(triangle));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }
}

class SolutionQ6 {
    public int solution(int[][] triangle) {
        for (int i = 0; i < triangle.length - 1; i++) {
            int[] nextNumbers = Arrays.copyOf(triangle[i + 1], triangle[i + 1].length);
            
            for (int k = 0; k < triangle[i].length; k++) {
                if (triangle[i][k] + triangle[i + 1][k] >= nextNumbers[k]) {
                    nextNumbers[k] = triangle[i][k] + triangle[i + 1][k];
                }

                nextNumbers[k + 1] += triangle[i][k];
            }

            triangle[i + 1] = Arrays.copyOf(nextNumbers, nextNumbers.length);
        }
    
        return IntStream.of(triangle[triangle.length - 1]).max().getAsInt();
    }   
}