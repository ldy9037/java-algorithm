package lv3;

public class Q15 {
    public static void main(String[] args){
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        SolutionQ15 solution = new SolutionQ15();
        consoleOut(solution.solution(n, results));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }
}

class SolutionQ15 {
    public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] table = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                table[i][k] = 0;
            }
        }

        for (int[] result : results) {
            table[result[0] - 1][result[1] - 1] = 1;
            table[result[1] - 1][result[0] - 1] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    if (table[i][j] == 1 && table[j][k] == 1) {
                        table[i][k] = 1;
                        table[k][i] = -1;
                    }
                }
            } 
        }

        for (int[] row : table) {
            int zeroCount = 0;
            
            for (int col : row) {
                if (col == 0) {
                    zeroCount++;
                }
            }

            if (zeroCount == 1) {
                answer++;
            }
        }

        return answer;
    }
}
