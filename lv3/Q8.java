package lv3;

public class Q8 {
    public static void main(String[] args){
        int n = 3;
        int[][] computers = {{1,1,0}, {1,1,1}, {0,1,1}};

        SolutionQ8 solution = new SolutionQ8();
        consoleOut(solution.solution(n, computers));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }
}

class SolutionQ8 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visitedArr = new boolean[n];

        for (int i = 0; i < visitedArr.length; i++) {
            visitedArr[i] = false;
        }

        for (int i = 0; i < n; i++) {
            if (!visitedArr[i]) {
                dfs(visitedArr, computers, i);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(boolean[] visitedArr, int[][] computers, int current) {
        visitedArr[current] = true;
        
        for (int i = 0; i < computers.length; i++) {
            if (computers[current][i] == 1 && !visitedArr[i]) {
                dfs(visitedArr, computers, i);
            } 
        }
    }
}

