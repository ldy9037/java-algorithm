package lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q9 {
    public static void main(String[] args){
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {31, 10}};

        SolutionQ9 solution = new SolutionQ9();
        consoleOut(solution.solution(k, dungeons));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }
}

class SolutionQ9 {
    List<Integer> visitCount = new ArrayList<>();

    public int solution(int k, int[][] dungeons) {
        visitCount.clear();

        List<Dungeon> dungeonList = new LinkedList<>();
        for (int[] dungeon : dungeons) {
            dungeonList.add(new Dungeon(dungeon[0], dungeon[1]));
        }

        dfs(new Player(k, 0), dungeonList);

        return visitCount.stream()
                .mapToInt(i -> i)
                .max()
                .getAsInt();
    }

    private void dfs(Player player, List<Dungeon> dungeons) {
        for (int i = 0; i < dungeons.size(); i++) {
            List<Dungeon> remainderDungeons = new LinkedList<>(dungeons);
            Player copyPlayer = new Player(player);
    
            if (remainderDungeons.remove(i).enter(copyPlayer)) {
                dfs(copyPlayer, remainderDungeons);
            }

            visitCount.add(copyPlayer.getVisitCount());
        }
    }
}

class Dungeon {
    private final int need;
    private final int usage;

    Dungeon(int need, int usage) {
        this.need = need;
        this.usage = usage;
    }
    
    public boolean enter(Player player) {
        if (canEnter(player)) {
            player.consume(usage);
            player.visitCountUp();
            return true; 
        }

        return false;
    }

    private boolean canEnter(Player player) {
        return player.getFatigue() >= need; 
    }
}

class Player {
    private int fatigue;
    private int visitCount;
    
    Player(int fatigue, int visitCount) {
        this.fatigue = fatigue;
        this.visitCount = visitCount;
    }

    Player(Player player) {
        this.fatigue = player.fatigue;
        this.visitCount = player.visitCount;
    }

    public void consume(int usage) {
        fatigue -= usage;
    }

    public int getFatigue() {
        return fatigue;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void visitCountUp() {
        visitCount++;
    }
}