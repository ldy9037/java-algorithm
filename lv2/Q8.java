
package lv2;

import java.util.Arrays;

public class Q8 {
    public static void main(String[] args){
        int brown = 10;
        int yellow = 2;

        SolutionQ8 solution = new SolutionQ8();
        consoleOut(solution.solution(brown, yellow));
    }

    private static void consoleOut(int[] result) {
        System.out.println(Arrays.toString(result));
    }
}

class SolutionQ8 {
    public int[] solution(int brown, int yellow) {
        int[] answer = calculateYellowWidthAndHeight(brown, yellow);

        addVertex(answer);

        return answer;
    }

    private int[] calculateYellowWidthAndHeight(int brown, int yellow) {
        int[] result = {yellowWidthAndHeightSum(brown), 0};

        while (!isCorrectWidthAndHeight(result[0], result[1], yellow)) {
            result[0]--;
            result[1]++;
        }

        return result;
    }

    private boolean isCorrectWidthAndHeight(int width, int height, int yellow) {
        return (width * height == yellow);
    }

    private int yellowWidthAndHeightSum(int brown) {
        brown = removeVertex(brown);
        return brown / 2;
    }

    private int removeVertex(int brown) {
        return brown - 4;
    }

    private void addVertex(int[] widthAndHeight) {
        widthAndHeight[0] += 2;
        widthAndHeight[1] += 2;
    }
}