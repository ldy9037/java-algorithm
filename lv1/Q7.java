package lv1;

import java.util.Iterator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q7 {
    public static void main(String[] args){
        int n = 5;
        int[] lost = {3};
        int[] reserve = {1};

        SolutionQ7 solution = new SolutionQ7();
        consoleOut(solution.solution(n, lost, reserve));
    }

    private static void consoleOut(int result) {
        System.out.println("결과 : "+result);
    }
}

class SolutionQ7 {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = arrayToList(lost);
        
        give(lostList, arrayToList(reserve));

        return n - lostList.size();
    }

    private List<Integer> arrayToList(int[] array) {
        return IntStream.of(array)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
    }

    private void give(List<Integer> lost, List<Integer> reserve) {
        filterSameSize(lost, reserve);
        
        for (int size : reserve) {
            find(lost, size);
        }        
    }

    private void filterSameSize(List<Integer> lost, List<Integer> reserve) {
        Iterator<Integer> iterator = reserve.iterator();

        while (iterator.hasNext()) {
            int size = iterator.next();

            if (isMine(lost, size)) {
                lost.remove(new Integer(size));
                iterator.remove();
            }
        }
    }

    private void find(List<Integer> lost, int size) {
        OptionalInt pullNumber = lost.stream()
                .filter(lostSize -> canGive(lostSize, size))
                .mapToInt(i -> i)
                .min();

        if(pullNumber.isPresent()) {
            lost.remove(new Integer(pullNumber.getAsInt()));
        }
    }

    private boolean canGive(int lostSize, int size) {
        return (size + 1 == lostSize || size - 1 == lostSize);
    }

    private boolean isMine(List<Integer> lost, int size) {
        return lost.indexOf(size) >= 0;
    }
}