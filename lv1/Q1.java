package lv1;

import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] nums) {
        int result = Arrays
                .stream(nums)
                .boxed()
                .collect(Collectors.toSet())
                .size();        

        if (result > pickCount(nums.length)) {
            result = pickCount(nums.length);
        }

        return result;
    }

    private int pickCount(int size) {
        return (size / 2);
    }
}

public class Q1 {
    public static void main(String[] args){
            int[] input = {3, 1, 2, 3};

            Solution solution = new Solution();
            consoleOut(solution.solution(input));
    }

    private static void consoleOut(int result) {
        System.out.println(result);
    }
}