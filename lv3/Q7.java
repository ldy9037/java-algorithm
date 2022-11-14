package lv3;

public class Q7 {
    public static void main(String[] args){
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};
        
        SolutionQ7 solution = new SolutionQ7();
        consoleOut(solution.solution(m, n, puddles));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }
}

class SolutionQ7 {
    public int solution(int m, int n, int[][] puddlesArr) {
        int answer = 0;
        int[][] map = new int[m][n];

        for (int[] puddles: puddlesArr) {
            map[puddles[0] - 1][puddles[1] - 1] = -1;
        }

        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (i == 0 && k == 0) {
                    map[i][k] = 1;
                    continue;
                }

                if (map[i][k] == -1) {
                    continue;
                }

                if (i == 0) {
                    map[i][k] = map[i][k - 1];
                    continue;
                }

                if (k == 0) {
                    map[i][k] = map[i - 1][k];
                    continue;
                }

                int sum = -1;
                if (map[i - 1][k] != -1 || map[i][k - 1] != -1) {
                    sum = 0;
                    
                    if (map[i - 1][k] != -1) {
                        sum += map[i - 1][k];
                    }

                    if (map[i][k - 1] != -1) {
                        sum += map[i][k - 1];
                    }
                }

                map[i][k] = sum % 1000000007;
            }
        }


        if (map[m - 1][n - 1] != -1) {
            answer = map[m - 1][n - 1];
        }

        return answer;
    }
}