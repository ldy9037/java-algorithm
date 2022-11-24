package lv4;

import java.util.Arrays;

public class Q2 {
    public static void main(String[] args){
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;

        SolutionQ2 solution = new SolutionQ2();
        consoleOut(solution.solution(distance, rocks, n));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }   
}

class SolutionQ2 {
    public int solution(int distance, int[] rocks, int n) {
        int left = 1;
        int right = distance;

        Arrays.sort(rocks);

        while (left < right) {
            int middle = ((left + right) / 2) + 1;
            
            int removed = 0;
            int start = 0;
            for (int rock : rocks) {
                if (rock - start < middle) {
                    removed++;
                    continue;
                }

                start = rock;
            }

            if (removed > n) {
                right = middle - 1;
            } else {
                left = middle;
            }
        }   

        return left;
    }
}
