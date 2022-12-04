package lv2;

public class Q17 {
    public static void main(String[] args){
        int k = 2;
        int d = 4;

        SolutionQ17 solution = new SolutionQ17();
        consoleOut(solution.solution(k, d));
    }

    private static void consoleOut(long result) {
        System.out.println(result);
    }
}

class SolutionQ17 {
    public long solution(int k, int d) {
        long answer = 0;

        for (int i = 0; i * k <= d; i++) {
            int y = otherLocation(d, i * k);
            
            answer += y / k + 1;
        }

        return answer;
    }

    private int otherLocation(int d, int x) {
        return (int) Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2));
    }
}