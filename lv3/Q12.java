package lv3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q12 {
    public static void main(String[] args){
        int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};

        SolutionQ12 solution = new SolutionQ12();
        consoleOut(solution.solution(game_board, table));
    }

    private static void consoleOut(int result) {
        System.out.println(result); // 14
    }
}

class SolutionQ12 {
    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;
        List<List<int[]>> emptySpace = new ArrayList<>();

        for (int i = 0; i < game_board.length; i++) {
            for (int k = 0; k < game_board[i].length; k++) {
                if (game_board[i][k] == 0) {
                    emptySpace.add(bfs(game_board, i, k));
                }
            }
        }

        // Spin And Compare...

        return answer;
    }

    private List<int[]> bfs(int[][] board, int row, int col) {
        List<int[]> result = new ArrayList<>();
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        board[row][col] = 0;
        result.add(new int[]{0, 0});

        int[][] cardinalPoints = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!queue.isEmpty()) {
            int[] location = queue.poll();

            for (int[] cardinalPoint : cardinalPoints) {
                int[] nextLocation = {location[0] + cardinalPoint[0], location[1] + cardinalPoint[1]};

                if (canGo(board, nextLocation[0], nextLocation[1])) {
                    queue.add(nextLocation);
                    result.add(new int[] {nextLocation[0] - row, nextLocation[1] - col});
                    board[nextLocation[0]][nextLocation[1]] = 0;
                }
            }
        }

        return result;
    }

    private boolean canGo(int[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            if (board[row][col] == 1) {
                return true;
            }
        } 

        return false;
    }
}