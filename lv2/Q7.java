package lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q7 {
    public static void main(String[] args){
        String numbers = "17";

        SolutionQ7 solution = new SolutionQ7();
        consoleOut(solution.solution(numbers));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }
}

class SolutionQ7 {
    private static final int MINIMUM = 2;

    public int solution(String numbers) {
        List<Integer> permutation = permutation(numbers);
        List<Integer> allNum = IntStream.range(MINIMUM, (int) Math.sqrt(Collections.max(permutation)) + 1)
            .boxed()
            .collect(Collectors.toList()); 

        int i = 0;

        while (i < allNum.size()) {
            int primeNumber = allNum.get(i);
            filteringNotPrimeNumber(allNum, primeNumber);
            filteringNotPrimeNumber(permutation, primeNumber);

            i++;
        }

        return permutation.size();
    }

    private void filteringNotPrimeNumber(List<Integer> numList, int primeNumber) {
        Iterator<Integer> iterator = numList.iterator();
        
        while (iterator.hasNext()) {
            removeNotPrimeNumber(iterator, primeNumber);
        }    
    }

    private void removeNotPrimeNumber(Iterator<Integer> iterator, int primeNumber) {
        int current = iterator.next();

        if (current % primeNumber == 0 && current / primeNumber != 1) {
            iterator.remove();
        }
    }

    private List<Integer> permutation(String numbers) {
        List<Integer> numList = numbers.chars()
                .mapToObj(c -> (char) c)
                .mapToInt(c -> Character.getNumericValue(c))
                .boxed()
                .collect(Collectors.toList());

        return new ArrayList<Integer>(dfs(0, numList));
    }

    private Set<Integer> dfs(int base, List<Integer> numList) {
        Set<Integer> result = new HashSet<>();

        for(int i = 0; i < numList.size(); i++) {
            List<Integer> copiedNumList = new LinkedList<>(numList);
            
            int newBase = sumStringNumber(base, copiedNumList.remove(i));

            if (newBase == 0) continue;
            if (newBase != 1) {
                result.add(newBase);
            }

            result.addAll(dfs(newBase, copiedNumList));
        }

        return result;
    }

    private int sumStringNumber(int base, int number) {
        if (base == 0) {
            return number;
        }

        String stringNumber = Integer.toString(base) + Integer.toString(number);
        return Integer.parseInt(stringNumber);
    }
}