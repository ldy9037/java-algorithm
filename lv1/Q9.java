package lv1;

public class Q9 {
    public static void main(String[] args){
        String s = "banana";

        SolutionQ9 solution = new SolutionQ9();
        consoleOut(solution.solution(s));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }
}

class SolutionQ9 {
    public int solution(String s) {
        int answer = 0;

        int[] count = {0,0};
        Character start = null;

        for (Character c : s.toCharArray()) {
            if (start == null) {
                start = c;
            }

            if (c.equals(start)) {
                count[0]++;
            } else {
                count[1]++;
            }            

            if (count[0] == count[1]) {
                answer++;
                count[0] = 0;
                count[1] = 0;

                start = null;
            }
        }

        if (start != null) {
            answer++;
        }

        return answer;
    }
}
