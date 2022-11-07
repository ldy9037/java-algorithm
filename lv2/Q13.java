package lv2;

import java.util.Arrays;
import java.util.LinkedList;

public class Q13 {
    public static void main(String[] args){
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        SolutionQ13 solution = new SolutionQ13();
        consoleOut(solution.solution(people, limit));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }
}

class SolutionQ13 {
    public int solution(int[] peoples, int limit) {
        int answer = 0;
        Arrays.sort(peoples);
        LinkedList<Integer> sortedPeople = new LinkedList<>();
        for (int people : peoples) {
            sortedPeople.addLast(people);
        }
        
        while (!sortedPeople.isEmpty()) {
            answer++;
            int weight = sortedPeople.removeLast();
            
            if (!sortedPeople.isEmpty()) {
                int lightest = sortedPeople.getFirst();

                if (weight + lightest <= limit) {
                    weight += lightest;
                    sortedPeople.removeFirst();
                }
            }
        }

        return answer;
    }
}