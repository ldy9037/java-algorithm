package lv3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Q1 {
    public static void main(String[] args){
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};

        SolutionQ1 solution = new SolutionQ1();
        consoleOut(solution.solution(jobs));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }   
}

class SolutionQ1 {
    public int solution(int[][] jobs) {
        int answer = 0;
        int currentTime = 0;

        PriorityQueue<Disk> heap = new PriorityQueue<>();
        List<Disk> disks = Disk.of(jobs);
        
        while (!heap.isEmpty() || !disks.isEmpty()) {
            if (!disks.isEmpty()) {
                findCanStartDisks(disks, heap, currentTime);
            }
            
            if (heap.isEmpty()) {
                currentTime++;
                continue;
            }
            
            Disk disk = heap.poll();

            answer += disk.calculateTotalTime(currentTime);
            currentTime = disk.endTime(currentTime);
        }

        return (int) answer / jobs.length;
    }

    private void findCanStartDisks(
        List<Disk> disks, 
        PriorityQueue<Disk> heap, 
        int currentTime
    ) {
        Iterator<Disk> iterator = disks.iterator();

        while (iterator.hasNext()) {
            Disk disk = iterator.next();
            
            if (disk.canStart(currentTime)) {
                iterator.remove();
                heap.offer(disk);
            }
        }
    }
}

class Disk implements Comparable<Disk>{
    private int startTime;
    private int workTime;

    private Disk(int startTime, int workTime) {
        this.startTime = startTime;
        this.workTime = workTime;
    }

    public static List<Disk> of(int[]... disks) {
        List<Disk> result = new LinkedList<>();
        
        for (int[] disk : disks) {
            result.add(new Disk(disk[0], disk[1]));
        }

        return result;
    }

    public int calculateTotalTime(int currentTime) {
        return endTime(currentTime) - startTime;
    }

    public int endTime(int currentTime) {
        return currentTime + workTime;
    }

    public boolean canStart(int currentTime) {
        return startTime <= currentTime;
    }

    @Override
    public int compareTo(Disk that) {
        return workTime - that.workTime;
    }
}