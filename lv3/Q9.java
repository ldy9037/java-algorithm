package lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q9 {
    public static void main(String[] args){
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        SolutionQ9 solution = new SolutionQ9();
        consoleOut(solution.solution(begin, target, words));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }
}

class SolutionQ9 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(begin, Arrays.asList(words), 0));

        while (!queue.isEmpty()) {
            Word word = queue.poll();
            
            if (word.isEqualsTo(target)) {
                answer = word.getDepth();
                break;    
            }
            
            queue.addAll(word.findChildrenWord());
        }

        return answer;
    }
}

class Word {
    private String current;
    private List<String> candidates;
    private int depth;

    Word(String current, List<String> candidates, int depth) {
        this.current = current;
        this.candidates = candidates;
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }

    public List<Word> findChildrenWord() {
        List<Word> result = new ArrayList<>();
        
        for (int i = 0; i < candidates.size(); i++) {
            if (canChange(candidates.get(i))) {
                result.add(new Word(candidates.get(i), copyAndRemoveWord(i), depth + 1));
            } 
        }

        return result;
    }

    public boolean isEqualsTo(String target) {
        return (current.equals(target));
    }

    private List<String> copyAndRemoveWord(int index) {
        List<String> newCandidates = new ArrayList<>();
        
        for (int i = 0; i < candidates.size(); i++) {
            if (i != index) {
                newCandidates.add(candidates.get(i));    
            }
        }

        return newCandidates;
    }

    private boolean canChange(String candidate) {
        int notSame = 0;

        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != candidate.charAt(i)) {
                notSame++;
            }

            if (notSame > 1) {
                return false;
            }
        }   

        return true;
    }   
}
