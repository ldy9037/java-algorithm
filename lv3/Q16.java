package lv3;

import java.util.Arrays;
import java.util.Comparator;

public class Q16 {
    public static void main(String[] args){
        int e = 8;
        int[] starts = {1,3,7};

        SolutionQ16 solution = new SolutionQ16();
        consoleOut(solution.solution(e, starts));
    }

    private static void consoleOut(int[] result) {
        System.out.println(Arrays.toString(result));
    }
}

class SolutionQ16 {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];

        TableCount[] tableCounts = new TableCount[e];

        for (int i = 1; i <= e; i++) {
            int multiple = i;

            while (multiple <= e) {
                if (tableCounts[multiple - 1] == null) {
                    tableCounts[multiple - 1] = new TableCount(multiple, 0);
                }
                
                tableCounts[multiple - 1].countUp();
                multiple += i;
            }
        }

        Arrays.sort(tableCounts, new Comparator<TableCount>() {
            @Override
            public int compare(TableCount o1, TableCount o2) {
                return o2.count - o1.count;
            }
        });
        
        for (int i = 0; i < starts.length; i++) {
            for (TableCount tableCount : tableCounts) {
                if (tableCount.getIndex() >= starts[i]) {
                    answer[i] = tableCount.getIndex();
                    break;
                }
            }
        }

        return answer;
    }
}

class TableCount {
    int index;
    int count;

    TableCount(int index, int count) {
        this.index = index;
        this.count = count;
    }

    public void countUp() {
        count++;
    }

    public int getIndex() {
        return index;
    }
}