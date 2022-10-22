package lv2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q5 {
    public static void main(String[] args){
        int[] numbers = {0,0};

        SolutionQ5 solution = new SolutionQ5();
        consoleOut(solution.solution(numbers));
    }

    private static void consoleOut(String result) {
        System.out.println(result);
    }
}

class SolutionQ5 {
    public String solution(int[] numbers) {
        List<String> numberList = IntStream.of(numbers)
                .boxed()
                .sorted((e1, e2) -> compare(e1, e2))
                .map(Object::toString)
                .collect(Collectors.toList());

        if (numberList.get(0).equals("0")) {
            return "0";
        }

        return String.join("", numberList);
    }
    
    private int compare(int num1, int num2) {
        int result = 0;
        int i = 0;

        while (result == 0 && i < 4) {
            result = digitCompare(getDigit(num1, i), getDigit(num2, i));
            i++;
        }

        return result;
    }

    private int digitCompare(int digit1, int digit2) {
        return digit2 - digit1;
    }

    private int getDigit(int num, int index) {
        String strNum = Integer.toString(num);
        
        while (strNum.length() < index + 1) {
            strNum += strNum;
        }

        return Character.getNumericValue(strNum.charAt(index));
    }
}