package lv3;

import java.util.Arrays;
import java.util.Comparator;

public class Q4 {
    public static void main(String[] args){
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};

        SolutionQ4 solution = new SolutionQ4();
        consoleOut(solution.solution(routes));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }
}

class SolutionQ4 {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        int cameraPoint = 30001;

        for (int[] route : routes) {
            if (cameraPoint > route[1]) {
                answer++;
                cameraPoint = route[0];
            }

            if (cameraPoint < route[0]) {
                cameraPoint = route[0];
            }
        }

        return answer;
    }
}