package lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q6 {
    public static void main(String[] args){
        int[] answers = {1, 3, 2, 4, 2};

        SolutionQ6 solution = new SolutionQ6();
        consoleOut(solution.solution(answers));
    }

    private static void consoleOut(int[] result) {
        System.out.println(Arrays.toString(result) );
    }
}

class SolutionQ6 {
    
    private List<Student> students = new ArrayList<>();

    SolutionQ6() {
        students.add(new Student(1, 2, 3, 4, 5));
        students.add(new Student(2, 1, 2, 3, 2, 4, 2, 5));
        students.add(new Student(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));
    }

    public int[] solution(int[] answers) {
        List<Integer> result = new ArrayList<>();

        for (Student student : students) {
            result.add(student.checkAnswer(answers));
        }
       
        return winners(result);
    }    

    private int maxScore(List<Integer> scores) {
        return scores.stream()
                .mapToInt(i -> i)
                .max()
                .getAsInt();
    }

    private int[] winners(List<Integer> scores) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < scores.size(); i++) {
            if (isWinner(scores.get(i), maxScore(scores))) {
                result.add(i + 1);
            }
        }

        return result.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    private boolean isWinner(int score, int maxScore) {
        return (score == maxScore);
    }
}

class Student {
    private final List<Integer> pattern;

    Student(int... pattern) {
        this.pattern = IntStream.of(pattern)
                .boxed()
                .collect(Collectors.toList());
    }

    public int checkAnswer(int[] answers) {
        int result = 0;

        for (int i = 0; i < answers.length; i++) {
            result += (isAnswer(i, answers[i])) ? 1 : 0;
        }

        return result;
    }
   
    private boolean isAnswer(int questionNumber, int answer) {
        return (answer == pattern.get(questionNumber % pattern.size()));
    }
}