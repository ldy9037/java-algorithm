package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Q15 {
    public static void main(String[] args){
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        SolutionQ15 solution = new SolutionQ15();
        consoleOut(solution.solution(maps));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }
}

class SolutionQ15 {
    public int solution(int[][] maps) {
        int answer = -1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        maps[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == maps.length - 1 && current[1] == maps[0].length - 1) {
                answer = current[2];
                break;
            }

            addNext(maps, queue, new int[]{current[0] - 1, current[1], current[2] + 1});
            addNext(maps, queue, new int[]{current[0], current[1] - 1, current[2] + 1});
            addNext(maps, queue, new int[]{current[0] + 1, current[1], current[2] + 1});
            addNext(maps, queue, new int[]{current[0], current[1] + 1, current[2] + 1});
        }

        return answer;
    }

    private void addNext(int[][] maps, Queue<int[]> queue, int[] coordinate) {
        if (canGo(maps, coordinate[0], coordinate[1])) {
            queue.add(coordinate);
            maps[coordinate[0]][coordinate[1]] = 0;
        }
    }

    private boolean canGo(int[][] maps, int row, int col) {
        return (validRange(maps, row, col) && maps[row][col] == 1);
    }

    private boolean validRange(int[][] maps, int row, int col) {
        return (row >= 0 && row < maps.length && col >= 0 && col < maps[0].length);
    }
}