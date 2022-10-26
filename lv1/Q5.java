package lv1;

import java.util.stream.Stream;

public class Q5 {
    public static void main(String[] args){
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        SolutionQ5 solution = new SolutionQ5();
        consoleOut(solution.solution(sizes));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }
}

class SolutionQ5 {
    public int solution(int[][] sizes) {
        return width(sizes) * height(sizes);
    }

    private int width(int[][] sizes) {
        return Stream.of(sizes)
                .mapToInt(i -> Math.max(i[0], i[1]))
                .max()
                .getAsInt();
    }

    private int height(int[][] sizes) {
        return Stream.of(sizes)
                .mapToInt(i -> Math.min(i[0], i[1]))
                .max()
                .getAsInt();
    }
}