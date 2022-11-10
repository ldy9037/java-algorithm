package lv3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q5 {
    public static void main(String[] args){
        int N = 5;
        int number = 12;

        SolutionQ5 solution = new SolutionQ5();
        consoleOut(solution.solution(N, number));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }
}

class SolutionQ5 {
    public int solution(int N, int number) {
        int answer = -1;

        List<Set<Integer>> numberHistroy = new ArrayList<>();

        for (int i = 1; i <= 8; i++) {
            Set<Integer> newNumberList = new HashSet<>();
            newNumberList.add(stringAdd(N, i));
            
            for (int k = 0; k < Math.ceil(numberHistroy.size() / (double) 2); k++) {
                
                for (int fNumber : numberHistroy.get(k)) {
                    for (int bNumber : numberHistroy.get(numberHistroy.size() - (k + 1))) {
                        newNumberList.add(fNumber + bNumber);
                        if (fNumber - bNumber > 0) {
                            newNumberList.add(fNumber - bNumber);
                        }
                        newNumberList.add(fNumber * bNumber);
                        
                        if (fNumber % bNumber == 0) {
                            newNumberList.add(fNumber / bNumber);
                        }
                        if (bNumber % fNumber == 0) {
                            newNumberList.add(bNumber / fNumber);
                        }
                    }
                }
            }

            if (newNumberList.contains(number)) {
                answer = i;
                break;
            }

            numberHistroy.add(newNumberList);
        }

        return answer;
    }

    private int stringAdd(int N, int count) {
        String result = "";

        for (int i = 0; i < count; i++) {
            result += N;
        }

        return Integer.parseInt(result);
    }
}