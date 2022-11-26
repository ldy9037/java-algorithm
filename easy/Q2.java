package easy;

import java.util.Comparator;
import java.util.List;

// Parallel Processing
class Result {

    /*
     * Complete the 'minTime' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY files
     *  2. INTEGER numCores
     *  3. INTEGER limit
     */

    public static long minTime(List<Integer> files, int numCores, int limit) {
        
        long answer = 0;
    
        files.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        
        for (int file : files) {
            if (file % numCores == 0 && limit > 0) {
                file = file / numCores;
                limit--;
            }
            
            answer += file;
        }
        
        return answer;    
    }

}