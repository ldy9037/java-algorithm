package lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q16 {
    public static void main(String[] args){
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        SolutionQ16 solution = new SolutionQ16();
        consoleOut(solution.solution(k, tangerine));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }
}

class SolutionQ16 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int t : tangerine) {
            putWithDefault(countMap, t);
        }

        List<Integer> countList = new ArrayList<>(countMap.values());

        countList.sort(Collections.reverseOrder());

        for (int count : countList) {
            k -= count;
            answer++;
            if (k <= 0) {
                break;
            } 
        }

        return answer;
    }

    private void putWithDefault(Map<Integer, Integer> countMap, int key) {
        if (!countMap.containsKey(key)) {
            countMap.put(key, 0);
        }

        countMap.put(key, countMap.get(key) + 1);
    }
}