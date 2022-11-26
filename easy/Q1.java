package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Balanced System File Partition
class Result {

    /*
     * Complete the 'mostBalancedPartition' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY parent
     *  2. INTEGER_ARRAY files_size
     */

    static int sum = 0;
    static int answer = Integer.MAX_VALUE;

    public static int mostBalancedPartition(List<Integer> parent, List<Integer> files_size) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < parent.size(); i++) {
            putWithDefault(map, parent.get(i) ,i);   
        }
        sum = files_size.stream().mapToInt(i -> i).sum();
        int start = parent.indexOf(-1);
        dfs(start, map, files_size);
        
        return answer;
    }
    
    private static void putWithDefault(Map<Integer, List<Integer>> map, int parent, int child) {
        if (!map.containsKey(parent)) {
            map.put(parent, new ArrayList<>());
        }
        
        map.get(parent).add(child);
    }
    
    private static int dfs(int current, Map<Integer, List<Integer>> children, List<Integer> files_size) {
        int totalFileSize = files_size.get(current);
    
        if (children.containsKey(current)) {
            for (int child : children.get(current)) {
                totalFileSize += dfs(child, children, files_size);
            }
        }
        
        int candidate = Math.abs(sum - (totalFileSize * 2));
        if (candidate < answer) {
            answer = candidate;
        }

        files_size.set(current, totalFileSize);
        return totalFileSize;
    }
}