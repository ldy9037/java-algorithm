package lv2;

import java.util.ArrayList;
import java.util.List;

public class Q11 {
    public static void main(String[] args){
        String word = "I";
        
        SolutionQ11 solution = new SolutionQ11();
        consoleOut(solution.solution(word));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }
}

class SolutionQ11 {
 
    String[] letters = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        List<String> dictionary = new ArrayList<>();
        dfs(dictionary, "");

        return dictionary.indexOf(word) + 1;
    }

    private void dfs(List<String> dictionary, String word) {
        if (word.length() == letters.length) {
            return;
        } 

        for (String letter : letters) {
            String newWord = word + letter;

            dictionary.add(newWord);
            dfs(dictionary, newWord);
        }
    }
}