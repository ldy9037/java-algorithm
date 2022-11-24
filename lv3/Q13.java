package lv3;

public class Q13 {
    public static void main(String[] args){
        int n = 6;
        int[] times = {7, 11};

        SolutionQ13 solution = new SolutionQ13();
        consoleOut(solution.solution(n, times));
    }

    private static void consoleOut(long result) {
        System.out.println(result); //28
    }
}

class SolutionQ13 {
    public long solution(int n, int[] times) {
        long left = 0L;
        long right = 1000000000L * 1000000000L;

        while (left < right) {
            long middle = (left + right) / 2;

            long customer = 0L;
            for (int time : times) {
                customer += middle / time;
            }

            if (customer >= n) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }
}