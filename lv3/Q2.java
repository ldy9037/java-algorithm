package lv3;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q2 {
    public static void main(String[] args){
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        SolutionQ2 solution = new SolutionQ2();
        consoleOut(solution.solution(operations));
    }

    private static void consoleOut(int[] result) {
        System.out.println(Arrays.toString(result));
    }
}

class SolutionQ2 {
    DoublePriorityQueue doublePriorityQueue = new DoublePriorityQueue();

    public int[] solution(String[] operations) {
        for (String operation : operations) {
            String[] command = operation.split(" ");
            
            selectMessage(command[0], command[1]);
        }

        int[] answer = {doublePriorityQueue.max(), doublePriorityQueue.min()};
        
        return answer;
    }

    private void selectMessage(String command, String argument) {
        if (command.equals("D")) {
            doublePriorityQueue.remove(argument);
        }

        if (command.equals("I")) {
            doublePriorityQueue.add(Integer.parseInt(argument));
        }
    }
}

class DoublePriorityQueue {

    private int size = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public int max() {
        if (maxHeap.isEmpty()) {
            return 0;
        }

        return maxHeap.peek();
    }

    public int min() {
        if (minHeap.isEmpty()) {
            return 0;
        }

        return minHeap.peek();
    }

    public void remove(String operator) {
        if (size > 0) {
            selectHeap(operator).poll();
            sizeDown();
        }
    }
    
    private PriorityQueue<Integer> selectHeap(String operator) {
        return (operator.equals("1")) ? maxHeap : minHeap;
    }

    public void add(int e) {
        minHeap.offer(e);
        maxHeap.offer(e);

        size++;
    }

    private void doEmpty() {
        maxHeap.clear();
        minHeap.clear();
    }

    private void sizeDown() {
        if (size > 0) {
            size--;
        }

        if (size == 0) {
            doEmpty(); 
        }
    }
}