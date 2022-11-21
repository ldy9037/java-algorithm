package lv3;

import java.util.LinkedList;
import java.util.Queue;

public class Q10 {
    public static void main(String[] args){
        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;

        SolutionQ10 solution = new SolutionQ10();
        consoleOut(solution.solution(rectangle, characterX, characterY, itemX, itemY));
    }

    private static void consoleOut(int result) {
        System.out.println(result); // 17
    }
}

class SolutionQ10 {
    public int solution(int[][] rectangleArr, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        int[][] map = createMap();
        
        for (int[] rectangle : rectangleArr) {
            drawRectangle(map, rectangle[0] * 2, rectangle[1] * 2, rectangle[2] * 2, rectangle[3] * 2);
        }

        Queue<int[]> queue = new LinkedList<>();

        map[characterX * 2][characterY * 2] = -1;
        queue.add(new int[] {characterX * 2, characterY * 2, 0});

        while (!queue.isEmpty()) {
            int[] character = queue.poll();

            if (character[0] == itemX * 2 && character[1] == itemY * 2) {
                answer = character[2];
            }

            findNext(map, queue, new int[] {character[0] - 1, character[1], character[2] + 1});
            findNext(map, queue, new int[] {character[0], character[1] - 1, character[2] + 1});
            findNext(map, queue, new int[] {character[0] + 1, character[1], character[2] + 1});
            findNext(map, queue, new int[] {character[0], character[1] + 1, character[2] + 1});
        }

        return answer / 2;
    }

    private void findNext(int[][] map, Queue<int[]> queue, int[] character) {
        if (map[character[0]][character[1]] == 1) {
            map[character[0]][character[1]] = -1;
            queue.add(character);
        }
    }

    private int[][] createMap() {
        int[][] result = new int[102][102];

        for (int i = 0; i <= 100; i++) {
            for (int k = 0; k <= 100; k++) {
                result[i][k] = 0;
            }    
        }

        return result;
    }

    private void drawRectangle(int[][] map, int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int k = y1; k <= y2; k++) {
                if (map[i][k] == -1) {
                    continue;
                } 

                if (i == x1 || i == x2 || k == y1 || k == y2) {
                    map[i][k] = 1;  
                    continue;
                }

                map[i][k] = -1;
            }
        }
    }
}