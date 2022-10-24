package lv2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q6 {
    public static void main(String[] args){
        int[] citations = {3, 3, 3};

        Solution6Sub solution = new Solution6Sub();
        consoleOut(solution.solution(citations));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }
}

class SolutionQ6 {
    public int solution(int[] citations) {
        int answer = 0;

        List<Paper> papers = IntStream.of(citations)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .map(Paper::new)
                .collect(Collectors.toList());

        for (Paper paper : papers) {
            answer = canIndexUp(paper, answer);
        }

        return answer;
    }

    private int canIndexUp(Paper paper, int index) {
        if (paper.isGreaterThan(index)) {
            index++;
        }

        return index;
    }
}

class Paper {
    private int citation;

    Paper(int citation) {
        this.citation = citation;
    }
    
    public boolean isGreaterThan(int count) {
        return (citation != 0 && citation > count);
    }
}